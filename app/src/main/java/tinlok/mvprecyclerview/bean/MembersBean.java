package tinlok.mvprecyclerview.bean;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Young on 2016/9/16.
 */
public class MembersBean  implements Parcelable {

    public static final Creator<MembersBean> CREATOR = new Creator<MembersBean>() {
        @Override
        public MembersBean createFromParcel(Parcel source) {
            MembersBean membersBean = new MembersBean();
            membersBean.phone = source.readString();
            membersBean.userId = source.readString();
            membersBean.headUrl = source.readString();
            membersBean.sex = source.readString();
            membersBean.realName = source.readString();
            return membersBean;
        }

        @Override
        public MembersBean[] newArray(int size) {
           return null;
        }
    };
    String phone;
    String sex;
    String userId;
    String realName;
    String headUrl;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(phone);
        dest.writeString(userId);
        dest.writeString(headUrl);
        dest.writeString(sex);
        dest.writeString(realName);
    }
}
