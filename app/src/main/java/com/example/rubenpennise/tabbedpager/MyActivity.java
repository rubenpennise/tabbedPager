package com.example.rubenpennise.tabbedpager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rubenpennise.tabbedpager.Lineas.Linea;
import com.example.rubenpennise.tabbedpager.Lineas.LineaManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Locale;


public class MyActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    static SectionsPagerAdapter mSectionsPagerAdapter;
    public static android.support.v4.app.FragmentManager fragmentManager;

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    ViewPager mViewPager;
    ListView lista;
    int linea=0;
    int cuadras=5;
    ArrayList<Linea> listaLineas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        fragmentManager = getSupportFragmentManager();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            PlaceholderFragment.cambiarTipoMapa();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    * metodo para cambiar de pagina desde la lista de las lineas disponibles
    * **/
    public void switchFragmentLinea(int target,int linea){
        this.linea=linea;
        mViewPager.setCurrentItem(target);/*
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.remove(getFragmentManager().findFragmentById(R.layout.fragment_my))
                .add(R.id.pager, MyActivity.PlaceholderFragment.newInstance(target, linea)).commit();
        mSectionsPagerAdapter.notifyDataSetChanged();*/
        //PlaceholderFragment.agregarMarcador();
        //aca mostramos los distintos recorridos, hasta ahora tendria que ser con metodos estaticos.
        switch(linea){
            case 0:
                listaLineas=new LineaManager().getListaLineas();
                Log.d("lista lineas",listaLineas.toString());
                new PlaceholderFragment().mostrarRutas(listaLineas,"101");
                break;
            case 1:
                listaLineas=new LineaManager().getListaLineas();
                Log.d("lista lineas",listaLineas.toString());
                new PlaceholderFragment().mostrarRutas(listaLineas,"503");
                break;
            case 2:
                break;
        }
    }

    /*
    * metodo para cambiar de pagina desde el fragment  buscar de las lineas disponibles
    * **/
    public void switchFragmentCuadras(int target,int cuadras){
        this.cuadras=cuadras;
        mViewPager.setCurrentItem(target);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch(position){
                case 0:
                    return ListaFragment.newInstance("","");
                case 1:
                    return PlaceholderFragment.newInstance(position + 1,linea);
                case 2:
                    return BuscarFragment.newInstance("","");
                default:
                    Log.d("posicion",position+"");
                    return PlaceholderFragment.newInstance(position + 1,linea);
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }




    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private MapFragment mMapFragment;
        private static GoogleMap mMap;
        int lineaColectivo=25;
        private  static final LatLng PLANET_HOLLYWOOD = new LatLng(36.1100, -115.1710);
        private  Polyline polyline;
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber,int linea) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putInt("linea", linea);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            Log.d("on create"," view");
            setUpMapIfNeeded();
            //agregarMarcador();
            return rootView;

        }

       /* @Override
        public void onDestroyView() {
            super.onDestroyView();
            if (mMap != null) {
                MyActivity.fragmentManager.beginTransaction()
                        .remove(MyActivity.fragmentManager.findFragmentById(R.id.location_map)).commit();
                mMap = null;
            }
            Log.d("on destroy"," view");
        }*/

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            lineaColectivo= getArguments().getInt("linea");
            Log.d("linea colectivo on attach",((MyActivity)getActivity()).linea+"");
        }

        @Override
        public void onResume() {
            super.onResume();
            lineaColectivo= getArguments().getInt("linea");
            Log.d("linea colectivo on resume",((MyActivity)getActivity()).linea+"");
        }

        public static void setUpMapIfNeeded() {
            // Do a null check to confirm that we have not already instantiated the map.
            if (mMap == null) {
                // Try to obtain the map from the SupportMapFragment.
                mMap = ((SupportMapFragment) MyActivity.fragmentManager
                        .findFragmentById(R.id.location_map)).getMap();
                // Check if we were successful in obtaining the map.
                LatLng catamarca = new LatLng(-28.461087, -65.787203);

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(catamarca, 13));
            }
        }

        public static void agregarMarcador() {
            if(mMap != null){
                mMap.addMarker(new MarkerOptions().position(PLANET_HOLLYWOOD).title("Planet Hollywood"));
            }
        }

        public static void cambiarTipoMapa() {
            if(mMap!=null) {
                if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    Log.d("tipo mapa sat", mMap.getMapType() + "");
                } else if (mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        }

        public  void mostrarRutas(ArrayList<Linea> rutasAMostrar,String linea) {
            for (Linea l : rutasAMostrar){
                if(l.getNombre().equals(linea)) {
                    Log.d("entro",l.getNombre()+l.getListaPuntos().toString());
                    PolylineOptions polylineOptions = new PolylineOptions()
                            .addAll(l.getListaPuntos());
                    drawPolilyne(polylineOptions);
                }
            }
        }

        public  void drawPolilyne(PolylineOptions options){
            mMap.clear();
            polyline = mMap.addPolyline(options);
        }

    }



}
