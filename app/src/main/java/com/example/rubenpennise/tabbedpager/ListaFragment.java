package com.example.rubenpennise.tabbedpager;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class ListaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView lista;
    int linea=0;
    ViewPager mViewPager;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaFragment newInstance(String param1, String param2) {
        ListaFragment fragment = new ListaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String lineas[] = {"linea 1", "linea 2", "linea 3", "linea 4", "linea 5", "linea 6"};
        Integer imagen_id[] = {R.drawable.colectivo, R.drawable.colectivo, R.drawable.colectivo,
                R.drawable.colectivo, R.drawable.colectivo, R.drawable.colectivo};

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_lista, container, false);

        lista= (ListView) v.findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(((MyActivity)getActivity()), imagen_id, lineas);

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("on item click", i + "");
                /*MyActivity.fragmentManager.beginTransaction()
                        .remove(MyActivity.fragmentManager.findFragmentById(R.id.location_map)).commit();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.pager, MyActivity.PlaceholderFragment.newInstance(i, i)).commit();*/
                ((MyActivity)getActivity()).switchFragmentLinea(1,i);
            }
        });
        return v;
    }



}
