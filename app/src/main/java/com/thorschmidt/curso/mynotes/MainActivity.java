package com.thorschmidt.curso.mynotes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.thorschmidt.curso.mynotes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bindingAM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingAM = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindingAM.getRoot());

        getPrefs();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePrefs();
            }
        });
    }

    /**
     * Show Snackbar
     * @param view
     */
    private void showSnackbar(View view, String text, String action) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
                .setAction(action, null).show();
    }

    /**
     * Get the saved notes from prefs file
     */
    private void getPrefs() {
        String notes = Prefs.getPrefs(getApplicationContext(), Prefs.PREFS_KEY_NOTES);
        if (notes.isEmpty() || notes.equals("") || notes == null){
            showSnackbar(bindingAM.getRoot(),"No notes saved yet!","ok");
        }else {
            EditText edit = findViewById(R.id.editNotes);
            edit.setText(notes);
            showSnackbar(bindingAM.getRoot(),"Your notes were loaded!","ok");
        }

    }

    /**
     * Save notes on prefs file
     */
    private void savePrefs() {
        EditText edit = findViewById(R.id.editNotes);
        Prefs.savePrefs(getApplicationContext(), Prefs.PREFS_KEY_NOTES,edit.getText().toString());
        showSnackbar(bindingAM.getRoot(), "Notes saved!", "ok");
    }

}
