package com.example.mommysmunchies.Constant;

import com.example.mommysmunchies.PlaceModel;
import com.example.mommysmunchies.R;

import java.util.ArrayList;
import java.util.Arrays;

public class AllConstant {
    public static final int STORAGE_REQUEST_CODE =1000 ;
    public static final String IMAGE_PATH = "/Profile/image_profile.jpg";

    public static ArrayList<PlaceModel> placesName = new ArrayList<>(
            Arrays.asList(
                    new PlaceModel(1, R.drawable.ic_restaurant, "Baby Meals", "meals"),
                    new PlaceModel(2, R.drawable.ic_atm, "ATM", "atm"),
                    new PlaceModel(3, R.drawable.ic_gas_station, "Gas", "gas_station"),
                    new PlaceModel(4, R.drawable.ic_shopping_cart, "Baby Food Shops", "shops")


            )
    );
}
