package com.tcs.Bikebackend.dao;

import java.util.List;

import com.tcs.Bikebackend.dto.Catagory;

public interface CatagoryDAO {

    List<Catagory> list();
    Catagory get(int id);
}
