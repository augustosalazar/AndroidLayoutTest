package com.uninorte.layouttest2;

import android.app.Activity;
import android.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class RelativeLayoutFragment extends Fragment implements OnClickListener {

	private Callback callback;
	private static final String TAG = RelativeLayoutFragment.class.getSimpleName();
	
	@Override
	public void onAttach(Activity activity) {
		try {
			callback = (Callback) activity;
		} catch (ClassCastException e) {
			Log.d(TAG, e.getMessage());
			throw new ClassCastException(activity.toString()
					+ " must implement WelcomeFragment.Callback");
		}
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d("RelativeLayout", "onCreateView :)");

		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		Button buttonLinearLayout = (Button) rootView
				.findViewById(R.id.buttonLinearLayout);
		buttonLinearLayout.setOnClickListener(this);
		
		Button buttonTableLayout = (Button) rootView
				.findViewById(R.id.buttonTableLayout);
		buttonTableLayout.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonLinearLayout:
			callback.onLinerLayoutFragmentClick();
			Log.d("RelativeLayout", "OnClick buttonLinearLayout");
			break;
		case R.id.buttonTableLayout:
			Log.d("RelativeLayout", "OnClick buttonTableLayout");
			callback.onTableLayoutFragmentClick();
			break;
		default:
			Log.d("RelativeLayout", "OnClick default");
			break;
		}

	}
	
	public interface Callback {
		public void onLinerLayoutFragmentClick();

		public void onTableLayoutFragmentClick();

	}

}
