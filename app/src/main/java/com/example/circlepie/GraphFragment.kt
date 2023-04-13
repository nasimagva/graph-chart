package com.example.circlepie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.circlepie.databinding.FragmentGraphBinding

class GraphFragment : Fragment() {
    private var _binding: FragmentGraphBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ProgressBarAdapter
    private lateinit var progressList: ArrayList<ProgressBarDataModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGraphBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as MainActivity?)!!.fragmentMethod()
        val recyclerview = view.findViewById<RecyclerView>(R.id.rv)
        progressList = ArrayList()
        progressList.add(ProgressBarDataModel(0, "PIP"))
        progressList.add(ProgressBarDataModel(0, "VTe"))
        progressList.add(ProgressBarDataModel(0, "PEEP"))
        progressList.add(ProgressBarDataModel(0, "RR"))
        progressList.add(ProgressBarDataModel(0, "MVi"))
        adapter = ProgressBarAdapter(progressList)
        recyclerview?.adapter = adapter
        adapter.notifyDataSetChanged()
        return view
    }
}