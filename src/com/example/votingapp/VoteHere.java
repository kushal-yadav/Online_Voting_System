package com.example.votingapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.EmptyStackException;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.Toast;

public class VoteHere extends Activity {
	TableRow t1,t2,t3;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vote_here);
		t1=(TableRow)findViewById(R.id.t1);
		t2=(TableRow)findViewById(R.id.t2);
		t3=(TableRow)findViewById(R.id.t3);
		b1=(Button)findViewById(R.id.b1);
		
		
		
		
		
		t1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				t3.setBackgroundColor(Color.WHITE);
				t2.setBackgroundColor(Color.WHITE);
				t1.setBackgroundColor(Color.YELLOW);
				
				
				b1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						
						
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
							 entryA=temp.split(",");
							 
							 //abc bundle
							 Bundle b1=new Bundle();
							 b1=getIntent().getExtras();
							String s1= b1.getString("1");
							String s2= b1.getString("2");
							
								 if(s1.equals("abc")&& s2.equals("1234"))
							 
							 {
									 int i=0;
								 
								 FileOutputStream fo=openFileOutput("voter.txt", MODE_PRIVATE);
								 OutputStreamWriter os=new OutputStreamWriter(fo);
								
								 os.write(entryA[i].toString()+","+entryA[i+1].toString()+","+"1"+","+entryA[i+3].toString()+","+entryA[i+4].toString()+","+ entryA[i+5].toString());
								 os.close();
								 
							 }
								 
								 else
									 
									// for(i=i+3;i<entryA.length;i=i+3)
								 {
									 int i=0;
									 FileOutputStream fo=openFileOutput("voter.txt", MODE_PRIVATE);
									 OutputStreamWriter os=new OutputStreamWriter(fo);
									
									 os.write(entryA[i].toString()+","+entryA[i+1].toString()+","+entryA[i+2].toString()+","+entryA[i+3].toString()+","+entryA[i+4].toString()+","+ "1");
									 os.close();
									 
								 }
						}catch(Exception e){}
						
						
						
						
				Toast.makeText(getBaseContext(), "Shivsena is selected", Toast.LENGTH_SHORT).show();
					
					try {
						String[] entryA = null;
						String temp="";
						FileInputStream f=openFileInput("vote.txt");
						InputStreamReader isr=new InputStreamReader(f);
						char[] inputBuffer=new char[40];
						int charRead;
						 while ((charRead = isr.read(inputBuffer))>0) {  
				                String readString=String.copyValueOf(inputBuffer,0,charRead);
				                temp= readString;
				                inputBuffer=new char[40]; 
						 }
						 entryA=temp.split("-");
						String d= entryA[0].toString();
						int x=Integer.parseInt(d);
						
						x=x+1;
						String m=Integer.toString(x);
						
						
						FileOutputStream fo=openFileOutput("vote.txt", MODE_PRIVATE);
						OutputStreamWriter osw=new OutputStreamWriter(fo);
						osw.write(entryA[0]=m+"-");
						osw.write(entryA[1]=entryA[1].toString()+"-");
						osw.write(entryA[2]=entryA[2].toString()+"-");
						
						Toast.makeText(getBaseContext(), m, Toast.LENGTH_SHORT).show();
						osw.close();
						
						
				
						
					
				
					}catch(Exception e){}
					Intent i=new Intent(getBaseContext(), Thankyou.class);
					startActivity(i);
					finish();
					
					}
				});
			}
		});
		
t2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				t3.setBackgroundColor(Color.WHITE);
				t1.setBackgroundColor(Color.WHITE);
				t2.setBackgroundColor(Color.YELLOW);
				
