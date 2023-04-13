package com.example.circlepie

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.circlepie.databinding.ProgressItemBinding

class ProgressBarAdapter(
    private val progressList: ArrayList<ProgressBarDataModel>
) : RecyclerView.Adapter<ProgressBarAdapter.ViewHolder>() {
    class ViewHolder(val binding: ProgressItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvHeader: TextView = itemView.findViewById(R.id.text_view_1)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val verticalProgressBar: ProgressBar = itemView.findViewById(R.id.verticalProgressBar)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ProgressItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return progressList.size
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(progressList[position]){
                binding.textView1.text = progressList[position].number.toString()
                binding.txtLabel.text= progressList[position].name.toString()
            binding.buttonIncr.setOnClickListener {
                when (position) {
                    0 -> {
                        // holder.progressBar.min = 10
                        increaseButton(holder)
                    }
                    1 -> {
                        increaseButton(holder)
                    }
                    2 -> {
                        increaseButton(holder)
                    }
                    3 -> {
                        increaseButton(holder)
                    }
                    4 -> {
                        increaseButton(holder)
                    }
                }
            }
            binding.buttonDecr.setOnClickListener {
                when (position) {
                    0 -> {
                        decreaseButton(holder)
                    }
                    1 -> {
                        decreaseButton(holder)
                    }
                    2 -> {
                        decreaseButton(holder)
                    }
                    3 -> {
                        decreaseButton(holder)
                    }
                    4 -> {
                        decreaseButton(holder)
                    }
                }
            }
        }
        }
    }
    private fun increaseButton(holder: ViewHolder) {
        val progress = holder.progressBar.progress
        if (progress <= 90) {
            updateProgressBar(holder, progress + 10)
        }
    }
    private fun decreaseButton(holder: ViewHolder) {
        val progress = holder.progressBar.progress
        if (progress >= 10) {
            updateProgressBar(holder, progress - 10)
        }
    }
    private fun updateProgressBar(holder: ViewHolder, progress: Int) {
        holder.progressBar.progress = progress
        holder.verticalProgressBar.progress = progress
        holder.tvHeader.text = progress.toString()
    }
}