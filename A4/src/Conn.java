import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    private String url="E:/makangyao/study/大三上/数据库原理/作业/作业一/作业/university_A1.accdb";
    Connection con;
    public Conn() throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con= DriverManager.getConnection("jdbc:ucanaccess://"+url);
    }
    //delete
    private void delete(String schema, String condition){
        String sql="DELETE FROM `"+schema+"` WHERE "+condition;
        System.out.println(sql);
        try{
            Statement statement=con.createStatement();
            if(statement.execute(sql)){
                System.out.println("suc");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //add student
    public void addStudent(int sid, String sname, String sex, int age, int year, double gpa){
        String sql="INSERT INTO `student` ([sid],[sname],[sex],[age],[year],[gpa])" +
                " VALUES ("+sid+", '"+sname+"', '"+sex+"', "+age+", "+year+", "+gpa+")";
        System.out.println(sql);

        try{
            Statement statement=con.createStatement();
            if(statement.execute(sql)){
                System.out.println("success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //delete student
    public void deleteStudent(String condition){
        delete("student", condition);
    }
    //test add
    public static void testAddStudent(){
        try{
            new Conn().addStudent(6000, "xxx", "m", 15, 2, 3.3);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void testDelete(){
        try{
            new Conn().delete("student", "sid=6000");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void testDeleteStudent(){
        try{
            new Conn().deleteStudent("sid=5000");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        //System.out.println("hello world!");
        //testAddStudent();
        //testDelete();
        //testDeleteStudent();
    }
}
