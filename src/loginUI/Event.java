package loginUI;

import FiveChess.Main;
import database.DatabaseConnect;

import javax.swing.*;
import java.sql.*;

/**
 * @program: Java五子棋
 * @description:
 * @author: 阳鹏
 * @create: 2018-12-14 17:57
 */
class Event {
    //注册新用户
    public static void registerButton(){
        new Register(new JFrame("注册新用户"),"注册");
    }

    //登录
    public static void LoginButton() {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        String sql = "select * from loginID";
        try {
            conn = DatabaseConnect.getConnect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            String admin = Login.getAdmin();
            String password =Login.getPassword();
            boolean isTrue=false;
            while (rs.next()) {
                String id = rs.getString("id");
                String psw = rs.getString("psw");
                if (id.equals(admin) && psw.equals(password)) {
                   Login.getLoginFrame().setVisible(false);
//                    JFrame jFrame = new JFrame("新窗体");
//                    jFrame.setSize(300, 200);
//                    jFrame.setVisible(true);
                   Login.getLoginFrame().dispose();
                    isTrue=true;
                    new Main().A();
                    break;
                }
            }
            if(!isTrue){
                JOptionPane.showMessageDialog(null,"账号或密码错误",
                        "提示",JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("登陆失败");
        }
    }

    //忘记密码
    public static void resetButton(){
        new Register(new JFrame("重置用户密码"),"确定");

    }

    //注册新用户确定
    public static void register(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
        boolean isTrue=false;
        try {
            conn= DatabaseConnect.getConnect();
            String sql="select id from loginID";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            String admin=Register.getAdmin();
            int n=new String(Register.getAdmin()).length();
            while (rs.next()){
                String id=rs.getString("id");
                if(admin.equals(id)){
                    isTrue=true;
                    break;
                }
            }
            if(isTrue){
                JOptionPane.showMessageDialog(null,"账号已存在！",
                        "警告",JOptionPane.WARNING_MESSAGE);
            }
            else if(!isTrue&&Register.getPassword().equals(Register.getPasswordAgain())&&
                    !(Register.getAdmin().equals(""))&&n>=6){
                sql="insert into loginID(id,psw) values (?,?)";
                PreparedStatement pre= conn.prepareStatement(sql);
                pre.setString(1,Register.getAdmin());
                pre.setString(2,Register.getPassword());
                System.out.println("写入成功  ("+pre.executeUpdate()+"行受影响)");
                JOptionPane.showMessageDialog(null,"注册成功",
                        "",JOptionPane.WARNING_MESSAGE);
                cancel();
                pre.close();
                conn.close();
            }
            else{
                JOptionPane.showMessageDialog(null,"密码太短或密码存在错误！",
                        "警告",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (SQLException se){
            se.printStackTrace();
            System.out.println("注册失败");
        }
    }

    //重置密码确定
    public static void reset(){
        boolean isTrue=false;
        Connection conn;
        Statement stmt;
        ResultSet rs;
        try {
            conn= DatabaseConnect.getConnect();
            String sql="select id from loginID";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            String admin=Register.getAdmin();
            while (rs.next()) {
                String id = rs.getString("id");
                if (admin.equals(id)) {
                    isTrue = true;
                    break;
                }
            }
            boolean bl=Register.getPassword().equals(Register.getPasswordAgain())&&
                    (new String(Register.getAdmin()).length())>=6;
            if(isTrue&&bl){
                sql="update loginID set psw=? where id=?";
                PreparedStatement pre= conn.prepareStatement(sql);
                pre.setString(2,Register.getAdmin());
                pre.setString(1,Register.getPassword());
                System.out.println("修改成功  ("+pre.executeUpdate()+"行受影响)");
                JOptionPane.showMessageDialog(null,"修改成功",
                        "",JOptionPane.WARNING_MESSAGE);
                cancel();
                pre.close();
                conn.close();

            }
            else if(!isTrue){
                JOptionPane.showMessageDialog(null,"账号不存在",
                        "",JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null,"密码输入有误或不足6位",
                        "",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (SQLException se){
            se.printStackTrace();
            System.out.println("修改失败");
        }

    }

    //取消注册或重置密码
    public static void cancel(){
        JFrame jFrame=Register.getjFrame();
        jFrame.setVisible(true);
        jFrame.dispose();
    }
}
