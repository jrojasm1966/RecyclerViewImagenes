package com.example.recyclerviewimgenes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewimgenes.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements  Adapter.OnItemClickListerner{

    private FragmentFirstBinding binding;

    private RecyclerView recyclerView;
    private Adapter adapter;

    private List<datosLista> dataList;
    private int indice;
    List<datosLista> data= new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        if(dataList!= null){

            dataList.clear();

        }
        dataList=getData();
        recyclerView= binding.recycler;
        recyclerView.setLayoutManager( new LinearLayoutManager(requireContext()));
        adapter= new Adapter(dataList);
        //implementar el onclick

        recyclerView.setAdapter(adapter);



        return binding.getRoot();



    }


    private List<datosLista>getData(){
        datosLista item=new datosLista("https://upload.wikimedia.org/wikipedia/commons/b/b9/Paisaje_de_Albacete.jpg","Girasoles");
        data.add(item);
        datosLista item1=new datosLista("https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640","Zhuo Cheng you");
        data.add(item1);
        datosLista item02 = new datosLista("https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640","billow926");
        data.add(item02);
        datosLista item03 = new datosLista("https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640","Philipp Deiß");
        data.add(item03);
        datosLista item04 = new datosLista("https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640","Joshua Earle");
        data.add(item04);
        datosLista item05 = new datosLista("https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640","Melnychuk Nataliya");
        data.add(item05);
        datosLista item06 = new datosLista("https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640","Teagan Maddux");
        data.add(item06);
        datosLista item07 = new datosLista("https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640","Chen Liu");
        data.add(item07);
        datosLista item08 = new datosLista("https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640","John Fornander");
        data.add(item08);
        datosLista item09 = new datosLista("https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640","Parker");
        data.add(item09);
        datosLista item10 = new datosLista("https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640","XPS");
        data.add(item10);
        datosLista item11 = new datosLista("https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640","J. whack");
        data.add(item11);
        datosLista item12 = new datosLista("https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640", "Amstrong");
        data.add(item12);


        return data;
    }




    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onItemClick(int position) {
        indice =position;
        datosLista eleccion= dataList.get(indice);
        Bundle  bundle= new Bundle();
        bundle.putString("url", eleccion.getUrl());
        bundle.putString("datos",eleccion.getDato());
        NavController  navController= Navigation.findNavController(getActivity(),R.id.fragmentContainerView);
               navController.navigate(R.id.action_FirstFragment_to_SecondFragment,
                bundle);


    }
}