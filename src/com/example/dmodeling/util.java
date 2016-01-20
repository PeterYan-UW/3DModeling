package com.example.dmodeling;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class util {
	public static FloatBuffer FloatArray2Buff(float[] fArray){
		FloatBuffer fBuff;
		ByteBuffer bBuff = ByteBuffer.allocateDirect(fArray.length*4);
		bBuff.order(ByteOrder.nativeOrder());
		fBuff = bBuff.asFloatBuffer();
		fBuff.put(fArray);
		fBuff.position(0);
		return fBuff;		
	}
	
	public static ShortBuffer ShortArray2Buff(short[] sArray) {
		ShortBuffer sBuff;
		ByteBuffer bBuff = ByteBuffer.allocateDirect(sArray.length*2);
		bBuff.order(ByteOrder.nativeOrder());
		sBuff = bBuff.asShortBuffer();
		sBuff.put(sArray);
		sBuff.position(0);
		return sBuff;
	}
}
