package tinlok.mvprecyclerview.bean;

import java.io.Serializable;

/**
 * Created by prj on 2016/9/14.
 */

public class BaseBean<T> implements Serializable{

    private String msg;
    private String code;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
