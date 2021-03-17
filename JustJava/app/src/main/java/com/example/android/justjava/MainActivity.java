package com.example.android.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    TextView quantityTextView;
    int quantity;
    int numberOfToppings = 4;
    String [] toppingAnswers = new String [numberOfToppings];
    String content = "";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        quantityTextView = (TextView) findViewById (R.id.quantity_text_view);
        quantity = Integer.parseInt (quantityTextView.getText ().toString ());
    }

    public void checkOrder (View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById (R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById (R.id.chocolate_checkbox);
        CheckBox cinnamonCheckBox = (CheckBox) findViewById (R.id.cinnamon_checkbox);
        CheckBox caramelCheckBox = (CheckBox) findViewById (R.id.caramel_checkbox);
        Button orderButton = (Button) findViewById (R.id.order_button);

        double cupPrice = 5;
        double whippedCreamPrice = 1;
        double chocolatePrice = 2;
        double cinnamonPrice = 0.5;
        double caramelPrice = 2;
        double totalPrice = cupPrice;

        if (whippedCreamCheckBox.isChecked()) {
            updateToppings (0, getString (R.string.add_whipped_cream));
            totalPrice += whippedCreamPrice;
        }

        if (!whippedCreamCheckBox.isChecked())
            updateToppings (0, "");

        if (chocolateCheckBox.isChecked()) {
            updateToppings (1, getString (R.string.add_chocolate));
            totalPrice += chocolatePrice;
        }

        if (!chocolateCheckBox.isChecked())
            updateToppings (1, "");

        if (cinnamonCheckBox.isChecked()) {
            updateToppings (2, getString (R.string.add_cinnamon));
            totalPrice += cinnamonPrice;
        }

        if (!cinnamonCheckBox.isChecked())
            updateToppings (2, "");

        if (caramelCheckBox.isChecked()) {
            updateToppings (3, getString (R.string.add_caramel));
            totalPrice += caramelPrice;
        }

        if (!caramelCheckBox.isChecked())
            updateToppings (3, "");

        displayQuantity (quantity);
        displayOrder (totalPrice * quantity);
        orderButton.setEnabled (true);
    }

    private void updateToppings (int toppingNumber, String answer) {
        toppingAnswers [toppingNumber] = answer;
    }

    public void increment (View view) {
        quantity++;
        displayQuantity (quantity);
    }

    public void decrement (View view) {
        quantity--;

        if (quantity < 0)
            quantity = 0;

        displayQuantity (quantity);
    }

    private void displayQuantity (int number) {
        quantityTextView.setText ("" + number);
    }

    private void displayOrder (double price) {
        TextView displayView = (TextView) findViewById (R.id.display_text_view);
        EditText  editView = (EditText) findViewById (R.id.edit_name);
        String name = editView.getText ().toString ();

        String toppings = "";

        for (int i = 0; i < toppingAnswers.length; i++) {
            if (!toppingAnswers [i].equals(""))
            toppings += "\n" + toppingAnswers [i];
        }

        if (name.equals (""))
            name = getString (R.string.no_name);

        content = (getString (R.string.name) + name + toppings +
                   "\n" + getString (R.string.quantity) + quantity +
                   "\n" + getString (R.string.total) +
                    NumberFormat.getCurrencyInstance ().format (price) +
                   "\n" + getString (R.string.thank_you));

        displayView.setText (content);
    }

    public void sendOrder (View view) {
        Intent intent = new Intent (Intent.ACTION_SENDTO);
        intent.setData (Uri.parse ("mailto:"));
        intent.putExtra (Intent.EXTRA_SUBJECT, "Just Java " + getString (R.string.order) + name);
        intent.putExtra (Intent.EXTRA_TEXT, content);
        if (intent.resolveActivity (getPackageManager ()) != null)
            startActivity (intent);
    }
}
