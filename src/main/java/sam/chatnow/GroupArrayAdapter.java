package sam.chatnow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroupArrayAdapter extends RecyclerView.Adapter<GroupArrayAdapter.ViewHolder>{
  //  private int listItemLayout;

  //  private Group[] groupdata;
    Context c;
    ArrayList<Group> groupArrayList;

   // public GroupArrayAdapter(Group[] groupdata){
   //     this.groupdata=groupdata;
    //}

    public GroupArrayAdapter(Context context,ArrayList<Group> groupArrayList){
        c=context;
        this.groupArrayList=groupArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.group_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     //   final Group group=groupdata[position];
       // holder.textView.setText(groupdata[position].getGroupname());
        holder.textView.setText(groupArrayList.get(position).groupname);
    }

    @Override
    public int getItemCount() {
      //  return groupdata.length;
        return groupArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView=itemView.findViewById(R.id.groupnames);
        }
    }
}
