package com.example.votingapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Count extends Activity {
	TextView tv2,tv4,tv6;
	Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count);
		tv2=(TextView)findViewById(R.id.tv2);
		tv4=(TextView)findViewById(R.id.tv4);
		tv6=(TextView)findViewById(R.id.tv6);
		b1=(Button)findViewById(R.id.b1);
		
		b2=(Button)findViewById(R.id.b2);
		
		try {
			String temp="";
			String[] entryA = new String[20];
			FileInputStream fin=openFileInput("vote.txt");
			InputStreamReader isr=new InputStreamReader(fin);
			char[] inputBuffer=new char[40];
			int charRead;
			 while ((charRead = isr.read(inputBuffer))>0) {  
	                String readString=String.copyValueOf(inputBuffer,0,charRead);
	                temp= readString;
	                inputBuffer=new char[40]; 
			 }
			 entryA=temp.split("-");
			 
		String e1=entryA[0].toString();
		String e2=entryA[1].toString();
		String e3=entryA[2].toString();
		tv2.setText(e1);
		tv4.setText(e2);
		tv6.setText(e3);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(Count.this, Login.class);
				startActivity(i);
				finish();
				
			}
		});
		
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try {
					
					
					FileOutputStream fo=openFileOutput("voter.txt", MODE_PRIVATE);
					OutputStreamWriter osw=new OutputStreamWriter(fo);
					osw.write("abc,1234,0,xyz,5678,0");
					osw.close();
					Toast.makeText(getBaseContext(), "Sucessfully initialized voter", Toast.LENGTH_SHORT).show();
					
					
					
					
					FileOutputStream fout=openFileOutput("vote.txt", MODE_PRIVATE);
					OutputStreamWriter os=new OutputStreamWriter(fout);
					os.write("0-0-0");
					os.close();
					Toast.makeText(getBaseContext(), "Sucessfully initialized counts", Toast.LENGTH_SHORT).show();
					
					
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.count, menu);
		return true;
	}

}
