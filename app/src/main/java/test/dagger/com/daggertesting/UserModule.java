package test.dagger.com.daggertesting;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by maydin on 09/11/2016.
 */
@Module
public class UserModule {

    @Provides
    @Singleton
    UserService providesUserService() {
        return new UserServiceImpl();
    }
}
