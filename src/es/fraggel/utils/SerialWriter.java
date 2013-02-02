package es.fraggel.utils;
import java.io.IOException;
import java.io.OutputStream;

public class SerialWriter implements Runnable 
    {
        OutputStream out;
        int i=-1;
        public SerialWriter ( OutputStream out,int i )
        {
            this.out = out;
            this.i=i;
        }
        
        public void run ()
        {
            try
            {        
            	int cont=0;
                while ( i > -1 && cont<500 )
                {
                    this.out.write(i);
                    cont++;
                }                
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }            
        }
        public void setI(int i){
        	this.i=i;
        }
    }