import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;

public class Conn {
    private String url="E:/makangyao/study/大三上/数据库原理/作业/作业一/作业/university_A1.accdb";
    Connection con;
    public Conn() throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con= DriverManager.getConnection("jdbc:ucanaccess://"+url);
    }
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
    //produce random 'name'
    private static String randomName(){
        String name="";
        int length1= (int) (Math.random()*7);
        //System.out.println((int)('a')+"\n"+(char)(96));
        name+=(char)(65+(int)(Math.random()*26));
        for(int i=0;i<length1;i++){
            name+=(char)(97+(int)(Math.random()*26));
        }
        name+=" ";
        name+=(char)(65+(int)(Math.random()*26));
        name+=".";
        return name;
    }
    //random sex
    private static String randomSex(){
        String sex;
        int s=(int)(Math.random()*2);
        if(s==1){
            sex="f";
        }else{
            sex="m";
        }
        return sex;
    }
    //random age
    private static int randomAge(){
        return (int)(Math.random()*10+15);
    }
    //random year
    private static int randomYear(){
        return (int)(Math.random()*5+1);
    }
    //random gpa
    private static double randomGpa(){
        double gpa=0;
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        Random random=new Random();
        gpa=random.nextDouble()*4;
        return Double.valueOf(decimalFormat.format(gpa));
    }
    //add to 5000 students
    public static void add25000(){
        try{
            String sql="";
            Conn conn=new Conn();
            for(int i=109;i<=5000;i++){
                conn.addStudent(i,randomName(),randomSex(),randomAge(),randomYear(),randomGpa());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //test Connection
    public static void testConn(){
        try{
            new Conn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }//success
    //test add
    public static void testAdd(){
        try{
            new Conn().addStudent(5002,"Narvel, L.", "m", 15, 5, 3.4);
        }catch (Exception e){
            e.printStackTrace();
        }
    }//success but always slowly
    //test delete
    public static void testDelete(){
        try{
            new Conn().delete("student","sid=5000");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        //System.out.println("Hello world!");
        //testConn();
        //testAdd();
        //System.out.println(randomName());
        /*
        for(int i=0;i<100;i++){
            System.out.println(randomGpa());
        }*/
        //add25000();
        testDelete();
    }
}
