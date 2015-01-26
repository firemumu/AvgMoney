package com.avgmoney.app.activity;

import java.util.Date;
import java.util.List;

import com.avgmoney.app.R;
import com.avgmoney.app.logic.CommodityLogic;
import com.avgmoney.app.model.Commodity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends Activity implements OnClickListener {

    private Button add;
    private Button del;
    private Button query;
    private Button update;
    private TextView add_text;
    private TextView del_text;
    private TextView query_text;
    private TextView update_text;

    private CommodityLogic commodityLogic;

    private List<Commodity> commoditys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        commodityLogic = new CommodityLogic(this);

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);
        del = (Button) findViewById(R.id.del);
        del.setOnClickListener(this);
        query = (Button) findViewById(R.id.query);
        query.setOnClickListener(this);
        update = (Button) findViewById(R.id.update);
        update.setOnClickListener(this);

        add_text = (TextView) findViewById(R.id.add_text);
        del_text = (TextView) findViewById(R.id.del_text);
        query_text = (TextView) findViewById(R.id.query_text);
        update_text = (TextView) findViewById(R.id.update_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.add:
            Commodity c = new Commodity();
            c.setName("mac book pro");
            c.setData(new Date());
            c.setNotes("");
            c.setPrice(8588.9);
            commodityLogic.addCommodity(c);
            break;
        case R.id.del:

            break;
        case R.id.query:
            commoditys = commodityLogic.queryCommodity();
            String temp = "";
            for (int i = 0; i < commoditys.size(); i++) {
                temp = commoditys.get(i).toString() + "\\";
            }
            query_text.setText(temp);
            break;
        case R.id.update:

            break;
        }
    }

}
