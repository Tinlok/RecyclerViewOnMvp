package tinlok.mvprecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import net.mobctrl.views.SuperSwipeRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tinlok.mvprecyclerview.adapter.MyAdapter;
import tinlok.mvprecyclerview.adapter.UserImgAdapter;
import tinlok.mvprecyclerview.bean.InvitationBaseBean;

public class MainActivity extends AppCompatActivity implements MyContact.View {
    @BindView(R.id.baseToolBar)
    BaseToolBar baseToolBar;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.activity_my_focus_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.invitation_refresh)
    net.mobctrl.views.SuperSwipeRefreshLayout invitationRefresh;
    @BindView(R.id.invitation_root)
    LinearLayout invitationRoot;
    @BindView(R.id.invitation_fab)
    FloatingActionButton invitationFab;

    private MyPresenter mMyPresenter;
    private MyAdapter mMyAdapter;
    private UserImgAdapter mUserImgAdapter;

    private SuperSwipeRefreshLayout refreshLayout;//下拉刷新组件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invitation_activity);
        ButterKnife.bind(this);
        mMyPresenter = new MyPresenter();
        mMyPresenter.attachView(this);
        //获取数据
        mMyPresenter.getData();
        //下拉刷新，上拉加载更多
        initSuperSwipeRefresh();
    }


    @Override
    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(final InvitationBaseBean invitationBaseBean) {
        mMyAdapter = new MyAdapter(this,invitationBaseBean);
        mMyAdapter.setItemEvent(new MyAdapter.ItemEvent() {
            @Override
            public void onItemCLick(int position) {
                showToast("itemClick");
            }

            @Override
            public void setMemberAdater(int position,RecyclerView recyclerView) {
                mUserImgAdapter = new UserImgAdapter(invitationBaseBean.getData().get(position).getMembers(),getApplicationContext());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(mUserImgAdapter);
            }

            @Override
            public void onJoinBtnClick(int position) {
                showToast("join");
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mMyAdapter);
    }

    @Override
    public void notifyAdapter() {
        mMyAdapter.notifyDataSetChanged();
    }

    @Override
    public void stopRefresh() {
        invitationRefresh.setRefreshing(false);
        invitationRefresh.setLoadMore(false);
    }


    /**
     * 下拉刷新，上拉加载
     */
    private void initSuperSwipeRefresh() {
        invitationRefresh.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh() {
                mMyPresenter.getData();
                invitationRefresh.setRefreshing(false);
            }

            @Override
            public void onPullDistance(int distance) {

            }

            @Override
            public void onPullEnable(boolean enable) {

            }
        });
        invitationRefresh.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mMyPresenter.pullLoadMore();
            }

            @Override
            public void onPushDistance(int distance) {

            }

            @Override
            public void onPushEnable(boolean enable) {

            }
        });
    }
    @OnClick(R.id.invitation_fab)
    public void onClick() {
        showToast("发起活动");
    }
}
