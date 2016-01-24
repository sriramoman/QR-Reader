package com.google.android.gms.samples.vision.barcodereader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;

import org.w3c.dom.Text;

public class DisplayActivity extends AppCompatActivity {
    String billtext2="";
    public DisplayActivity()
    {

    }
    /*public DisplayActivity(String text)
    {
        billtext=text;
        System.out.println("Within Constructor"+billtext);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView text =(TextView)findViewById(R.id.output);
        /*DashBoard db=new DashBoard();
        try
        {
            System.out.println("Calling Dashboard postText");
            //billtext2=db.postText();
        }
        catch(Exception e)
        {
            System.out.println("Exception"+e);
        }*/


       /* Intent in=getIntent();
        Bundle bundle=in.getExtras();
        if(bundle!=null)
        {
            billtext2=(String)bundle.get("billtext");
        }*/

        //billtext=in.getStringExtra("billtext");
        System.out.println("Bill text inside Display Activity" + billtext2);
        //text.setText(billtext2);
        //https://github.com/kenglxn/QRGen



        System.out.println("Checkpoint1");
        //http://www.mkyong.com/android/how-to-send-email-in-android/
        Intent email = new Intent(Intent.ACTION_SEND);
        String to="sriramoman@gmail.com";
        email.setType("application/image");
        System.out.println("Checkpoint2");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
        //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, "Reg-QuickBill");
        email.putExtra(Intent.EXTRA_TEXT, billtext2);
        //Image img=
        //email.putExtra(Intent.EXTRA_STREAM, Uri.parse(R.id.imageQR));
        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
