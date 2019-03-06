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
 * @create: 2018-12-14 19:54
 */
public class Register {
    static JButton loginButton;
    static JButton registerButton;
    static JLabel loginLabel;
    static JTextField nameText;
    static JPasswordField passwordText;
    static JPasswordField passwordTextAgain;
    static JLabel labelAdmin;
    static JLabel labelPassword;
    static JLabel labelPasswordAagin;
    ImageIcon background;
    static String sr;
    static JFrame jFrame;

    ActionListener actionListener=new ReaderListen();

    public Register(JFrame loginFrame,String string){
        Font font = new Font("宋体", Font.BOLD, 20);
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192,
                192));
        //loginFrame = new JFrame("登录");
        loginFrame.setSize(435, 280);
        jFrame=loginFrame;
        sr=string;

        labelAdmin = new JLabel("用户名:");
        labelAdmin.setBounds(40, 20, 80, 40);
        labelAdmin.setFont(font);

        labelPassword = new JLabel("密码:");
        labelPassword.setBounds(40, 65, 80, 40);
        labelPassword.setFont(font);

        labelPasswordAagin=new JLabel("确认密码:");
        labelPasswordAagin.setBounds(40,128,100,40);
        labelPasswordAagin.setFont(font);

        background = new ImageIcon("src/res/images/登录背景.jpg");
        loginLabel = new JLabel(background);

        registerButton = new JButton(string);
        registerButton.setBounds(130, 180, 80, 40);
        Login.setStyle(registerButton);

        loginButton = new JButton("取消");
        loginButton.setBounds(215, 180, 80, 40);
        Login.setStyle(loginButton);

        //加入文本框
        nameText = new JTextField();
        nameText.setBounds(120, 20, 250, 40);
        nameText.setFont(font);
        nameText.setOpaque(false);
        nameText.setBorder(border);

        passwordText = new JPasswordField();
        passwordText.setBounds(120, 65, 250, 40);
        passwordText.setFont(font);
        passwordText.setOpaque(false);//无底色
        passwordText.setBorder(border);

        passwordTextAgain=new JPasswordField();
        passwordTextAgain.setBounds(145,125,225,40);
        passwordTextAgain.setFont(font);
        passwordTextAgain.setOpaque(false);
        passwordTextAgain.setBorder(border);

        loginLabel.add(nameText);
        loginLabel.add(passwordText);
        loginLabel.add(passwordTextAgain);
        loginLabel.add(labelAdmin);
        loginLabel.add(labelPassword);
        loginLabel.add(labelPasswordAagin);

        loginLabel.add(loginButton);
        loginLabel.add(registerButton);

        background = new ImageIcon("src/res/images/blackChess.png");
        loginFrame.setIconImage(background.getImage());
        loginFrame.add(loginLabel);
        loginFrame.setVisible(true);
        loginFrame.setLocationRelativeTo(null);

        loginButton.addActionListener(actionListener);
        registerButton.addActionListener(actionListener);
    }
    public static String getAdmin(){
        return nameText.getText();
    }
    public static String getPassword(){
        return new String(passwordText.getPassword());
    }
    public static String getPasswordAgain(){
        return new String(passwordTextAgain.getPassword());
    }
    public static JButton getLoginButton(){return loginButton;}
    public static JButton getRegisterButton(){return registerButton;}
    public static JFrame getjFrame(){return jFrame;}
    public static String getString(){return sr;}

}
