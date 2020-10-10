package com.example.databindingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databindingapp.R;
import com.example.databindingapp.databinding.ListBinding;
import com.example.databindingapp.model.Hero;

import java.util.List;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroListHolder> {
    List<Hero> heroes;
    Context context;
    ListBinding userListBinding;
    public HeroListAdapter(List<Hero> heroes, Context context) {
        this.heroes = heroes;
        this.context = context;
    }

    @NonNull
    @Override
    public HeroListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        userListBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list,parent,false);
        HeroListHolder heroListHolder=new HeroListHolder(userListBinding.getRoot());
        return heroListHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HeroListHolder holder, int position) {
       // holder.textView.setText(heroes.get(position).getName());
        userListBinding.setHero(heroes.get(position));
        //userListBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }
    public class HeroListHolder extends RecyclerView.ViewHolder {
        public HeroListHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
