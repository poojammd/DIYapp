package com.example.pooja.diy;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class videoadapter extends RecyclerView.Adapter<videoadapter.videoadapterViewHolder> {
    static diytypes[] details;
    videoadapter(diytypes[] details){
        this.details=details;
    }

    public static class videoadapterViewHolder extends RecyclerView.ViewHolder{
        TextView type;
        ImageView small_pic;
        Context mcontext;

        public videoadapterViewHolder(final View itemView){
            super(itemView);
            mcontext=itemView.getContext();
            type=itemView.findViewById(R.id.rv_type);
            small_pic=itemView.findViewById(R.id.profile_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1=new Intent(itemView.getContext(),VIDEO.class);
                    intent1.putExtra("obj",details)
                            .putExtra("pos",getAdapterPosition());
                    itemView.getContext().startActivity(intent1);

                }
            });
        }
    }

    @NonNull
    @Override

    public videoadapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_recyclerlayout,parent,false);
        return new videoadapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull videoadapterViewHolder holder,int position){
        holder.type.setText(details[position].diytype);
        int resID=holder.mcontext.getResources().getIdentifier(details[position].imageName,"drawable",holder.mcontext.getPackageName());
        holder.small_pic.setImageBitmap(BitmapFactory.decodeResource(holder.mcontext.getResources(),resID));
    }

    @Override
    public int getItemCount(){
        return details.length;
    } }

