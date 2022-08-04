package failedtestscreenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;
public class ITestListenerClass extends CustomFailedTestScreenShots implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		failed(result.getName()+".jpg");
	}
}
