package id.xyz.xyzuan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import id.xyz.xyzuan.R;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }
    public void Idea(View view) {
        Toast.makeText(this, "Hayooo mau cari apa", Toast.LENGTH_LONG).show();
    }
    public void Work(View view) {
        Toast.makeText(this, "masih sekolah yang, belom kerja nich", Toast.LENGTH_LONG).show();
    }
    public void About(View view) {
        Toast.makeText(this, "Saya hanya manusia biasa", Toast.LENGTH_LONG).show();
    }
    public void Health(View view) {
        Toast.makeText(this, "Aku baik baik saja kok", Toast.LENGTH_LONG).show();
    }
    public void Food(View view) {
        Toast.makeText(this, "Masih kenyang beb", Toast.LENGTH_LONG).show();
    }
    public void Gym(View view) {
        Toast.makeText(this, "Ga ngegym beb, saya kerempeng", Toast.LENGTH_LONG).show();
    }
    public void Settings(View view) {
        Toast.makeText(this, "Saya ga suka diatur beb", Toast.LENGTH_LONG).show();
    }
    public void Delete(View view) {
        Toast.makeText(this, "Jangan apus aku ;( , aku masi sayang kamu nye :* ", Toast.LENGTH_LONG).show();
    }
}
