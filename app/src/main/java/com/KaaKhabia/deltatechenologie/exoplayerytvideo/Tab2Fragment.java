package com.KaaKhabia.deltatechenologie.exoplayerytvideo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Tab2Fragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tab2_fragment,container,false);
        Button visiteYoutubeBt = view.findViewById(R.id.idChannelYoutube);
        Button btRechargerfacilent = view.findViewById(R.id.btRechargerFacilement);
        Button btElkolFiElkol = view.findViewById(R.id.btElkolFiElkol);

          visiteYoutubeBt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  youtubeChannel();
              }
          });

          btRechargerfacilent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playStoreApps("com.gtari.deltatechenologie.rechargerfacilement");

            }
           });

          btElkolFiElkol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playStoreApps("com.gtari.deltatechenologie.elkolxelkol");
            }
           });

        return view;
    }

    // launch Play Store intent
    private void playStoreApps(String app_id) {
        Uri marketUri = Uri.parse("market://details?id=" + app_id);
        Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
        startActivity(marketIntent);
    }

    // launch Channel youtube
    private void youtubeChannel(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String url ="https://www.youtube.com/channel/UChMGgb8ey91j82P3ODTVwSA";
        try {
            intent.setPackage("com.google.android.youtube");
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    }
}
