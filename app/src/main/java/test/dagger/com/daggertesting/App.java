package test.dagger.com.daggertesting;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

/**
 * Created by maydin on 09/11/2016.
 */

public class App extends Application {

    UserComponent userComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        userComponent = DaggerUserComponent.builder().userModule(new UserModule()).build();
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

    @VisibleForTesting
    public void setUserComponent(UserComponent userComponent) {
        this.userComponent = userComponent;
    }
}
