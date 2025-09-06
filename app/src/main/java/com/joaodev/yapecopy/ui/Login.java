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
import android.widget.Button;

import com.joaodev.yapecopy.R;
import com.joaodev.yapecopy.databinding.FragmentLoginBinding;

import java.util.Random;

public class Login extends Fragment {

    FragmentLoginBinding binding;
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
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return view = binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        navController = Navigation.findNavController(view);

        Random random = new Random();


        int[] buttonIds = {
                R.id.btnOne, R.id.btnTwo, R.id.btnThree,
                R.id.btnFour, R.id.btnFive, R.id.btnSix,
                R.id.btnSeven, R.id.btnEight, R.id.btnNine,
                R.id.btnTen
        };
        final int[] contador={0};


        for (int id: buttonIds){
            Button btn = view.findViewById(id);

            if (btn != null){
                btn.setText(String.valueOf(random.nextInt(10)));

                btn.setOnClickListener(v -> {
                    contador[0]++;

                    if (contador[0]==6){
                        navController.navigate(R.id.navigation_home);
                    }
                });

            }

    }

}
}