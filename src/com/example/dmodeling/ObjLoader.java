package com.example.dmodeling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class ObjLoader{
	private Context context;
	public ObjLoader(Context con){
		super();
		this.context = con;
	}
	
	public Object[] loadObjModel(String fileName){
		List<Part> parts = new ArrayList<Part>();
		Part currentPart = null;
		float[] verticesArray = null;
		float[] normalsArray = null;
		float[] texturesArray = null;
		short[] indiceArray = null;
		short[] totalIndiceArray = null;
		List<Material> Materials = null;
		
		InputStream inputStream = this.context.getResources().openRawResource(R.raw.office);
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			if (inputStream != null){
				
				String line;
				List<Float> vertices = new ArrayList<Float>();
				List<Float> normals = new ArrayList<Float>();
				List<Float> textures = new ArrayList<Float>();
				List<Short> indecesArry = new ArrayList<Short>();
				List<Short> totalIndecesArry = new ArrayList<Short>();
				try {
					while((line = reader.readLine()) != null){
						String[] currentLine = line.split(" ");
						if (currentLine[0].equals("mtllib")){
							MtlLoader mtl = new MtlLoader(context);
							Materials = mtl.loadMtl(currentLine[1]);
//							Log.v("materials", Materials.get(1).toString());
						}
						else if (currentLine[0].equals("v")){
							float x = Float.parseFloat(currentLine[1]);
							float y = Float.parseFloat(currentLine[2]);
							float z = Float.parseFloat(currentLine[3]);							
							vertices.add(x);
							vertices.add(y);
							vertices.add(z);
						}
						else if (currentLine[0].equals("vt")){
							float x = Float.parseFloat(currentLine[1]);
							float y = Float.parseFloat(currentLine[2]);
							textures.add(x);
							textures.add(y);							
						}
						else if (currentLine[0].equals("vn")){
							float x = Float.parseFloat(currentLine[1]);
							float y = Float.parseFloat(currentLine[2]);
							float z = Float.parseFloat(currentLine[3]);
							normals.add(x);
							normals.add(y);
							normals.add(z);			
						}
						else if (currentLine[0].equals("f")){
							short p1 = Short.parseShort(currentLine[1].split("/")[0]);
							short p2 = Short.parseShort(currentLine[2].split("/")[0]);
							short p3 = Short.parseShort(currentLine[3].split("/")[0]);
							indecesArry.add((short) (p1-1));
							indecesArry.add((short) (p2-1));
							indecesArry.add((short) (p3-1));
							totalIndecesArry.add((short) (p1-1));
							totalIndecesArry.add((short) (p2-1));
							totalIndecesArry.add((short) (p3-1));
							
						}
					}
				} 
				catch (IOException e) {// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					try{
						reader.close();
					}
					catch (IOException e) {// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				verticesArray = FloatList2Array(vertices);
				normalsArray = FloatList2Array(normals);
				texturesArray = FloatList2Array(textures);
				indiceArray = shortList2Array(indecesArry);
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
		
		return new Object[]{verticesArray, normalsArray, texturesArray, indiceArray};
	}

	private short[] shortList2Array(List<Short> l) {
		short[] shortArray = new short[l.size()];
		int i = 0;
		for (Short f : l) {
			shortArray[i++] = (f != null ? f : 0);
		}
		return shortArray;
	}
	
	private float[] FloatList2Array(List<Float> l) {
		float[] floatArray = new float[l.size()];
		int i = 0;
		for (Float f : l) {
		    floatArray[i++] = (f != null ? f : Float.NaN);
		}
		return floatArray;
	}
}
