package FiveChess;

import NetGobang.MainFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @program: Java五子棋
 * @description:
 * @author: 阳鹏
 * @create: 2018-12-18 13:58
 */

public class Main extends JFrame {

    private Mypanel contentPane;
    static private JButton Button1;
    static private JButton Button2;

    public Main() {
        // ----------------------创建窗口---------------------------------
        setTitle("JAVA五子棋          By:阳鹏          Email:990259227@qq.com");
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(0, 0, 1024, 632);
        contentPane = new Mypanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 处理人机对战的点击事件
        Button1 = new JButton("人 机 对 战");
        Button1.setBackground(Color.LIGHT_GRAY);
        Button1.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        Button1.setBounds(600, 400, 381, 123);// 两个按钮时的位置
        // Button1.setBounds(555, 320, 381, 123);//1个按钮的位置
        contentPane.add(Button1);

        Button2 = new JButton("联 机 对 战");
        Button2.setBackground(Color.LIGHT_GRAY);
        Button2.setFont(new Font("微软雅黑", Font.PLAIN, 60));
        Button2.setBounds(600, 250, 381, 123);// 两个按钮时的位置
        // Button1.setBounds(555, 320, 381, 123);//1个按钮的位置
        contentPane.add(Button2);

        setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Email:990259227@qq.com");
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println("你好的!");
            }
        });
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel.setBounds(869, 578, 149, 25);
        contentPane.add(lblNewLabel);
        // -------------------------------------------------------
    }

    public void A() {
        //public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main MainWindow = new Main();
                    MainWindow.setVisible(true);
                    Button1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                            ChessBoard chessboard = new ChessBoard();// 创建棋盘窗口
                            chessboard.setVisible(true);// 可见性设置为可见
                            MainWindow.setVisible(false);// 主窗口设置为隐藏
                        }
                    });
                    Button2.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
//                            MainFrame mainFrame=new MainFrame();// 创建棋盘窗口
//                            mainFrame.setVisible(true);
//                            mainFrame.Net();
//                            mainFrame.dispose();// 可见性设置为可见
                            new MainFrame().Net();
                            MainWindow.setVisible(false);// 主窗口设置为隐藏
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}


