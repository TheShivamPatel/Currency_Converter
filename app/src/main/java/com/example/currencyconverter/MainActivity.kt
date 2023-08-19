package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.currencyconverter.API.RetrofitHelper
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.repository.Repository
import com.example.currencyconverter.viewModel.MainViewModel
import com.example.currencyconverter.viewModel.MainViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        val repository = Repository(RetrofitHelper)
        viewModel = ViewModelProvider(this , MainViewModelFactory(repository))[MainViewModel::class.java]



        binding.amountEdt.addTextChangedListener { editable->

            var amount = binding.amountEdt.text.toString()

            if (binding.amountEdt.text.isEmpty()){
                 amount = "0"
            }
            viewModel.convert( amount.toDouble() , binding.spinnerFrom.selectedItem.toString() , binding.spinnerTo.selectedItem.toString() )
        }

        viewModel.resultLiveData.observe(this , Observer {
            binding.resultTxt.text = it.toString()
        })


    }
}