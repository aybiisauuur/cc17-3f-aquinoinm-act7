package com.example.mycityfinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> data;

    Adapter(Context context, List<String> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = data.get(position);
        holder.textTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle, textDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), BakeryRecosActivity.class);
                    i.putExtra("Bakeries", data.get(getAdapterPosition()));
                    v.getContext().startActivity(i);

                    Intent g = new Intent(v.getContext(),UkayRecosActivity.class);
                    g.putExtra("Ukay", data.get(getAdapterPosition()));
                    v.getContext().startActivity(g);

                    Intent a = new Intent(v.getContext(), CoffeeRecosActivity.class);
                    a.putExtra("Coffee Shops", data.get(getAdapterPosition()));
                    v.getContext().startActivity(a);
                }
            });
            textTitle = itemView.findViewById(R.id.appName);
            textDescription = itemView.findViewById(R.id.appInfo);
        }
    }
}


