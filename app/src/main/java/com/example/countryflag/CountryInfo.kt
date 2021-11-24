package com.example.countryflag
data class CountryInfoResponce(val error :Boolean , val msg:String , val data: List<CountryInfo>)
data class CountryInfo(val name :String , val flag : String)