package pok.test.testsetting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

	Button videoRec;
	Button refreshToken;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		videoRec = findViewById(R.id.button);
		refreshToken = findViewById(R.id.button2);

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
	}
}
