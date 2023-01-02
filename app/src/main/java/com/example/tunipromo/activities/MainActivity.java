package com.example.tunipromo.activities;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.SearchView;

import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tunipromo.R;
import com.example.tunipromo.adapters.RecyclerViewAdapter;
import com.example.tunipromo.data.Site;


import java.util.ArrayList;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Site> sites;
    private List<Site> sitesCopy;
    private List<String> imgs;
    private String vds;
    private SearchView searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test : ", "0");
        RecyclerView recyclerViewA = (RecyclerView) findViewById(R.id.recyclerViewA);
        this.recyclerView = recyclerViewA;

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("test : ", "1");
        this.sites = new ArrayList();
        this.imgs = new ArrayList();
        this.vds = new String();

        imgs.add("https://i.imgur.com/A3hHuJs.jpeg");
        imgs.add("https://i.imgur.com/iKnVvXS.jpeg");
        imgs.add("https://i.imgur.com/9MZH3aM.jpeg");
        imgs.add("https://i.imgur.com/hZYjdd5.jpeg");
        imgs.add("https://i.imgur.com/72tmTOf.jpeg");
        imgs.add("https://i.imgur.com/RVr7pHa.jpeg");
        imgs.add("https://scontent.ftun1-2.fna.fbcdn.net/v/t1.18169-9/28661229_1988922744761301_511174758609670644_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=8bfeb9&_nc_ohc=fQZ9Fyzf8bgAX-MRqN7&_nc_ht=scontent.ftun1-2.fna&oh=00_AfBD964DZRgQu6o9L71z01BUp7cARlDrCjGtN-sHT-4XBA&oe=63D6BF63");

        vds = ("wW43r9PsI6g");
        sites.add(
                new Site(
                        "0", "Petit Paris", "Plage", "Kélibia, Nabeul",
                        imgs, vds, "Une plage classée parmi les meilleures plages du monde"
                )
        );


        //deuxieme item
        this.imgs = new ArrayList();
        Log.d("test : ", "2");
        imgs.add("https://i.imgur.com/DsQi9Ux.jpeg");
        imgs.add("https://i.imgur.com/2GEYMw1.png");
        imgs.add("https://i.imgur.com/xIRy4em.jpeg");

        sites.add(
                new Site(
                        "1", "Sidi Bou Said", "Plage", "Sidi Bou Said, Tunis",
                        imgs, "V3PViosuI50", "Une ville extrement ravissante avec la mélange des couleurs blanches et bleu."
                )
        );


        //troisieme item
        this.imgs = new ArrayList();


        imgs.add("https://i.imgur.com/CW1qrYU.jpeg");
        imgs.add("https://i.imgur.com/vfvIzzP.jpeg");
        imgs.add("https://i.imgur.com/ExfZRqN.jpeg");
        imgs.add("https://i.imgur.com/6pZZgsH.jpeg");
       // imgs.add("https://i.imgur.com/brY0yNZ.jpeg");
       // imgs.add("https://i.imgur.com/gomBu4f.jpeg");

        sites.add(
                new Site(
                        "2", "Bizerte", "Plage", "Bizerte, Tunisie",
                        imgs, "uyeXpLjqgxw", "Une géographie difféerente contenant tout type de terrain avec une varité enorme de vue"
                )
        );


        //quatrime item
        this.imgs = new ArrayList();
        //this.vds = new ArrayList();

        imgs.add("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/32/4f/b2/campement-yadis.jpg?w=1200&h=-1&s=1");
        imgs.add("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/06/82/ed/4e/ksar-ghilane.jpg?w=1200&h=-1&s=1");
        imgs.add("https://dynamic-media-cdn.tripadvisor.com/media/photo-s/03/21/f8/31/ksar-ghilane.jpg?w=600&h=-1&s=1");
        imgs.add("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/0b/3d/44/piccolo-dromedario.jpg?w=1100&h=-1&s=1");
        imgs.add("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/0b/3d/1b/gita-con-i-quad.jpg?w=1200&h=-1&s=1");
        imgs.add("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/0b/3d/10/tramonto-sulle-dune.jpg?w=1200&h=-1&s=1");
        imgs.add("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/0b/3d/0b/vista-dall-accampamento.jpg?w=1200&h=-1&s=1");

        sites.add(
                new Site(
                        "3", "Ksar Ghilen", "Site Archéologique", "Ksar Ghilen, Tataouine",
                        imgs, "N-iRdINkyCA", "Un site archéologique pas comme les autres, plein de devertissement"
                )
        );

        //5eme item
        this.imgs = new ArrayList();
        // this.vds = new ArrayList();

        imgs.add("https://voyage-tunisie.info/wp-content/uploads/2017/11/loisir-tabarka5-800x500.jpg");
        imgs.add("https://voyage-tunisie.info/wp-content/uploads/2017/11/A%C3%AFn-Draham-Tunisie6-1.jpg");
        imgs.add("https://voyage-tunisie.info/wp-content/uploads/2017/11/A%C3%AFn-Draham-Tunisie4.jpg");
        imgs.add("https://voyage-tunisie.info/wp-content/uploads/2017/11/ain-drahem.jpg");
        imgs.add("https://voyage-tunisie.info/wp-content/uploads/2017/11/Ain-Drahem-2-768x558.jpg");
        imgs.add("https://voyage-tunisie.info/wp-content/uploads/2017/11/A%C3%AFn-Draham-Tunisie1-768x549.jpg");

        sites.add(
                new Site(
                        "0", "Ain Drahem", "Forêt, Montagne", "Ain Drahem, Jendouba",
                        imgs, "av6O2PUbDo4", "Un forêt plein de surprise et de site à visiter et à découvrir"
                )
        );

        Log.d("before set Adapter : ", "0");
        this.recyclerViewAdapter = new RecyclerViewAdapter(sites);
        // recyclerViewAdapter.setOnItemClickListener((RecyclerViewAdapter.OnItemClickListener) this);
        recyclerView.setAdapter(recyclerViewAdapter);
        LinearLayoutManager mLayoutManagerForItems = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManagerForItems);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        this.sitesCopy = new ArrayList(sites);

        recyclerViewAdapter.setOnItemClickListener(this);


    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        searchView = (SearchView) menu.findItem(R.id.search).getActionView();


        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                recyclerViewAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                recyclerViewAdapter.getFilter().filter(query);
                return false;
            }
        });

        MenuItem item = menu.findItem(R.id.sort);


        Spinner spinner = (Spinner) item.getActionView();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_sort, R.layout.custom_spinner);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter((SpinnerAdapter) adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                sortData(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {
        SearchView searchView = this.searchView;

        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    public final void sortData(int i) {
        switch (i) {
            case 0:

                recyclerViewAdapter = new RecyclerViewAdapter(sitesCopy);
                recyclerViewAdapter.setOnItemClickListener(this);
                recyclerView.setAdapter(recyclerViewAdapter);
                return;
            case 1:

                CollectionsKt.sortWith(sites, (lhs, rhs) -> (lhs.getTitre().charAt(0) > rhs.getTitre().charAt(0)) ? -1 : lhs.getTitre().charAt(0) == rhs.getTitre().charAt(0) ? 0 : 1);
                recyclerViewAdapter = new RecyclerViewAdapter(sites);
                recyclerViewAdapter.setOnItemClickListener(this);
                recyclerView.setAdapter(recyclerViewAdapter);
                return;
            case 2:
                CollectionsKt.sortWith(sites, (lhs, rhs) -> lhs.getCategorie().length() > rhs.getCategorie().length() ? -1 : lhs.getCategorie() == rhs.getCategorie() ? 0 : 1);
                recyclerViewAdapter = new RecyclerViewAdapter(sites);
                recyclerViewAdapter.setOnItemClickListener(this);
                recyclerView.setAdapter(recyclerViewAdapter);
                return;
            case 3:
                CollectionsKt.sortWith(sites, (lhs, rhs) -> lhs.getLocalisation().length() > rhs.getLocalisation().length() ? -1 : lhs.getLocalisation() == rhs.getLocalisation() ? 0 : 1);
                recyclerViewAdapter = new RecyclerViewAdapter(sites);
                recyclerViewAdapter.setOnItemClickListener(this);
                recyclerView.setAdapter(recyclerViewAdapter);
                return;
            case 4:
                CollectionsKt.sortWith(sites, (lhs, rhs) -> lhs.getDescr().length() > rhs.getDescr().length() ? -1 : lhs.getDescr() == rhs.getDescr() ? 0 : 1);
                recyclerViewAdapter = new RecyclerViewAdapter(sites);
                recyclerViewAdapter.setOnItemClickListener(this);
                recyclerView.setAdapter(recyclerViewAdapter);
                return;
            default:
                return;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.sort:
                return true;
            case R.id.search:
                return true;
            case R.id.deconnexion:

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("CONNECTION_STATUS", false);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(View view, Site site, int position) {

        Intent intent = new Intent(MainActivity.this, SiteActivity.class);

        intent.putExtra("site", site);
        startActivity(intent);
    }

}
