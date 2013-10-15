package com.fran.taxiseguro.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

import com.fran.taxiseguro.R;
import com.fran.taxiseguro.TaxiPlateActivity;

public class TaxiPlateActivityTest extends ActivityInstrumentationTestCase2<TaxiPlateActivity> {

	private TaxiPlateActivity taxiPlateActivity;
	
	private TextView plateText;
	private Button comenzarButton;
	
	private Instrumentation mInstrumentation;
	
	public TaxiPlateActivityTest() {
		super("com.fran.taxiseguro", TaxiPlateActivity.class);
		// TODO Auto-generated constructor stub
		
	}
	
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		
		setActivityInitialTouchMode(false);
		taxiPlateActivity = getActivity();
		plateText = (TextView)taxiPlateActivity.findViewById(com.fran.taxiseguro.R.id.matriculaText);
		comenzarButton  = (Button)taxiPlateActivity.findViewById(com.fran.taxiseguro.R.id.comenzarButton);
		mInstrumentation = getInstrumentation();
	}
	public void testPreConditions(){
		assertTrue(plateText.getText().toString().equals(""));
	}
	
	@UiThreadTest
	public void testValidPlateText() {
		/*
		 * request focus for the Spinner, so that the test can send key events to it
		 * This request must be run on the UI thread. To do this, use the runOnUiThread method
		 * and pass it a Runnable that contains a call to requestFocus on the Spinner.
		 */

		plateText.requestFocus();
		plateText.setText("ADB481");
	    comenzarButton.performClick();
	    assertTrue(validateCorrectFormat(plateText.getText().toString()));
	}


	private boolean validateCorrectFormat(String plate) {
		boolean validPlate = false;
		if(plate != null && plate.length() == 7 && plate.contains("-")){
			validPlate = true;
		}
		return validPlate;
	}

}
