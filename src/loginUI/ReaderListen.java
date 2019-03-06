package loginUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: Java五子棋
 * @description:
 * @author: 阳鹏
 * @create: 2018-12-14 22:11
 */
public class ReaderListen implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login.getLoginButton()){
            Event.LoginButton();
        }
        if(e.getSource()==Login.getRegisterButton()){
            Event.registerButton();
        }
        if(e.getSource()==Login.getResetButton()){
            Event.resetButton();
        }
        if(e.getSource()==Register.getRegisterButton()&&Register.sr=="注册"){
            Event.register();
        }
        if(e.getSource()==Register.getRegisterButton()&&Register.sr=="确定"){
            Event.reset();
        }
        if(e.getSource()==Register.getLoginButton()){
            Event.cancel();
        }

    }
}
