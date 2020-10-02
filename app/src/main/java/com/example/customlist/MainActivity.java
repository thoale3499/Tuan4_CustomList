package com.example.customlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String mTitle[] = {"Android","Java","PHP","Python","MySQL"};
    String mDesc[] = {"Android Description", "Java Description", "PHP Description", "Python Description", "MySQL Description"};
    int img[] = {R.drawable.android,R.drawable.java,R.drawable.php,R.drawable.python,R.drawable.mysql};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.List);

        myAdapter adapter = new myAdapter(this, mTitle, mDesc, img);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Android Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Java Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "PHP Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Python Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0){
                    Toast.makeText(MainActivity.this, "MySQL Description", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    class myAdapter extends ArrayAdapter<String> {
        Context ct;
        String rTitle[];
        String rDesc[];
        int rImg[];

        myAdapter(Context c, String title[], String desc[], int images[]){
            super(c, R.layout.rowlist, R.id.tv1, title);
            this.ct = c;
            this.rTitle = title;
            this.rDesc = desc;
            this.rImg = images;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater li = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = li.inflate(R.layout.rowlist,parent,false);
            ImageView imgs = row.findViewById(R.id.anh);
            TextView myTitle = row.findViewById(R.id.tv1);
            TextView myDesc  = row.findViewById(R.id.tv2);

            imgs.setImageResource(rImg[position]);
            myTitle.setText(rTitle[position]);
            myDesc.setText(rDesc[position]);

            return row;
        }
    }
}