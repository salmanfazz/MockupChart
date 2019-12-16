package com.example.mockupchart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class DetailCashBank extends Fragment implements View.OnClickListener {
    ImageView iconBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        return inflater.inflate(R.layout.activity_detail_cash_bank, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        iconBack = (ImageView) getView().findViewById(R.id.iconBack);
        iconBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.iconBack:
                Home home = new Home();
                fragmentTransaction.replace(R.id.fragment_container, home);
                fragmentTransaction.commit();
                break;
        }
    }
}
