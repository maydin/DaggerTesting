package test.dagger.com.daggertesting;

/**
 * Created by maydin on 09/11/2016.
 */

public class UserServiceImpl implements UserService {

    public String login(){
        return "Logged in";
    }

    public String logout(){
        return "Logged out";
    }
}
