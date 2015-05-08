package fragments.android.example.com.test2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

   public static String ART_STRING="str";


    public DetailFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        String str = getArguments() != null ? getArguments().getString(ART_STRING) : "";
        TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        textView1.setText(str);

        return view;
    }



}
