//
// Copyright (c) 2020, xyzscape prjkt
//

package id.xyz.xyzuan.Activity;

// Main
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import android.widget.Switch;
import android.content.Intent;
import id.xyz.xyzuan.R;

// xyz Activity
import com.codepath.examples.basicsnakegame.SnakeGameActivity;

public class xyz_game extends AppCompatActivity  {

    // CardView List
    CardView xyz_game ;

    // Intent List
    Intent SnakeGameActivity ;

    // Main Layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xyz_game);

        // ID
        xyz_game = findViewById(R.id.game_snake);

        // Intent
        SnakeGameActivity = new Intent(this,SnakeGameActivity.class);
       
        // OnClick
        xyz_game.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(SnakeGameActivity);
                }
            });
    }
}
