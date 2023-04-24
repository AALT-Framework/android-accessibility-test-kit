# Automated accessibility tests kit for Android apps

This library consists of a collection of automated accessibility tests designed to run with Robolectric. This enables them to be executed as local tests, without the need for a physical or emulated device..

These tests were developed with a focus on the most common accessibility issues and the most frequently used widgets, where many accessibility problems tend to arise. It's important to note that these automated tests do not replace the need for manual checks and verifications.

## Installation

To use AATK in your Android project, follow these steps:

1. Add it in your root build.gradle at the end of repositories.
```groovy
allprojects {
  repositories {
	  ...
	  maven { url 'https://jitpack.io' }
  }
}
```
2. Configure your app-level build.gradle file for Robolectric and AATK testing by updating the testOptions and adding the necessary dependencies. After making these changes, sync your project to ensure they take effect.
```groovy
android{
    ...
    testOptions {
        // Used for Unit testing Android dependent elements in test folder
        unitTests.includeAndroidResources  = true
        unitTests.returnDefaultValues = true
    }
}

dependencies {
    ...
    testImplementation 'org.robolectric:robolectric:4.9'
    testImplementation 'com.github.andersongarcia:android-accessibility-test-kit:v1.0.0'
    ...
}
```
## Usage
Create your own Java Test File class and set up like this:
```java
@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {
    private View rootView;
    private AccessibilityTestRunner runner;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() {
        Activity activity = Robolectric.buildActivity(MyActivity.class).create().get();

        // Get the root node of the view hierarchy
        rootView = activity.getWindow().getDecorView().getRootView();
        runner = new AccessibilityTestRunner(collector);
    }
}
```

Then, write your test. For example, to test contrast ratio:
```java
  @Test
  public void mustUseAdequateContrastRatio(){
    runner.runAccessibilityTest(rootView, new TestAdequateContrastRatio());
  }
```

## Tests available

Currently, this kit performs the following checks:

| Test | Test Class Name | Description |
| ------------- | ------------- | ------------- |
| Color contrast | TestAdequateContrastRatio | A contrast ratio of at least 4.5:1 should be used |
| Focus based navigation support | TestFocusBasedNavigationSuport | The app must support focus-based navigation |
| Spacing | TestInteractionElementSpacing | Interaction components should have a minimum spacing of 8dp |
| Component label | TestMustFormControlHaveLabel | Form controls must have and associated label | 
| Alternative text | TestMustHaveAlternativeText | All non-textual content must have an alternative text description |
| Touch target size | TestTouchTargetSize | All interaction elements should have a minimum of 48x48dp |

