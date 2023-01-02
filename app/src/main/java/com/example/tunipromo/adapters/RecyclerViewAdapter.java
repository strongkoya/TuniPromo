package com.example.tunipromo.adapters;



import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.tunipromo.R;
import com.example.tunipromo.activities.MainActivity;
import com.example.tunipromo.data.Site;
import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;




public final class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private List<Site> sites;
    private List<Site> sitesFiltered;
    private OnItemClickListener itemClickListener;




    public RecyclerViewAdapter( List<Site> siteArrayList) {

        this.sites = siteArrayList;
        this.sitesFiltered = siteArrayList;
        this.itemClickListener = null;

    }

    public interface OnItemClickListener {
        void onItemClick(View view, Site site, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.itemClickListener = mItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(itemView);
        return  itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        if (viewHolder instanceof ItemViewHolder) {

            Site site = this.sitesFiltered.get(position);

            ((ItemViewHolder) viewHolder).getSiteName().setText(site.getTitre());
            ((ItemViewHolder) viewHolder).getSiteCategory().setText(site.getCategorie());
            ((ItemViewHolder) viewHolder).getLocation().setText(site.getLocalisation());
            Glide.with(((ItemViewHolder) viewHolder).getSiteImageView().getContext())
                    .load(site.getImgs().get(0))
                    .into(((ItemViewHolder) viewHolder)
                            .getSiteImageView());
            Boolean x = (this.itemClickListener != null);

            if (this.itemClickListener != null) {

                ((ItemViewHolder) viewHolder).holderCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.onItemClick(view,sitesFiltered.get(position),position);
                    }


                    public void onItemClick(View view, Site site, int i) {
                        Toast.makeText(view.getContext(), "item clicked 00000", Toast.LENGTH_LONG).show();
                        itemClickListener.onItemClick(view,sitesFiltered.get(position),position);
                    }
                });



            }
        }
    }



    @Override
    public int getItemCount() {
        if (this.sites != null) {

            return this.sitesFiltered.size();
        }
        return 0;
    }

    @Override // android.widget.Filterable
    @NotNull
    public Filter getFilter() {
        return new Filter() {
            @Override
            @NotNull
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.length() == 0) {
                    sitesFiltered = sites;
                } else {
                    ArrayList filteredList = new ArrayList<Site>();
                    if (sites != null) {
                        for (Site row : sites) {
                            if (row.getLocalisation().toLowerCase().contains(charString.toLowerCase()) || row.getCategorie().toLowerCase().contains(
                                    charString.toLowerCase()
                            ) || row.getTitre().toLowerCase().contains(charString.toLowerCase())
                            ) {
                                filteredList.add(row);
                            }
                        }
                    }
                    sitesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = sitesFiltered;
                return filterResults;
            }


            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                sitesFiltered = (ArrayList<Site>) filterResults.values;
                RecyclerViewAdapter.this.notifyDataSetChanged();
            }
        };
    }




    public final class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView siteImageView;
        private TextView siteTitre;
        private TextView siteCategorie;
        private TextView location;
        private CardView holderCardView;


        public ItemViewHolder(View view) {
            super(view);

            siteImageView = (ImageView) view.findViewById(R.id.siteImageView);
            siteTitre = (TextView) view.findViewById(R.id.siteNameTextView);
            siteCategorie = (TextView) view.findViewById(R.id.siteCategoryTextView);
            location = (TextView) view.findViewById(R.id.LocationText);
            holderCardView = (CardView) view.findViewById(R.id.cardViewHolder);

        }

        public ImageView getSiteImageView() {
            return siteImageView;
        }

        public void setSiteImageView(ImageView siteImageView) {
            this.siteImageView = siteImageView;
        }

        public TextView getSiteName() {
            return siteTitre;
        }

        public void setSiteName(TextView siteTitre) {
            this.siteTitre = siteTitre;
        }

        public TextView getSiteCategory() {
            return siteCategorie;
        }

        public void setSiteCategory(TextView siteCategorie) {
            this.siteCategorie = siteCategorie;
        }

        public TextView getLocation() {
            return location;
        }

        public void setLocation(TextView location) {
            this.location = location;
        }

        public CardView getHolderCardView() {
            return holderCardView;
        }

        public void setHolderCardView(CardView holderCardView) {
            this.holderCardView = holderCardView;
        }


    }
}
