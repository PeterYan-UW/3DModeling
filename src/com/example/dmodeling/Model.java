package com.example.dmodeling;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLES30;

public class Model {
	
	private float vertices[];
	private float norms[];
	private float texCoords[];
	private short indeces[];
	
	private FloatBuffer vertBuff;
	private FloatBuffer normBuff;
	private FloatBuffer texBuff;
	private ShortBuffer pBuff;
	
    private int mVertexBufferObjectId; 
    private int mElementBufferObjectId; 
    List<Integer> elementIds = new ArrayList<Integer>();
    
	public Model(Context con){
		ObjLoader obj = new ObjLoader(con);
		Object[] data = obj.loadObjModel("office");
		
		vertices = (float[]) data[0];
		norms = (float[]) data[1];
		texCoords = (float[]) data[2];
		indeces = (short[]) data[3];
		vertBuff = util.FloatArray2Buff(vertices);
		normBuff = util.FloatArray2Buff(norms);
		texBuff = util.FloatArray2Buff(texCoords);
		pBuff = util.ShortArray2Buff(indeces);
	}

	public void draw(GL10 gl){		
		gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_TEXTURE_2D);

		gl.glEnable(GL10.GL_LIGHTING);
		float lightpos[] = {30, 10, 20, 0};
		float light_ambient[] = {0, 0, 0, 1};
		gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightpos, 0);
		gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, light_ambient, 0);
		gl.glEnable(GL10.GL_LIGHT0);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertBuff);
		
		gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
		gl.glNormalPointer(GL10.GL_FLOAT, 0, normBuff);
			
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);   
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texBuff); 

        float Ka[] = {1,1,1,0};
        float Ks[] = {0,0,0,0};
        float Kd[] = {1,1,1,0};
        
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, Ka, 0);
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Ks, 0);
		gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, Kd, 0);	
		gl.glDrawElements(GL10.GL_TRIANGLES, indeces.length, GL10.GL_UNSIGNED_SHORT, pBuff);


		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisable(GL10.GL_TEXTURE_2D);
		gl.glDisable(GL10.GL_LIGHTING);
		gl.glDisable(GL10.GL_LIGHT0);
	}
}
