package com.geektech.hm5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.hm5.databinding.FragmentFormBinding;

public class FormFragment extends Fragment {

    private FragmentFormBinding binding;
    private MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFormBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        activity = (MainActivity) requireActivity();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(v -> {
            activity.visibleBottomNav();
            Bundle bundle = new Bundle();
            bundle.putString("name", binding.etFirst.getText().toString());
            bundle.putString("number", binding.etSecond.getText().toString());
            FormFragment.this.requireActivity().getSupportFragmentManager().setFragmentResult("form", bundle);
            FormFragment.this.requireActivity().getSupportFragmentManager().popBackStack();
        });
    }
}