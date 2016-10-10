package tinlok.mvprecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import tinlok.mvprecyclerview.R;
import tinlok.mvprecyclerview.bean.InvitationBaseBean;
import tinlok.mvprecyclerview.util.StringUtil;
import tinlok.mvprecyclerview.util.TimeUtil;

/**
 * Created by Young on 2016/10/10.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private InvitationBaseBean mData;
    private Context context;
    private ItemEvent mItemEvent;

    public MyAdapter(Context context ,InvitationBaseBean mInvitationBaseBean){
        this.mData = mInvitationBaseBean;
        System.out.println("mdata"+mData.getData().get(0).getMembers().get(0).getHeadUrl());
        this.context = context;
    }

    public void setItemEvent(ItemEvent itemEvent){
        this.mItemEvent = itemEvent;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.invitation_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String sex = getSexrequire(mData.getData().get(position).getSexRequire());
        boolean join = mData.getData().get(position).isJoin();
        if(join) {
            System.out.println("已参加");
            holder.itemInvitationJoinBtn.setImageResource(R.drawable.join_selected);
        }
        else {
            System.out.println("未参加");
            holder.itemInvitationJoinBtn.setImageResource(R.drawable.join_unselected);
        }
        holder.itemInvitationOriginatorName.setText(mData.getData().get(position).getOriginatorNickname());
        holder.itemInvitationTitle.setText(mData.getData().get(position).getTitle());
        //  mData.getData().get(position).setContent("[肇庆学院航空杯]2015年即将结束，我们将迎来本学期最后一场狼人杀比赛--航空杯狼人杀比赛，希望广大杀友踊跃报名！");//临时数据
        String contents = StringUtil.cutContents(mData.getData().get(position).getContent(),57);
        holder.itemInvitationContents.setText(contents);
        holder.itemInvitationInvitationTime.setText("活动时间:"+mData.getData().get(position).getInvitationTime());
        holder.itemInvitationPublishTime.setText(TimeUtil.getTime(mData.getData().get(position).getPublishTime()));
        holder.itemInvitationPlace.setText("活动地点:"+mData.getData().get(position).getPlace());
        holder.itemInvitationSexRequire.setText("性别要求:"+sex);
        holder.itemInvitationNumber.setText(mData.getData().get(position).getCurrentNumber()+"/"+mData.getData().get(position).getTotalNumber());
        holder.itemInvitationJoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemEvent.onJoinBtnClick(position);
            }
        });
        holder.itemInvitationRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemEvent.onItemCLick(position);
            }
        });
        Picasso.with(context)
                .load(mData.getData().get(position).getOriginatorHeadUrl())
                .placeholder(R.drawable.user0)
                .into(holder.itemInvitationOriginatorImagVi);
        Picasso.with(context)
                .load(mData.getData().get(position).getIconUrl())
                .placeholder(R.drawable.langrensha)
                .into(holder.itemInvitationIcon);
        /**
         * 参与人头像横向recyclerView
        mIte

        mAdapter = new UserImgListecyclerViewAdapter(mData.getData().get(position).getMembers(),context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.mRecyclerView.setLayoutManager(linearLayoutManager);
        holder.mRecyclerView.setAdapter(mAdapter);
        if(mData.getData().get(position).getMembers().get(0).getUserId().equals(String.valueOf(SharedUtil.getInt(App.instance,FieldConstant.userId)))) {
            holder.expend.setVisibility(View.VISIBLE);
        }else {
            holder.expend.setVisibility(View.GONE);
        }
         */
        mItemEvent.setMemberAdater(position,holder.itemInvitationUserimglist);
    }

    @Override
    public int getItemCount() {
        return mData.getData().size();
    }
    private String getSexrequire(String sexRequire) {
        String result = "不限";
        switch (sexRequire){
            case "0":
                result = "男生";
                break;
            case "1":
                result = "女生";
                break;
            case "2":
                result = "不限";
                break;
        }
        return result;
    }
    public interface ItemEvent{
        void onItemCLick(int position);
        void setMemberAdater(int position,RecyclerView recyclerView);
        void onJoinBtnClick(int position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_invitation_originator_imagVi)
        ImageView itemInvitationOriginatorImagVi;
        @BindView(R.id.item_invitation_originator_name)
        TextView itemInvitationOriginatorName;
        @BindView(R.id.item_invitation_title)
        TextView itemInvitationTitle;
        @BindView(R.id.item_invitation_publish_time)
        TextView itemInvitationPublishTime;
        @BindView(R.id.item_invitation_expend)
        ImageView itemInvitationExpend;
        @BindView(R.id.item_invitation_contents)
        TextView itemInvitationContents;
        @BindView(R.id.item_invitation_icon)
        ImageView itemInvitationIcon;
        @BindView(R.id.item_invitation_invitation_time)
        TextView itemInvitationInvitationTime;
        @BindView(R.id.item_invitation_place)
        TextView itemInvitationPlace;
        @BindView(R.id.item_invitation_sex_require)
        TextView itemInvitationSexRequire;
        @BindView(R.id.item_invitation_card)
        LinearLayout itemInvitationCard;
        @BindView(R.id.yibaoming)
        TextView yibaoming;
        @BindView(R.id.item_invitation_userimglist)
        RecyclerView itemInvitationUserimglist;
        @BindView(R.id.item_invitation_number)
        TextView itemInvitationNumber;
        @BindView(R.id.item_invitation_join_btn)
        ImageView itemInvitationJoinBtn;
        @BindView(R.id.item_invitation_root)
        LinearLayout itemInvitationRoot;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
