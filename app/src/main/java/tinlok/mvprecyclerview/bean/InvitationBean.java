package tinlok.mvprecyclerview.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * Created by Young on 2016/9/16.
 */
public class InvitationBean  implements Parcelable{


    public static final Creator<InvitationBean> CREATOR = new Creator<InvitationBean>() {

        @Override
        public InvitationBean createFromParcel(Parcel source) {
            InvitationBean invitationBean = new InvitationBean();
            invitationBean.setOriginatorId(source.readString());
            invitationBean.setOriginatorrealName(source.readString());
            invitationBean.setOriginatorNickname(source.readString());
            invitationBean.setPlace(source.readString());
            invitationBean.setSexRequire(source.readString());
            invitationBean.setContent(source.readString());
            invitationBean.setTitle(source.readString());
            invitationBean.setCurrentNumber(source.readString());
            invitationBean.setTotalNumber(source.readString());
            invitationBean.setInvitaionId(source.readString());
            invitationBean.setJoin((source.readInt() == 1 )? true:false);
            invitationBean.setInvitationTime(source.readString());
            invitationBean.setPublishTime(source.readString());
            invitationBean.setOriginatorHeadUrl(source.readString());
            invitationBean.setTypeId(source.readString());
//            invitationBean.setMembers(source.readArrayList(MembersBean.class.getClassLoader()));
            return invitationBean;
        }

        @Override
        public InvitationBean[] newArray(int size) {
            return new InvitationBean[0];
        }
    };

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String code;

    String originatorHeadUrl;
    String menbersUrl;
    String invitationTime;
    String publishTime;
    String originatorNickname;
    String originatorPhone;
    String iconUrl;
    String originatorId;
    String invitaionId;
    String currentNumber;
    String sexRequire;
    String content;
    String title;
    String originatorSex;
    String totalNumber;
    String place;
    String originatorrealName;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    String typeId;
    boolean isJoin;
    ArrayList<MembersBean> members;
    public ArrayList<MembersBean> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<MembersBean> members) {
        this.members = members;
    }


    public String getOriginatorHeadUrl() {
        return originatorHeadUrl;
    }

    public void setOriginatorHeadUrl(String originatorHeadUrl) {
        this.originatorHeadUrl = originatorHeadUrl;
    }

    public String getMenbersUrl() {
        return menbersUrl;
    }

    public void setMenbersUrl(String menbersUrl) {
        this.menbersUrl = menbersUrl;
    }

    public String getInvitationTime() {
        return invitationTime;
    }

    public void setInvitationTime(String invitationTime) {
        this.invitationTime = invitationTime;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getOriginatorNickname() {
        return originatorNickname;
    }

    public void setOriginatorNickname(String originatorNickname) {
        this.originatorNickname = originatorNickname;
    }

    public String getOriginatorPhone() {
        return originatorPhone;
    }

    public void setOriginatorPhone(String originatorPhone) {
        this.originatorPhone = originatorPhone;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    public String getInvitaionId() {
        return invitaionId;
    }

    public void setInvitaionId(String invitaionId) {
        this.invitaionId = invitaionId;
    }

    public String getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(String currentNumber) {
        this.currentNumber = currentNumber;
    }

    public String getSexRequire() {
        return sexRequire;
    }

    public void setSexRequire(String sexRequire) {
        this.sexRequire = sexRequire;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginatorSex() {
        return originatorSex;
    }

    public void setOriginatorSex(String originatorSex) {
        this.originatorSex = originatorSex;
    }

    public String getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getOriginatorrealName() {
        return originatorrealName;
    }

    public void setOriginatorrealName(String originatorrealName) {
        this.originatorrealName = originatorrealName;
    }

    public boolean isJoin() {
        return isJoin;
    }

    public void setJoin(boolean join) {
        isJoin = join;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(originatorId);
        dest.writeString(originatorrealName);
        dest.writeString(originatorNickname);
        dest.writeString(place);
        dest.writeString(sexRequire);
        dest.writeString(content);
        dest.writeString(title);
        dest.writeString(currentNumber);
        dest.writeString(totalNumber);
        dest.writeString(invitaionId);
        dest.writeInt(isJoin ? 1:0 );
        dest.writeString(invitationTime);
        dest.writeString(publishTime);
        dest.writeString(originatorHeadUrl);
        dest.writeString(typeId);
       // dest.writeList(members);

    }

    @Override
    public String toString() {
        return "InvitationBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", originatorHeadUrl='" + originatorHeadUrl + '\'' +
                ", menbersUrl='" + menbersUrl + '\'' +
                ", invitationTime='" + invitationTime + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", originatorNickname='" + originatorNickname + '\'' +
                ", originatorPhone='" + originatorPhone + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", originatorId='" + originatorId + '\'' +
                ", invitaionId='" + invitaionId + '\'' +
                ", currentNumber='" + currentNumber + '\'' +
                ", sexRequire='" + sexRequire + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", originatorSex='" + originatorSex + '\'' +
                ", totalNumber='" + totalNumber + '\'' +
                ", place='" + place + '\'' +
                ", originatorrealName='" + originatorrealName + '\'' +
                ", isJoin=" + isJoin +
                ", members=" + members +
                '}';
    }
}
