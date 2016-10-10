package tinlok.mvprecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.zhy.http.okhttp.callback.StringCallback;

import tinlok.mvprecyclerview.bean.InvitationBaseBean;

/**
 * Created by Young on 2016/10/5.
 */
public interface MyContact {
    interface View {
        //toast显示信息
        void showToast(String string);
        //设置recyclerView
       void setAdapter(InvitationBaseBean invitationBaseBean);
        //刷新adater
        void notifyAdapter();
        //停止刷新
        void stopRefresh();
    }
    interface InvitationlModel{
        void getData(StringCallback stringCallback);
    }
    interface InvitationPresenter {
        //连接、断开view
        void attachView(@NonNull MainActivity View);
        void detachView();

        void getData();
        void onPositive(int position);
        void pullLoadMore();
        void getUserInfor(String userId,String inviationId);
        void deleteInvitation(int position);
        void quit();
    }
}
