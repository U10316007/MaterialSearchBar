package com.mancj.example.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.mancj.example.R;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterActivity extends AppCompatActivity implements View.OnClickListener {
    private MaterialSearchBar searchBar;
    private List<Product> suggestions = new ArrayList<>();
    private CustomSuggestionsAdapter customSuggestionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        customSuggestionsAdapter = new CustomSuggestionsAdapter(inflater);

        Button addProductBtn = (Button) findViewById(R.id.button);
        addProductBtn.setOnClickListener(this);
//        for (int i = 1; i < 11; i++) {
//            suggestions.add(new Product("Product " + i, i * 10));
//        }
        customSuggestionsAdapter.setSuggestions(suggestions);

        searchBar.setCustomSuggestionAdapter(customSuggestionsAdapter);

    }

    @Override
    public void onClick(View view) {
        customSuggestionsAdapter.addSuggestion(new Product("Product", 100));
    }

}
