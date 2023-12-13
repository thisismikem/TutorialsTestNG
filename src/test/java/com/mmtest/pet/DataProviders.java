package com.mmtest.pet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;


public class DataProviders {
	
	@DataProvider(name = "PetDataExcel")
	public Object[] getAllPetData() {
		String path = System.getProperty("user.dir") + "\\testData\\petdata.xlsx";
		
		PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .headerCount(2) // since we have two header rows
                .build();

		List<Pet> pets = Poiji.fromExcel(new File(path), Pet.class, options);
		
        return pets.toArray(new Pet[pets.size()]);
	}
	
	@DataProvider(name = "PetDataJson")
	public Object[] getAllPetDataJson() throws IOException {
		String path = System.getProperty("user.dir") + "\\testData\\petdata.json";
		
	    String json = Files.readString(Paths.get(path));

	    Gson gson = new Gson();
	    List<Pet> pets = gson.fromJson(json, new TypeToken<List<Pet>>() {}.getType());
		
        return pets.toArray(new Pet[pets.size()]);
	}
	
}
