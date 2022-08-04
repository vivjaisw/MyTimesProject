
package failedtestscreenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.timesproject.testbase.TimeProjectBase;

public class CustomFailedTestScreenShots extends TimeProjectBase {

	public void failed(String filename) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./ScreenShot/" + filename));
			System.out.println("Screenshot Saved Successfully");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
