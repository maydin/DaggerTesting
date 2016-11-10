package test.dagger.com.daggertesting;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class UserServiceTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected void beforeActivityLaunched() {

            App application = (App) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
            TestUserComponent component = DaggerUserServiceTest_TestUserComponent.builder()
                    .testUserModule(new TestUserModule())
                    .build();

            application.setUserComponent(component);
        }
    };

    @Singleton
    @Component(modules = {TestUserModule.class})
    interface TestUserComponent extends UserComponent {

    }

    @Module
    static class TestUserModule {

        @Provides
        @Singleton
        UserService providesUserModule() {
            return new TestUserService();
        }
    }

    static class TestUserService implements UserService{

        @Override
        public String login() {
            return "Test Logged in";
        }

        @Override
        public String logout() {
            return "Test Logged out";
        }
    }

    @Test
    public void userLoginLogoutTest(){
        onView(withId(R.id.login_button)).perform(click());
        onView(withText("Test Logged in")).check(matches(isDisplayed()));

        onView(withId(R.id.logout_button)).perform(click());
        onView(withText("Test Logged out")).check(matches(isDisplayed()));
    }
}
