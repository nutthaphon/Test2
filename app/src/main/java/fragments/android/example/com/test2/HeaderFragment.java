package fragments.android.example.com.test2;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeaderFragment extends Fragment implements View.OnClickListener {

    onItemSelectedListener listener;


    public HeaderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof onItemSelectedListener) {
            listener = (onItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }


    public interface onItemSelectedListener {
        public void onItemSelected(String str);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header,container, false);

        TextView item1 = (TextView) view.findViewById(R.id.item1);
        item1.setOnClickListener(this);
        TextView item2 = (TextView) view.findViewById(R.id.item2);
        item2.setOnClickListener(this);
        TextView item3 = (TextView) view.findViewById(R.id.item3);
        item3.setOnClickListener(this);
        TextView item4 = (TextView) view.findViewById(R.id.item4);
        item4.setOnClickListener(this);
        TextView item5 = (TextView) view.findViewById(R.id.item5);
        item5.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.item1 :
                replaceDetail("String 1111111111111111111111");
                break;
            case R.id.item2 :
                replaceDetail("String 2222222222222222222222");
                break;
            case R.id.item3 :
                replaceDetail("String 3333333333333333333333");
                break;
            case R.id.item4 :
                replaceDetail("String 4444444444444444444444");
                break;
            case R.id.item5 :
                replaceDetail("String 5555555555555555555555");
                break;
            default: break;
        }
    }

    void replaceDetail(String str) {
        listener.onItemSelected(str);
    }

}
