package org.sql2o.reflection;

import org.sql2o.Sql2oException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * used internally to set property values via its setter method.
 */
public class MethodSetter implements Setter {
    
    private Method method;

    public MethodSetter(Method method) {
        this.method = method;
        this.method.setAccessible(true);
    }

    public void setProperty(Object obj, Object value) {
        if (value == null && this.method.getParameterTypes().length == 1 && this.method.getParameterTypes()[0].isPrimitive()){
            return; // dont try to set null to a setter to a primitive type.
        }
        try {
            this.method.invoke(obj, value);
        } catch (IllegalAccessException e) {
            throw new Sql2oException("error while calling setter method with name " + method.getName() + " on class " + obj.getClass().toString(), e);
        } catch (InvocationTargetException e) {
            throw new Sql2oException("error while calling setter method with name " + method.getName() + " on class " + obj.getClass().toString(), e);
        }
    }

    public Class getType() {
        return method.getParameterTypes()[0];
    }
}
