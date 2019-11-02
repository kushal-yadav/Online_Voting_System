package com.example.votingapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.os.DropBoxManager.Entry;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	EditText e1,e2;
	Button b1,b2;
	TextView tv1;
	
	// String[] entryA = new String[50];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		e1=(EditText)findViewById(R.id.e1);
		e2=(EditText)findViewById(R.id.e2);
		b1=(Button)findViewById(R.id.b1);
		b2=(Button)findViewById(R.id.b2);
		tv1=(TextView)findViewById(R.id.tv1);
	
		
		try {
			String[] entryA = null;
			String temp="";
			FileInputStream f=openFileInput("voter.txt");
			InputStreamReader isr=new InputStreamReader(f);
			char[] inputBuffer=new char[40];
			int charRead;
			 while ((charRead = isr.read(inputBuffer))>0) {  
	                String readString=String.copyValueOf(inputBuffer,0,charRead);
	                temp= readString;
	                inputBuffer=new char[40]; 
			 }
	             
			
			 if(temp!=null)
			 {
				
				 entryA=temp.split(",");
				 
			 }
			 
			 else
			 {
				 Toast.makeText(getBaseContext(), "file does not exist", Toast.LENGTH_SHORT).show();
			 }
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	

	
	
		
		b1.setOnClickListener(new OnClickListener() {
			
			

			@Override
			public void onClick(View v) {
				String s1=e1.getText().toString();
				String s2=e2.getText().toString();
		
				
			
				
				
				
				if(s1.equals("")|| s2.equals(""))
				{
					Toast.makeText(Login.this, "Please enter all your details", Toast.LENGTH_SHORT).show();
				}
					
			else
				{
				try
				{
				String[] entryA = new String[20];
				String temp="";
				FileInputStream f=openFileInput("voter.txt");
				InputStreamReader isr=new InputStreamReader(f);
				char[] inputBuffer=new char[40];
				int charRead;
				 while ((charRead = isr.read(inputBuffer))>0) {  
		                String readString=String.copyValueOf(inputBuffer,0,charRead);
		                temp= readString;
		                inputBuffer=new char[40]; 
				 }
				 entryA=temp.split(",");
				
					
					for(int i=0;i<entryA.length;i=i+3){
						//Toast.makeText(getBaseContext(), entryA[i], Toast.LENGTH_SHORT).show();
						String name=e1.getText().toString();
						String pass=e2.getText().toString();
						if(name.equals(entryA[i].toString())&& pass.equals(entryA[i+1].toString()))
						{
							if(entryA[i+2].equals("0") )
							{
								
							
								
								Intent iv=new Intent(getBaseContext(), VoteHere.class);
								
								Bundle b1=new Bundle();
								b1.putString("1", name);
								b1.putString("2", pass);
								iv.putExtras(b1);
								startActivity(iv);
								break;
								
								
							}
							else{
								Toast.makeText(getBaseContext(), "You have already voted", Toast.LENGTH_SHORT).show();
							e1.setText("");
							e2.setText("");
							break;
							}	
							
							
						}
						else
						{
							if(i==entryA.length-2)
							
							Toast.makeText(getBaseContext(), "You are not valid user", Toast.LENGTH_SHORT).show();
							}
					}
				}
				
				
				catch(Exception e){}
				
				 
				}
				
				
				
				
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(getBaseContext(), Admin.class);
				startActivity(i);
				
			}
		});
		
		
		
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
