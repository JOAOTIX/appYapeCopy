package com.joaodev.yapecopy.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joaodev.yapecopy.R;
import com.joaodev.yapecopy.databinding.FragmentSplashBinding;

public class Splash extends Fragment {

    FragmentSplashBinding binding;
    View view;
    Context context;
    NavController navController;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navController.navigate(
                        R.id.navigation_login,
                        null,
                        new androidx.navigation.NavOptions.Builder()
                                .setPopUpTo(R.id.navigation_splash, true)
                                .build()
                );
            }
        }, 2400);
    }
}