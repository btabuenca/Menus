package es.upm.btb.menus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = findViewById(R.id.btn_menu_emerg);
        btnMenu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showPopupMenu();
                return true;
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMenu.setTextColor(Color.BLACK);
                btnMenu.setText(R.string.envio_normal);
            }
        });

        textView = findViewById(R.id.tvTexto);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_barra, menu);
        // Options 1..3 are added to the menu from xml
        // Option 4 is added to the menu programmatically
        menu.add(Menu.NONE, 4, Menu.NONE, R.string.txtOpcion4);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
                Intent myIntent = new Intent(this, AboutActivity.class);
                myIntent.putExtra("key", "value"); //Optional parameters
                startActivity(myIntent);
                //TODO cerrar activitydad corriente y abrir nueva
                Toast.makeText(this, getString(R.string.txtOpcion1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion2:
                Toast.makeText(this, getString(R.string.txtOpcion2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion3:
                Toast.makeText(this, getString(R.string.txtOpcion3), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "OTRA OPCIÓN!!!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcContextual01:
                Toast.makeText(this, getString(R.string.txtOpcCtx1), Toast.LENGTH_SHORT).show();
                textView.setText(R.string.txtOpcCtx1);
                return true;
            case R.id.opcContextual02:
                Toast.makeText(this, getString(R.string.txtOpcCtx2), Toast.LENGTH_SHORT).show();
                textView.setText(R.string.txtOpcCtx2);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_emergente, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                // Las menus emergentes ofertan acciones adicionales a las ya
                // inherentes al control que se pulsa
                switch (item.getItemId()) {
                    case R.id.menuItemGray:
                        btnMenu.setBackgroundColor(Color.GRAY);
                        btnMenu.setText(R.string.envio_posponer);
                        return true;
                    case R.id.menuItemGreen:
                        btnMenu.setBackgroundColor(Color.GREEN);
                        btnMenu.setText(R.string.envio_economico);
                        return true;
                    case R.id.menuItemRojo:
                        btnMenu.setBackgroundColor(Color.RED);
                        btnMenu.setText(R.string.envio_urgente);
                        return true;


                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
}