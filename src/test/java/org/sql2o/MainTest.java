package org.sql2o;

import org.sql2o.pojos.UserDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: huixiao200068
 * Date: 13-6-18
 * Time: 下午4:44
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {
    private static Sql2o sql2o;

    static {
        sql2o = new Sql2o("jdbc:mysql://localhost:3306/test", "root", "root");
    }

    public static List<UserDTO> getAll() {
        String sql = "select id, name, age from test";
        return sql2o.createQuery(sql).executeAndFetch(UserDTO.class);
    }

    public static UserDTO getById(int id) {
        String sql = "select id, name, age from test where id = :id";
        return sql2o.createQuery(sql).addParameter("id", id).executeAndFetchFirst(UserDTO.class);
    }

    public static int insert(UserDTO test) {
        String sql = "insert into test(name, age) values (:name, :age)";
        Connection connection = sql2o.createQuery(sql).addParameter("name", test.getName()).addParameter("age", test.getAge()).executeUpdate();
        return connection.getResult();
    }

    public static int update(UserDTO test) {
        String sql = "update test set name = :name, age = :age where id = :id";
        Connection connection = sql2o.createQuery(sql).addParameter("name", test.getName()).addParameter("age", test.getAge()).addParameter("id", test.getId()).executeUpdate();
        return connection.getResult();
    }

    public static void main(String[] args) {
        //查询所有
        List<UserDTO> list = getAll();
        System.out.println("size = " + list.size());

        //按条件查询
        UserDTO test = getById(3);
        System.out.println(test.getName());

        //插入测试
//        Test test1 = new Test();
//        test1.setName("yyy");
//        test1.setAge(25);
//        int result = insert(test1);
//        System.out.println("insert result: " + result);

        test.setAge(22);
        int result = update(test);
        System.out.println("update result: " + result);
    }
}