b1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						
						
						
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
							 entryA=temp.split(",");
							 
							 //abc bundle
							 Bundle b1=new Bundle();
							 b1=getIntent().getExtras();
							String s1= b1.getString("1");
							String s2= b1.getString("2");
							
								 if(s1.equals("abc")&& s2.equals("1234"))
							 
							 {
									 int i=0;
								 
								 FileOutputStream fo=openFileOutput("voter.txt", MODE_PRIVATE);
								 OutputStreamWriter os=new OutputStreamWriter(fo);
								
								 os.write(entryA[i].toString()+","+entryA[i+1].toString()+","+"1"+","+entryA[i+3].toString()+","+entryA[i+4].toString()+","+ entryA[i+5].toString());
								 os.close();
								 
							 }
								 
								 else
									 
									// for(i=i+3;i<entryA.length;i=i+3)
								 {
									 int i=0;
									 FileOutputStream fo=openFileOutput("voter.txt", MODE_PRIVATE);
									 OutputStreamWriter os=new OutputStreamWriter(fo);
									
									 os.write(entryA[i].toString()+","+entryA[i+1].toString()+","+entryA[i+2].toString()+","+entryA[i+3].toString()+","+entryA[i+4].toString()+","+ "1");
									 os.close();
									 
								 }
						}catch(Exception e){}
						
						
						
						
						
						
						
						
						
						
						
					Toast.makeText(getBaseContext(), "MNS is selected", Toast.LENGTH_SHORT).show();
					
					try {
						String[] entryA = null;
						String temp="";
						FileInputStream f=openFileInput("vote.txt");
						InputStreamReader isr=new InputStreamReader(f);
						char[] inputBuffer=new char[40];
						int charRead;
						 while ((charRead = isr.read(inputBuffer))>0) {  
				                String readString=String.copyValueOf(inputBuffer,0,charRead);
				                temp= readString;
				                inputBuffer=new char[40]; 
						 }
						 entryA=temp.split("-");
						String d= entryA[1].toString();
						int x=Integer.parseInt(d);
						
						x=x+1;
						String m=Integer.toString(x);
						
						FileOutputStream fo=openFileOutput("vote.txt", MODE_PRIVATE);
						OutputStreamWriter osw=new OutputStreamWriter(fo);
						osw.write(entryA[1]=m+"-");
						osw.write(entryA[0]=entryA[0].toString()+"-");
						osw.write(entryA[2]=entryA[2].toString()+"-");
						
						Toast.makeText(getBaseContext(), m, Toast.LENGTH_SHORT).show();
						osw.close();
						
					
				
					}catch(Exception e){}
					
					Intent i=new Intent(getBaseContext(), Thankyou.class);
					startActivity(i);
					finish();
					
					}
				});
				
			}
		});
t3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		t1.setBackgroundColor(Color.WHITE);
		t2.setBackgroundColor(Color.WHITE);
		t3.setBackgroundColor(Color.YELLOW);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			Toast.makeText(getBaseContext(), "Congress is selected", Toast.LENGTH_SHORT).show();
			
			try {
				String[] entryA = null;
				String temp="";
				FileInputStream f=openFileInput("vote.txt");
				InputStreamReader isr=new InputStreamReader(f);
				char[] inputBuffer=new char[40];
				int charRead;
				 while ((charRead = isr.read(inputBuffer))>0) {  
		                String readString=String.copyValueOf(inputBuffer,0,charRead);
		                temp= readString;
		                inputBuffer=new char[40]; 
				 }
				 entryA=temp.split("-");
				String d= entryA[2].toString();
				int x=Integer.parseInt(d);
				
				x=x+1;
				String m=Integer.toString(x);
				
				FileOutputStream fo=openFileOutput("vote.txt", MODE_PRIVATE);
				OutputStreamWriter osw=new OutputStreamWriter(fo);
				osw.write(entryA[2]=m+"-");
				osw.write(entryA[0]=entryA[0].toString()+"-");
				osw.write(entryA[1]=entryA[1].toString()+"-");
				
				Toast.makeText(getBaseContext(), m, Toast.LENGTH_SHORT).show();
				osw.close();
				
			
		
			}catch(Exception e){}
			
			Intent i=new Intent(getBaseContext(), Thankyou.class);
			startActivity(i);
			finish();
			
			
			
			
			}
		});
		
	}
});
		




	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vote_here, menu);
		return true;
	}

}
