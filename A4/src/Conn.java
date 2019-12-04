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
    //update
    private void update(String schema, String setContent, String condition){
        String sql="UPDATE "+schema+" SET "+setContent+" WHERE "+condition;
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
    //update student
    public void updateStudent(String setContent, String condition){
        update("student", setContent, condition);
    }
    //add enroll
    public void addEnroll(int sid, double grade, String dname, int cno, int sectno){
        String sql="INSERT INTO `enroll` ([sid],[grade],[dname],[cno],[sectno]) VALUES ("+
                sid+", "+grade+", '"+dname+"', "+cno+", "+sectno+")";
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
    //delete enroll
    public void deleteEnroll(String condition){
        delete("enroll", condition);
    }
    //update enroll
    public void updateEnroll(String setContent, String condition){
        update("enroll", setContent, condition);
    }
    //test function
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
    public static void testUpdate(){
        try{
            new Conn().update("student", "age=14,gpa=3.51","sid=5002");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void testUpdateStudent(){
        try{
            new Conn().updateStudent("year=8", "sname='Fred, W.'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void testAddEnroll(){
        try{
            new Conn().addEnroll(5000, 3.1, "Computer Sciences", 302, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void testUpdateEnroll(){
        try{
            new Conn().updateEnroll("sid=200","sid=5000");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void testDeleteEnroll(){
        try{
            new Conn().deleteEnroll("sid=200");
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
        //testUpdate();
        //testUpdateStudent();
        //testAddEnroll();
        //testUpdateEnroll();
        //testDeleteEnroll();
    }
}
