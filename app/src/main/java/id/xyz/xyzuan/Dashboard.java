//
// Copyright (c) 2020, xyzscape prjkt
//

package id.xyz.xyzuan;

// Main
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import android.widget.Switch;
import android.content.Intent;

// xyz Activity
import id.xyz.xyzuan.Activity.xyz_center;
import id.xyz.xyzuan.Activity.xyz_sysinfo;
import id.xyz.xyzuan.Activity.xyz_game;
import id.xyz.xyzuan.Activity.xyz_me;

public class Dashboard extends AppCompatActivity  {
    
    // CardView List
    CardView xyz_me ;
    CardView xyz_sysinfo ;
    CardView xyz_game ;
    CardView xyz_center ;
    
    // Intent List
    Intent center ;
    Intent sysinfo ;
    Intent game ;
    Intent me ;
    
    // Main Layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        // ID
        xyz_center = findViewById(R.id.xyz_center);
        xyz_sysinfo = findViewById(R.id.xyz_sysinfo);
        xyz_me = findViewById(R.id.xyz_me);
        xyz_game = findViewById(R.id.xyz_game);
        
        // Intent
        center = new Intent(this,xyz_center.class);
        sysinfo = new Intent(this,xyz_sysinfo.class);
        game = new Intent(this,xyz_game.class);
        me = new Intent(this,xyz_me.class);
        
        // OnClick
        xyz_center.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(center);
                }
            });
            
        xyz_sysinfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(sysinfo);
                }
            });
            
        xyz_game.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(game);
                }
            });
            
        xyz_me.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(me);
                }
            });

    }
}
