package tinlok.mvprecyclerview.bean;

import java.util.ArrayList;

/**
 * Created by prj on 2016/9/14.
 */

public class InvitationBaseBean {

    private String msg;
    private String code;

    public ArrayList<InvitationBean> getData() {
        return data;
    }

    public void setData(ArrayList<InvitationBean> data) {
        this.data = data;
    }

    private ArrayList<InvitationBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "InvitationBaseBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
