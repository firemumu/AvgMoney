package com.avgmoney.app.activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.avgmoney.app.R;
import com.avgmoney.app.activity.widget.ListDialog;
import com.avgmoney.app.logic.CommodityLogic;
import com.avgmoney.app.logic.CommodityTypeLogic;
import com.avgmoney.app.model.Commodity;
import com.avgmoney.app.model.CommodityType;

public class AddCommodityActivity extends Activity implements OnClickListener {

    public static final int SELECT_TYPE_REQUEST_CODE = 0;

    private ImageView back;
    private TextView title;
    private TextView ok;

    private EditText commodityName;
    private EditText commodityPrice;
    private TextView commodityDate;
    private TextView commodityType;
    private EditText commodityNote;

    private CommodityLogic commodityLogic;
    private CommodityTypeLogic commodityTypeLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_commodity_activity);

        commodityLogic = new CommodityLogic(this);
        commodityTypeLogic = new CommodityTypeLogic(this);

        back = (ImageView) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        title.setText(R.string.add_commodity);
        ok = (TextView) findViewById(R.id.ok);
        back.setOnClickListener(this);
        ok.setOnClickListener(this);

        commodityName = (EditText) findViewById(R.id.add_commodity_name);
        commodityPrice = (EditText) findViewById(R.id.add_commodity_price);
        commodityDate = (TextView) findViewById(R.id.add_commodity_date);
        commodityType = (TextView) findViewById(R.id.add_commodity_type);
        commodityNote = (EditText) findViewById(R.id.add_commodity_note);
        commodityDate.setOnClickListener(this);
        commodityType.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.back:
            finish();
            break;
        case R.id.ok:
            saveCommodity();
            break;
        case R.id.add_commodity_date:
            showDateDialog();
            break;
        case R.id.add_commodity_type:
            showTypeDialog();
            break;
        }
    }

    private void showDateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.date_time_dialog, null);
        final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
        builder.setView(view);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

        builder.setTitle("选取时间");
        builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuffer sb = new StringBuffer();
                sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
                sb.append("  ");
                commodityDate.setText(sb);
                Calendar newExpiryCalendar = new GregorianCalendar(datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth());
                commodityDate.setTag(newExpiryCalendar);
                dialog.cancel();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

    private void showTypeDialog() {
        Intent intent = new Intent(this, ListDialog.class);
        this.startActivityForResult(intent, SELECT_TYPE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 20) {
            CommodityType type = new CommodityType();
            type.setId(data.getIntExtra("type_id", 0));
            type.setName(data.getStringExtra("type_name"));
            commodityType.setText(type.getName());
            commodityType.setTag(type);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void saveCommodity() {
        Commodity c = getParameters();
    }

    private Commodity getParameters() {
        Commodity c = new Commodity();
        c.setName(commodityName.getText().toString());
        c.setDate((Date) commodityDate.getTag());
        c.setType((CommodityType) commodityType.getTag());
        c.setPrice(Double.parseDouble(commodityPrice.getText().toString()));
        c.setNotes(commodityNote.getText().toString());
        return c;
    }

}
