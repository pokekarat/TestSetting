package pok.test.testsetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

	Button videoRec;
	Button refreshToken;
	Button staticIP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		videoRec = findViewById(R.id.button);
		refreshToken = findViewById(R.id.button2);
		staticIP = findViewById(R.id.button3);

		videoRec.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				try {
					File myFile = new File("/sdcard/Kiosk/video_record.txt");
					myFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(myFile);
					OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

					myOutWriter.append("6");
					myOutWriter.append("\n");

					myOutWriter.close();
					fOut.close();
				}catch (Exception e){
					String err = e.toString();
				}
			}
		});

		refreshToken.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					File myFile = new File("/sdcard/Kiosk/refresh_token");
					myFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(myFile);
					OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

					myOutWriter.append("6");
					myOutWriter.append("\n");

					myOutWriter.close();
					fOut.close();
				}catch (Exception e){
					String err = e.toString();
				}
			}
		});

		staticIP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					File myFile = new File("/sdcard/Kiosk/setting.txt");
					myFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(myFile);
					OutputStreamWriter myOutWriter =
						  new OutputStreamWriter(fOut);

					String dhcp_mode = "manual";
					String ip = String.valueOf(((EditText) findViewById(R.id.editText2)).getText());
					String subnet = String.valueOf(((EditText) findViewById(R.id.editText3)).getText());
					String gateway = String.valueOf(((EditText) findViewById(R.id.editText4)).getText());
					String dns1 = String.valueOf(((EditText) findViewById(R.id.editText5)).getText());
					String dns2 = String.valueOf(((EditText) findViewById(R.id.editText6)).getText());

					myOutWriter.append("dhcp=" + dhcp_mode);
					myOutWriter.append("\n");
					myOutWriter.append("ip=" + ip);
					myOutWriter.append("\n");
					myOutWriter.append("subnet=" + subnet);
					myOutWriter.append("\n");
					myOutWriter.append("gateway=" + gateway);
					myOutWriter.append("\n");
					myOutWriter.append("dns1=" + dns1);
					myOutWriter.append("\n");
					myOutWriter.append("dns2=" + dns2);
					myOutWriter.append("\n");

					myOutWriter.close();
					fOut.close();


				} catch (Exception e) {
					Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
