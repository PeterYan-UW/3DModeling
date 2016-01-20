package com.example.dmodeling;

import java.nio.FloatBuffer;
import java.util.Arrays;

public class Material {
	private String name;
	private float Ns;
	private float Ni;
	private int illum;
	private float d;
	private float[] Ka;
	private float[] Kd;
	private float[] Ks;
	private float[] Ke;
	private FloatBuffer KaBuff;
	private FloatBuffer KdBuff;
	private FloatBuffer KsBuff;
	private FloatBuffer KeBuff;
	
	public Material (String name){
		this.name = name;
	}
	public String getName (){
		return name;
	}
	
	public void setNs(float Ns){
		this.Ns = Ns;
	}
	public float getNs(){
		return Ns;
	}
	
	public void setNi(float Ni){
		this.Ni = Ni;
	}
	public float getNi(){
		return Ni;
	}
	
	public void setIllum(int illum){
		this.illum = illum;
	}
	public float getIllum(){
		return illum;
	}
	
	public void setD(float d){
		this.d = d;
	}
	public float getD(){
		return d;
	}
	
	public void setKa(float r, float g, float b){
		Ka = new float[3];
		Ka[0] = r;
		Ka[1] = g;
		Ka[2] = b;
		KaBuff = util.FloatArray2Buff(Ka);
	}
	public float[] getKa(){
		return Ka;
	}
	public FloatBuffer getKaBuff(){
		return KaBuff;
	}
	
	public void setKd(float r, float g, float b){
		Kd = new float[3];
		Kd[0] = r;
		Kd[1] = g;
		Kd[2] = b;
		KdBuff = util.FloatArray2Buff(Kd);
	}
	public float[] getKd(){
		return Kd;
	}
	public FloatBuffer getKdBuff(){
		return KdBuff;
	}
	
	public void setKs(float r, float g, float b){
		Ks = new float[3];
		Ks[0] = r;
		Ks[1] = g;
		Ks[2] = b;
		KsBuff = util.FloatArray2Buff(Ks);
	}
	public float[] getKs(){
		return Ks;
	}
	public FloatBuffer getKsBuff(){
		return KsBuff;
	}

	public void setKe(float r, float g, float b){
		Ke = new float[3];
		Ke[0] = r;
		Ke[1] = g;
		Ke[2] = b;
		KeBuff = util.FloatArray2Buff(Ke);
	}
	public float[] getKe(){
		return Ke;
	}
	public FloatBuffer getKeBuff(){
		return KeBuff;
	}
	
	public String toString(){
		String str = new String();
		str+="name: "+name;
		str+="  Ns: "+String.valueOf(Ns);
		str+="  Ni: "+String.valueOf(Ni);
		str+="  illum: "+String.valueOf(illum);
		str+="  d: "+String.valueOf(d);
		if (Ka!=null && Kd!=null && Ks!=null && Ke!=null){
			str+="  Ka: "+Arrays.toString(Ka);
			str+="  Kd: "+Arrays.toString(Kd);
			str+="  Ks: "+Arrays.toString(Ks);
			str+="  Ke: "+Arrays.toString(Ke);			
		}
		else{
			str+="/nsth error";
		}
		return str;
	}
}
