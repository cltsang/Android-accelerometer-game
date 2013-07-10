package com.example.csci3310project10;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class LevelSelector extends MyActivity {
	ImageButton[] levelButtons = new ImageButton[20];
	Intent i;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_selector);
		//if( bgmManager.playerExists()) Toast.makeText(getApplicationContext(), "BGM not null!!", Toast.LENGTH_SHORT).show();
		i = new Intent(this, GameActivity.class);

		levelButtons[0] = (ImageButton)findViewById(R.id.imageButton1);
		levelButtons[1] = (ImageButton)findViewById(R.id.imageButton2);
		levelButtons[2] = (ImageButton)findViewById(R.id.imageButton3);
		levelButtons[3] = (ImageButton)findViewById(R.id.imageButton4);
		levelButtons[4] = (ImageButton)findViewById(R.id.imageButton5);
		levelButtons[5] = (ImageButton)findViewById(R.id.imageButton6);
		levelButtons[6] = (ImageButton)findViewById(R.id.imageButton7);
		levelButtons[7] = (ImageButton)findViewById(R.id.imageButton8);
		levelButtons[8] = (ImageButton)findViewById(R.id.imageButton9);
		levelButtons[9] = (ImageButton)findViewById(R.id.imageButton10);
		levelButtons[10] = (ImageButton)findViewById(R.id.imageButton11);
		levelButtons[11] = (ImageButton)findViewById(R.id.imageButton12);
		levelButtons[12] = (ImageButton)findViewById(R.id.imageButton13);
		levelButtons[13] = (ImageButton)findViewById(R.id.imageButton14);
		levelButtons[14] = (ImageButton)findViewById(R.id.imageButton15);
		levelButtons[15] = (ImageButton)findViewById(R.id.imageButton16);
		levelButtons[16] = (ImageButton)findViewById(R.id.imageButton17);
		levelButtons[17] = (ImageButton)findViewById(R.id.imageButton18);
		levelButtons[18] = (ImageButton)findViewById(R.id.imageButton19);
		levelButtons[19] = (ImageButton)findViewById(R.id.imageButton20);
		
		for(int i=0; i<20; i++)
			setButtonAction(levelButtons[i]);
		
	}
	
	private void setButtonAction(ImageButton button){
		button.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				i.putExtra("level", Integer.parseInt(v.getContentDescription().toString()));
android.util.Log.i("info", "LevelSelector.setButtonAction() : " + v.getContentDescription().toString());
				startActivity(i);
				finish();
			}
		});
	}

}
