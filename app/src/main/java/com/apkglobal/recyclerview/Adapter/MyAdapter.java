package com.apkglobal.recyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apkglobal.recyclerview.Activites.DetailsActivity;
import com.apkglobal.recyclerview.Model.ListItem;
import com.apkglobal.recyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private List<ListItem>listItems;

    public MyAdapter(Context context, List listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_row,viewGroup,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int position) {
      ListItem item=listItems.get(position);

      viewHolder.name.setText(item.getName());
      viewHolder.description.setText(item.getDescription());






    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            name=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);

        }

        @Override
        public void onClick(View v) {
            //Get the position of the row clicked
            int position=getAdapterPosition();

            ListItem item=listItems.get(position);
            Intent intent=new Intent(context, DetailsActivity.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("description",item.getDescription());
            context.startActivity(intent);

            Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
