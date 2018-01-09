package com.tcs.Bikebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.Bikebackend.dao.CatagoryDAO;
import com.tcs.Bikebackend.dto.Catagory;

@Repository("catagoryDAO")
public class CatagoryDAOImpl implements CatagoryDAO {
	
	private static List<Catagory> catagories=new ArrayList<>();
	
	static
	{
		Catagory catagory=new Catagory();
		catagory.setId(1);
		catagory.setName("Laptop");
		catagory.setDescription("This is to buy laptop");
		catagory.setImageURL("Laptop.png");
		
		catagories.add(catagory);
		
		catagory=new Catagory();
		catagory.setId(2);
		catagory.setName("Television");
		catagory.setDescription("This is to buy Television");
		catagory.setImageURL("Television.png");
		
		catagories.add(catagory);
		
		catagory=new Catagory();
		catagory.setId(3);
		catagory.setName("Mobile");
		catagory.setDescription("This is to buy mobile");
		catagory.setImageURL("Mobile.png");
		
		catagories.add(catagory);
	}

	@Override
	public List<Catagory> list() {
		// TODO Auto-generated method stub
		return catagories ;
	}

	@Override
	public Catagory get(int id) {
		for(Catagory catagory: catagories)
		{
			if(catagory.getId()== id)
				return catagory;
		}
		return null;
	}

}
