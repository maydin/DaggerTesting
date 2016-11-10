package test.dagger.com.daggertesting;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by maydin on 09/11/2016.
 */

@Singleton
@Component (modules={UserModule.class})
public interface UserComponent {

    void inject(MainActivity activity);
}
