package tinlok.mvprecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import tinlok.mvprecyclerview.bean.BaseBean;
import tinlok.mvprecyclerview.bean.InvitationBaseBean;
import tinlok.mvprecyclerview.util.GsonUtil;


/**
 * Created by Young on 2016/10/10.
 */
public class MyPresenter implements MyContact.InvitationPresenter {
    private MyContact.View mActivity;
    private MyContact.InvitationlModel mInvitationModel;
    private InvitationBaseBean invitationBaseBean;

    @Override
    public void attachView(@NonNull MainActivity View) {
        mActivity = View;
        mInvitationModel = new InvitationModel();
    }

    @Override
    public void detachView() {
        mActivity = null;
    }

    @Override
    public void getData() {
        mInvitationModel.getData(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
                mActivity.showToast("加载失败，请检查网络");
            }

            @Override
            public void onResponse(String response, int id) {
               invitationBaseBean = GsonUtil.toString(response,InvitationBaseBean.class);
                if(invitationBaseBean.getCode().equals("200")) {
                    System.out.println("get到"+invitationBaseBean.getData().get(0).getOriginatorNickname());

                    // TODO 临时数据，增加item长度
                   for(int i = 0;i<2;i++)
                    invitationBaseBean.getData().addAll(invitationBaseBean.getData());

                    //加载数据成功，设置recyclerView的adater
                    mActivity.setAdapter(invitationBaseBean);
                }else {
                    //加载数据失败，显示错误信息
                    mActivity.showToast(invitationBaseBean.getMsg());
                }
            }
        });
    }

    @Override
    public void onPositive(int position) {

    }

    /**
     * 加载更多数据
     */
    @Override
    public void pullLoadMore() {
        mInvitationModel.getData(new StringCallback() {
            @Override
            public void onAfter(int id) {
                super.onAfter(id);
                mActivity.stopRefresh();
            }
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                    InvitationBaseBean newData = GsonUtil.toString(response,InvitationBaseBean.class);
                if(newData.getCode().equals("200")){
                    invitationBaseBean.getData().addAll(newData.getData());
                    mActivity.notifyAdapter();
                }else {
                    mActivity.showToast(newData.getMsg());
                }
            }
        });
    }

    @Override
    public void getUserInfor(String userId, String inviationId) {

    }

    @Override
    public void deleteInvitation(int position) {

    }

    @Override
    public void quit() {

    }
}
