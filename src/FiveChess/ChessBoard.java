package FiveChess;





import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


/**
 * @program: Java五子棋
 * @description:
 * @author: 阳鹏
 * @create: 2018-12-20 10:22
 */

public class ChessBoard extends JFrame implements ActionListener {

	boolean isVisible = true;
	char[][] qipan = new char[15][15];// 棋盘数组
	int gx, gy, connt = 1;
	Stack chessman = new Stack(509);// 存储下棋步数
	Win who = new Win();
    final JButton button1=new JButton("退出");
    final JButton button2=new JButton("悔棋");
    final JButton button3=new JButton("开始");

    public static void main(String[] args) {
        ChessBoard chessboard = new ChessBoard();// 创建棋盘窗口
        chessboard.setVisible(true);// 可见性设置为可见
    }

	public ChessBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.UTILITY);
		setBounds(new Rectangle(0, 0, 714, 834));
        setLocationRelativeTo(null);
		setTitle("终极五子棋----人机对战模式");
		setResizable(false);

        JPanel panel1=new JPanel();
        panel1.setBounds(200,714,300,190);

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        add(panel1);


        ImageIcon background = new ImageIcon("images/登录背景.jpg");
		ChessBoardPanel chessBoardPanel = new ChessBoardPanel();
		getContentPane().add(chessBoardPanel);// 绘制棋盘并添加到面板中
		//chessBoardPanel.setLayout(null);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        // ************************************************
		this.addMouseListener(new MouseAdapter() { // 匿名内部类，鼠标事件
			public void mousePressed(MouseEvent e) { // 鼠标完成点击事件
				if (e.getButton() == MouseEvent.BUTTON1) { // e.getButton就会返回点鼠标的那个键，左键还是右健，3代表右键
					int x = e.getX(); // 得到鼠标x坐标
					int y = e.getY(); // 得到鼠标y坐标
					System.out.println("鼠标当前点击位置的坐标是" + x + "," + y);
					if ((28 < x && x < 688) && (56 < y && y < 719)) {// ((28 < x && x < 688) && (56 < y && y < 716))
						gx = (int) (x - 29) / 44;// 28
						gy = (int) (y - 60) / 44;// 56
						if (qipan[gx][gy] == '\0') {
							if (connt % 2 == 1) {
								steQipan(gx, gy, 'b');
							} else {
								steQipan(gx, gy, 'w');
							}
							connt++;
							Bot xb = new Bot(qipan, 'w');
							int[] xy = new int[2];
							xy = xb.getXY();
							steQipan(xy[0], xy[1], 'w');
							connt++;
							repaint();
							winDow();// 判断输赢
						}
					}
					System.out.println("鼠标当前点击位置的坐标是" + gx + "," + gy);
					repaint();
					winDow();// 判断输赢

				} else if (e.getButton() == MouseEvent.BUTTON3) {// 点击右键进行悔棋操作
//					isVisible = true;
//					if (!chessman.isEmpty()) {
//						gy = chessman.pop();
//						gx = chessman.pop();// 出栈
//						steQipan(gx, gy, '\0');
//						System.out.println("悔棋位置是" + gx + "," + gy);
//						gy = chessman.pop();
//						gx = chessman.pop();// 出栈
//						steQipan(gx, gy, '\0');
//						System.out.println("悔棋位置是" + gx + "," + gy);
//						connt--;
//						connt--;
//					}
//					repaint();
				}
			}
		});

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==button1){
            dispose();
            new Main().A();
        }
        if(source==button2){
            isVisible = true;
            if (!chessman.isEmpty()) {
                gy = chessman.pop();
                gx = chessman.pop();// 出栈
                steQipan(gx, gy, '\0');
                System.out.println("悔棋位置是" + gx + "," + gy);
                gy = chessman.pop();
                gx = chessman.pop();// 出栈
                steQipan(gx, gy, '\0');
                System.out.println("悔棋位置是" + gx + "," + gy);
                connt--;
                connt--;
            }
            repaint();
        }

        if (source==button3){
            steQipanInit();
            repaint();
        }
    }

    public void paint(Graphics g) {
		BufferedImage bi = new BufferedImage(716, 716, BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = bi.createGraphics();
		Graphics2D g2d = (Graphics2D) g2;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// 抗锯齿效果
		super.paint(g2d);
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (isVisible && qipan[i][j] == 'b') {
					g2d.setColor(Color.BLACK);
					g2d.fillOval(34 + 44 * i, 44 * j + 62, 34, 34);
					// System.out.println("BLACK");
				} else if (isVisible && qipan[i][j] == 'w') {
					g2d.setColor(Color.WHITE);
					g2d.fillOval(34 + 44 * i, 44 * j + 62, 34, 34);
					// System.out.println("RED");
				}
			}
		}
		g.drawImage(bi, 0, 0, this);
	}

	public void steQipan(int gx, int gy, char who) {
		qipan[gx][gy] = who;
		if (who != '\0') {
			chessman.push(gx);// 入栈
			chessman.push(gy);
		}
		System.out.println(qipan[gx][gy]);
	}

	public void steQipanInit() {
		for (int a = 0; a < 15; a++) {
			for (int b = 0; b < 15; b++) {
				qipan[a][b] = '\0';
			}
		}
		// 清空栈
		while (chessman.isEmpty()) {
			chessman.pop();
            repaint();
		}
	}

	public void winDow() {
		if (who.win(qipan) == 'b') {
			JOptionPane.showMessageDialog(this, "哇！你赢了,太厉害了!");
			//steQipanInit();
		} else if (who.win(qipan) == 'w') {
			JOptionPane.showMessageDialog(this, "很不幸,电脑获得胜利!");
			//steQipanInit();
		}
		repaint();
	}

}