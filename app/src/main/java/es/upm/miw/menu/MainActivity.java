package es.upm.miw.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tvTexto);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        // Options 1..3 are added to the menu from xml
        // Option 4 is added to the menu programmatically
        menu.add(Menu.NONE, 4, Menu.NONE, R.string.txtOpcion4);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
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
                return true;
            case R.id.opcContextual02:
                Toast.makeText(this, getString(R.string.txtOpcCtx2), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
