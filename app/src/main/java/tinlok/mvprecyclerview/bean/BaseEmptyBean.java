package tinlok.mvprecyclerview.bean;

import java.io.Serializable;

/**
 * Created by prj on 2016/9/16.
 */

public class BaseEmptyBean implements Serializable{

    private String msg;
    private Integer code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public BaseEmptyBean() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BaseEmptyBean(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseEmptyBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
