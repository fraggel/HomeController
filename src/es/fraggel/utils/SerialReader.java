package es.fraggel.utils;
import java.io.IOException;
import java.io.InputStream;

public class SerialReader implements Runnable 
    {
        InputStream in;
        String status="0";
        public SerialReader ( InputStream in)
        {
            this.in = in;
            
        }
        
        public void run ()
        {
            byte[] buffer = new byte[1024];
            int len = -1;
            try
            {
                while ( ( len = this.in.read(buffer)) > -1 )
                {
                    status=new String(buffer,0,len);
                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }            
        }
        public String getStatus(){
        	return status;
        }
    }