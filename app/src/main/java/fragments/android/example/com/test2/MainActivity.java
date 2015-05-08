package fragments.android.example.com.test2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, HeaderFragment.onItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // ตรวจ Screen Orientation ว่าเป็น Portrait หรือ Landscape
        // เนื่องจากใช้ Layout คนละตัวกัน ทำให้ Objects ใน ViewGroup ไม่เหมือนกัน ซึ่งจะใช้เป็นตัวตรวจสอบ

        setContentView(R.layout.activity_main);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 1) ถ้าหน้าจอเป็น Landscape ก็ให้แสดงผลตาม layout-land เลยเพราะได้กำหนด View Group ไว้แล้ว

            HeaderFragment headerFragment = (HeaderFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_header);
            TextView item1 = (TextView) headerFragment.getView().findViewById(R.id.item1);
            TextView item2 = (TextView) headerFragment.getView().findViewById(R.id.item2);
            TextView item3 = (TextView) headerFragment.getView().findViewById(R.id.item3);
            TextView item4 = (TextView) headerFragment.getView().findViewById(R.id.item4);
            TextView item5 = (TextView) headerFragment.getView().findViewById(R.id.item5);
            item1.setOnClickListener(this);
            item2.setOnClickListener(this);
            item3.setOnClickListener(this);
            item4.setOnClickListener(this);
            item5.setOnClickListener(this);

        } else {
            // 2) ถ้าหน้าจอเป็น Portrait จะกำหนด Fragment Manger เพื่อให้สร้าง Fragment ใน Container ที่ได้สร้างรอไว้แล้ว

            if (findViewById(R.id.header_container) != null) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.header_container, new HeaderFragment(), "header");
                //ft.addToBackStack("header");
                ft.commit();
                fm.executePendingTransactions();



            }


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item1 :
                setText("Stringggggggggggggg 111111111111111111111111");
                break;
            case R.id.item2 :
                setText("Stringggggggggggggg 222222222222222222222222");
                break;
            case R.id.item3 :
                setText("Stringggggggggggggg 333333333333333333333333");
                break;
            case R.id.item4 :
                setText("Stringggggggggggggg 444444444444444444444444");
                break;
            case R.id.item5 :
                setText("Stringggggggggggggg 555555555555555555555555");
                break;
            default: break;
        }
    }

    void setText(String str) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detail);
        TextView textView1 = (TextView) detailFragment.getView().findViewById(R.id.textView1);
        textView1.setText(str);
    }

    @Override
    public void onItemSelected(String str) {

        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(DetailFragment.ART_STRING, str);
        detailFragment.setArguments(args);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.header_container, detailFragment, "detail");
        ft.addToBackStack("detail");
        ft.commit();
        fm.executePendingTransactions();




    }
}
