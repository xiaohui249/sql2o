package org.sql2o.pojos;

/**
 * Created with IntelliJ IDEA.
 * User: huixiao200068
 * Date: 13-6-18
 * Time: 下午4:46
 * To change this template use File | Settings | File Templates.
 */
public class UserDTO {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
