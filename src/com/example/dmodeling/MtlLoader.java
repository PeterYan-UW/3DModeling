package com.example.dmodeling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

public class MtlLoader {
	private Context context;
	public MtlLoader(Context con){
		super();
		this.context = con;
	}
	public List<Material> loadMtl(String fileName){
		List<Material> Materials = new ArrayList<Material>();
		Material currentMaterial = null;
		InputStream inputStream = this.context.getResources().openRawResource(R.raw.office_mtl);
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			if (inputStream != null){
				String line;
				try {
					while((line = reader.readLine()) != null){
						String[] currentLine = line.split(" ");
						if (currentLine[0].equals("newmtl")){
							if (currentMaterial!=null){
								Materials.add(currentMaterial);
							}
							currentMaterial = new Material(currentLine[1]);
						}
						else if(currentLine.length > 2 && currentLine[2].equals("Ns")){
							currentMaterial.setNs(Float.parseFloat(currentLine[3]));
						}
						else if(currentLine.length > 2 && currentLine[2].equals("Ni")){
							currentMaterial.setNi(Float.parseFloat(currentLine[3]));							
						}
						else if(currentLine.length > 2 && currentLine[2].equals("illum")){
							currentMaterial.setIllum(Integer.parseInt(currentLine[3]));							
						}
						else if(currentLine.length > 2 && currentLine[2].equals("d")){
							currentMaterial.setD(Float.parseFloat(currentLine[3]));							
						}
						else if(currentLine.length > 2 && currentLine[2].equals("Ka")){
//							Log.v("got in ka ", String.valueOf(currentLine[3]));
							currentMaterial.setKa(
									Float.parseFloat(currentLine[3]),
									Float.parseFloat(currentLine[4]),
									Float.parseFloat(currentLine[5]));							
						}
						else if(currentLine.length > 2 && currentLine[2].equals("Kd")){
							currentMaterial.setKd(
									Float.parseFloat(currentLine[3]),
									Float.parseFloat(currentLine[4]),
									Float.parseFloat(currentLine[5]));								
						}
						else if(currentLine.length > 2 && currentLine[2].equals("Ks")){
							currentMaterial.setKs(
									Float.parseFloat(currentLine[3]),
									Float.parseFloat(currentLine[4]),
									Float.parseFloat(currentLine[5]));								
						}
						else if(currentLine.length > 2 && currentLine[2].equals("Ke")){
							currentMaterial.setKe(
									Float.parseFloat(currentLine[3]),
									Float.parseFloat(currentLine[4]),
									Float.parseFloat(currentLine[5]));	
						}
					}
					if (currentMaterial!=null){
						Materials.add(currentMaterial);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally{
					try{
						reader.close();
					}
					catch (IOException e) {// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		finally{
			try {
				inputStream.close();
			}
			catch(Exception e){
				System.err.println("close faile");
			}
		}
		return Materials;
	}
}
