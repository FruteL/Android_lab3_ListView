package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private List<Band> list;
    //привязка листа из ЮИ
    @BindView(R.id.listview)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //создание данных, для листа
        List<Band> bands = new ArrayList<>();
        bands.add(new Band("Ночные Снайпера", "1993/8/19", "Рок", "Long", R.drawable.ns));
        bands.add(new Band("Кино", "1981", "Рок", "Long", R.drawable.kinof));
        bands.add(new Band("Scorpions", "1965", "Рок", "Long", R.drawable.scorpions));
        bands.add(new Band("Noize MC", "2003", "Хип-хоп", "Long", R.drawable.nm));
        bands.add(new Band("Канцлер Ги", "2002", "менестрельская песня", "Long", R.drawable.kg));
        bands.add(new Band("АнимациЯ", "2000", "Рок", "Long", R.drawable.an));
        bands.add(new Band("Любэ", "1989/1/14", "Фолк", "Long", R.drawable.lb));
        //Подключение адаптера
        myAdapter adapter = new myAdapter(bands, this);
        lv.setAdapter(adapter);
        //Навесил слушателя для обработки нажатий
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InfoPageActivity.class);
                intent.putExtra("name", bands.get(position).getName());
                intent.putExtra("ganre", bands.get(position).getGanre());
                intent.putExtra("date", bands.get(position).getDate());
                intent.putExtra("info", bands.get(position).getLong_info());
                intent.putExtra("avatar", bands.get(position).getAvatarID());
                startActivity(intent);
            }
        });

    }

    //Класс адаптера
    class myAdapter extends BaseAdapter{
        private List<Band> list;
        private LayoutInflater inflater;


        public myAdapter(List<Band> list, Context context) {
            this.list = list;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        //Тут происходит привязка данных к элементам интерфейса
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.card_view, parent, false);

            TextView name = view.findViewById(R.id.bandname);
            name.setText(list.get(position).getName());

            TextView info = view.findViewById(R.id.shortInfo);
            info.setText(list.get(position).getGanre());

            ImageView image = view.findViewById(R.id.imageView);
            image.setImageResource(list.get(position).getAvatarID());

            return view;
        }
    }
}
