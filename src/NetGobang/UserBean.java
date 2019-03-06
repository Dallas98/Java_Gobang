package NetGobang;

/**
 * @program: Java五子棋
 * @description:
 * @author: Dallas
 * @create: 2019-02-21 20:55
 */


import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Time;


public class UserBean implements Serializable {
    protected String name = "游客";
    protected InetAddress host;
    private Time time;

    public InetAddress getHost() {
        return host;
    }

    public void setHost(InetAddress host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

}

