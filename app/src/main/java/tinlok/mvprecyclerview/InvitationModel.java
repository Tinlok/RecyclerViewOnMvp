package tinlok.mvprecyclerview;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.callback.StringCallback;

import tinlok.mvprecyclerview.bean.InvitationBaseBean;
import tinlok.mvprecyclerview.constant.APIConstant;

/**
 * Created by Young on 2016/9/16.
 */
public class InvitationModel implements MyContact.InvitationlModel {
    private InvitationBaseBean mData;
    @Override
    public void getData(StringCallback stringCallback) {
        OkHttpUtils.get()
                .url("http://rap.taobao.org/mockjs/7569/invitation/getInvitations")
                .build()
                .execute(stringCallback);

    }





}

