import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GetOTP extends Base{
	public String getOTP() throws MalformedURLException{
		AndroidDriver<AndroidElement> driver = Capabilities();
		//Open app message
//		driver.startActivity("com.google.android.apps.messaging","com.google.android.apps.messaging.ui.ConversationListActivity");
		//Get nilai OTP
		String valOTP = driver.findElementById("com.google.android.apps.messaging:id/coversation_snippet").getText().split(" ")[6].trim();
		return valOTP;
	}
	
			
}
