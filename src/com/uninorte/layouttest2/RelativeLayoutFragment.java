package com.uninorte.layouttest2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class RelativeLayoutFragment extends Fragment implements OnClickListener{

    private LinearLayoutFragment fragmentTwo;
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	Log.d("RelativeLayout","onCreateView :)");
   
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        
    	
    	Button buttonLinearLayout = (Button) rootView.findViewById(R.id.buttonLinearLayout);
    	buttonLinearLayout.setOnClickListener(this);
    	
    	return rootView;
    }

	@Override
	public void onClick(View v) {
		 switch(v.getId()){
         case R.id.buttonLinearLayout:
        
            fragmentTwo = new LinearLayoutFragment();

//            fragmentTransaction.replace(R.id., fragmentTwo);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();  
         
         Log.d("RelativeLayout","OnClick buttonLinearLayout");
         break;
         default:
        	 Log.d("RelativeLayout","OnClick default");
        	 break;
     }  
		
	}
	
}
