package br.com.kilometagem.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class VerRegistrosActivity extends AppCompatActivity {

    ListView listView;

    public RegistroAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registros);

        listView = (ListView)findViewById(R.id.lstKm);

        List<Registro> lstRegistro = Registro.listAll(Registro.class);



        adapter = new RegistroAdapter(this,lstRegistro);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, BonusActivity.class);
        startActivity(intent);

        return true;
    }

    public void chamarAddRegistro(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public class RegistroAdapter extends ArrayAdapter<Registro> {
        public RegistroAdapter(Context ctx, List<Registro> itens){
            super(ctx,0,itens);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {

            View v = convertView;

            if(v == null){
                v = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
            }

            Registro item = getItem(position);

            TextView txtMes= v.findViewById(R.id.txtMes);
            TextView txtKilometro = v.findViewById(R.id.txtKilometros);

            txtMes.setText(item.getMes());
            txtKilometro.setText(item.getKilometros().toString());


            return v;
        }


    }






}
