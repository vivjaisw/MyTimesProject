package com.timeproject.retryLogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryFailedTestCases implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)

	{

		annotation.setRetryAnalyzer(RetryAnalyzer.class);

	}

	public void onFinish(ITestContext context) {

		Iterator<ITestResult> skippedTestCases = context.getSkippedTests().getAllResults().iterator();

		while (skippedTestCases.hasNext()) {
			ITestResult skippedTestCase = skippedTestCases.next();
			ITestNGMethod method = skippedTestCase.getMethod();
			if (context.getSkippedTests().getResults(method).size() > 0) {
				skippedTestCases.remove();
			}
		}
	}

}
