package yhdj.example.com.wuziqi;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yhdj on 2017/6/11.
 */

public class MyRoomsAdapter extends RecyclerView.Adapter<MyRoomsAdapter.ViewHolder> {
    private ArrayList<Match> mMatches = new ArrayList<>();

    public MyRoomsAdapter(ArrayList<Match> mMatches) {
        this.mMatches = mMatches;
    }

    @Override
    public MyRoomsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rooms_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyRoomsAdapter.ViewHolder holder, int position) {
        final Match match = mMatches.get(position);
        holder.mTextView.setText(match.getRoomName());
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApplication.getContext(), MainActivity.class);
                intent.putExtra("objectId", match.getObjectId());
                intent.putExtra("isBegin",true);
                holder.mTextView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMatches.size();
    }

    public void changeData(ArrayList<Match> matches) {
        this.mMatches = matches;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.roomName);
        }
    }
}
