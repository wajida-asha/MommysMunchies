package com.example.mommysmunchies.Fragments;

import android.os.Bundle;
import com.example.mommysmunchies.Constant.AllConstant;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mommysmunchies.PlaceModel;
import com.example.mommysmunchies.R;
import com.example.mommysmunchies.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.material.chip.Chip;


public class HomeFragment extends Fragment implements OnMapReadyCallback{

    private FragmentHomeBinding binding;
    private GoogleMap mGoogleMap;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.homeMap);

        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        for (PlaceModel placeModel : AllConstant.placesName) {

            Chip chip = new Chip(requireContext());
            chip.setText(placeModel.getName());
            chip.setId(placeModel.getId());
            chip.setPadding(8, 8, 8, 8);
            chip.setTextColor(getResources().getColor(R.color.white, null));
            chip.setChipBackgroundColor(getResources().getColorStateList(R.color.primaryColor, null));
            chip.setChipIcon(ResourcesCompat.getDrawable(getResources(), placeModel.getDrawableId(), null));
            chip.setCheckable(true);
            chip.setCheckedIconVisible(false);

            binding.placesGroup.addView(chip);


        }

    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mGoogleMap = googleMap;
    }
}