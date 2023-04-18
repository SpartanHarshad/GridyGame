package com.harshad.gridygame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.harshad.gridygame.databinding.LayoutGridItemBinding


class GameBoardAdapter(var tileSize: Int, var dotPosition: Int) :
    RecyclerView.Adapter<GameBoardAdapter.BoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GameBoardAdapter.BoardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: LayoutGridItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_grid_item, parent, false)
        return BoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameBoardAdapter.BoardViewHolder, position: Int) {
        if (position != dotPosition) {
            holder.binding.tile.setBackgroundResource(R.drawable.rectangle)
        } else {
            holder.setDotView(position)
        }
    }

    override fun getItemCount(): Int {
        return tileSize
    }

    inner class BoardViewHolder(val binding: LayoutGridItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setDotView(position: Int) {
            binding.tile.setBackgroundResource(R.drawable.rectangle_with_dot)
        }
    }

}