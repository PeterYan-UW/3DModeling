package com.example.dmodeling;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import android.util.Log;

public class Part {
	
	private String name;
	private float[] normalsArray = null;
	private FloatBuffer normalsBuff;
	private float[] texturesArray = null;
	private FloatBuffer texturesBuff;
	private short[] indiceArray = null;
	private ShortBuffer indiceBuff;
	private Material mtl = null;
	
	public Part(String name){
		super();
		this.name = name;
	}
	
	public void setNormalsArray(float[] normalsArray){
		this.normalsArray = normalsArray;
		this.normalsBuff = util.FloatArray2Buff(normalsArray);
	}
	public float[] getNormalsArray(){
		return normalsArray;
	}
	public FloatBuffer getNormalsBuff(){
		return normalsBuff;
	}
	
	public void setTexturesArray(float[] texturesArray){
		this.texturesArray = texturesArray;
		this.texturesBuff = util.FloatArray2Buff(texturesArray);
	}
	public float[] getTexturesArray(){
		return texturesArray;
	}
	public FloatBuffer getTexturesBuff(){
		return 	texturesBuff;
	}
	
	public void SetIndiceArray(short[] indiceArray){
		this.indiceArray = indiceArray;
		this.indiceBuff = util.ShortArray2Buff(indiceArray);
	}
	public short[] getIndiceArray(){
		return indiceArray;
	}
	public ShortBuffer getIndiceBuff(){
		return indiceBuff;
	}

	public void setMtl(Material mtl){
		this.mtl = mtl;
	}
	public Material getMtl(){
		return mtl;
	}
}
