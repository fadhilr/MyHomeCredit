import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TC001 extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = Capabilities();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction touch = new TouchAction(driver);
		for (int i = 0; i < 3; i++) {
			WebElement Panel = driver.findElementByClassName("android.view.ViewGroup");
			Dimension dimension = Panel.getSize();

			int Anchor = Panel.getSize().getHeight() / 2;

			Double ScreenWidthStart = dimension.getWidth() * 0.8;
			int tapStart = ScreenWidthStart.intValue();

			Double ScreenWidthEnd = dimension.getWidth() * 0.01;
			int tapEnd = ScreenWidthEnd.intValue();
			// Swipe left
			touch.press(PointOption.point(tapStart, Anchor)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(tapEnd, Anchor)).release().perform();
		}

		driver.findElementByXPath("//android.widget.TextView[@text='DAFTAR']").click();

		//Scroll sampai paling bawah
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Hubungi Kami\"));");

		driver.findElementByXPath("//android.widget.TextView[@text='Setuju & Lanjutkan']").click();
		//choose date
		driver.findElementByXPath("//android.widget.Spinner[@resource-id='dateOfBirth']").click();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='23']").click();
		//choose month
		driver.findElementByXPath("//android.widget.Spinner[@resource-id='monthOfBirth']").click();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Juli']").click();
		//choose year
		driver.findElementByXPath("//android.widget.Spinner[@resource-id='yearOfBirth']").click();
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='2015']").click();
		//fill phone number
		driver.findElementByXPath("//android.widget.EditText[@resource-id='phoneInput']").sendKeys("81233785197");
		//fill pin
		driver.findElementByXPath("//android.widget.EditText[@resource-id='kodePin']").sendKeys("040797");
		driver.findElementByXPath("//android.widget.EditText[@resource-id='kodePinConfirm']").sendKeys("040797");
		//klik lanjutkan
		driver.findElementByXPath("//android.widget.Button[@resource-id='registerButton']").click();
		driver.findElementByXPath("//android.widget.Button[@resource-id='agreePopUp']").click();
		
		//Get nilai OTP dari kelas GetOTP
//		GetOTP otp = new GetOTP();
//		String valueOTP = otp.getOTP();
//		char[] x = valueOTP.toCharArray();
//		//Fill 6 digit OTP dengan nilai valueOTP
//		for (int i = 1; i <= x.length; i++) {
//			driver.findElementById("otp-"+i).sendKeys(String.valueOf(x[i]));
//		}
//		//Klik daftar
//		driver.findElementByXPath("//android.widget.Button[@text='Daftar']").click();
		
		
	}

}
