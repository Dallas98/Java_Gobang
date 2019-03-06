package loginUI;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: Java五子棋
 * @description:
 * @author: 阳鹏
 * @create: 2018-12-14 13:24
 */
public class Login extends JFrame {
    static JButton loginButton;
    static JButton registerButton;
    static JButton resetButton;
    static JLabel loginLabel;
    static JFrame loginFrame;
    static JTextField nameText;
    static JPasswordField passwordText;
    static JLabel labelAdmin;
    static JLabel labelPassword;
    static JLabel text;
    ImageIcon background;

    ActionListener listener=new ReaderListen();

    public Login() {
        Font font = new Font("宋体", Font.BOLD, 20);
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,
                192));
        loginFrame = new JFrame("登录");
        loginFrame.setSize(550, 350);

        text=new JLabel("欢迎登陆Dallas的五子棋");
        text.setBounds(27,20,510,80);
        text.setFont(new Font("宋体",Font.BOLD,40));

        labelAdmin = new JLabel("用户名:");
        labelAdmin.setBounds(110, 120, 80, 40);
        labelAdmin.setFont(font);

        labelPassword = new JLabel("密码:");
        labelPassword.setBounds(110, 175, 80, 40);
        labelPassword.setFont(font);

        background = new ImageIcon("src/res/images/登录背景.jpg");
        loginLabel = new JLabel(background);

        registerButton = new JButton("注册");
        registerButton.setBounds(120, 240, 80, 40);
        setStyle(registerButton);

        resetButton = new JButton("忘记密码");
        resetButton.setBounds(225, 240, 120, 40);
        setStyle(resetButton);

        loginButton = new JButton("登录");
        loginButton.setBounds(370, 240, 80, 40);
        setStyle(loginButton);

        //加入文本框
        nameText = new JTextField();
        nameText.setBounds(190, 120, 250, 40);
        nameText.setFont(font);
        nameText.setOpaque(false);
        nameText.setBorder(border);

        passwordText = new JPasswordField();
        passwordText.setBounds(190, 175, 250, 40);
        passwordText.setFont(font);
        passwordText.setOpaque(false);//无底色
        passwordText.setBorder(border);

        loginLabel.add(text);
        loginLabel.add(nameText);
        loginLabel.add(passwordText);
        loginLabel.add(labelAdmin);
        loginLabel.add(labelPassword);

        loginLabel.add(loginButton);
        loginLabel.add(registerButton);
        loginLabel.add(resetButton);

        background = new ImageIcon("src/res/images/blackChess.png");
        loginFrame.setIconImage(background.getImage());
        loginFrame.add(loginLabel);
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        //监听
        loginButton.addActionListener(listener);
        registerButton.addActionListener(listener);
        resetButton.addActionListener(listener);
    }

    public static String getAdmin(){
        return nameText.getText();
    }
    public static String getPassword(){
        return new String(passwordText.getPassword());
    }

    public static JFrame getLoginFrame(){
        return loginFrame;
    }
    public static JButton getLoginButton(){return loginButton;}
    public static JButton getRegisterButton(){return registerButton;}
    public static JButton getResetButton(){return resetButton;}

    public static void setStyle(JButton jButton){
        Font font = new Font("宋体", Font.BOLD, 20);
        jButton.setFont(font);
        jButton.setBorder(null);
        jButton.setContentAreaFilled(false);
        jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));//变成手型
    }

    public static void main(String args[]) { new Login(); }

}