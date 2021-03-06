package usa.testcase.discover;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.spoon.Spoon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ckt.base.VP2;
import usa.action.Nav;
import usa.page.App;
import usa.page.Discover;

/**
 * Created by admin on 2016/11/10   .
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class SwitchTabCase extends VP2 {
    @Before
    public  void setup(){
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_USA);
    }
    @Test
    //快速切换tab
    public void SwitchTab(){
        Nav.navToDevice();
        waitTime(1);
        Nav.navToBrodcasts();
        waitTime(1);
        Nav.navToMe();
        waitTime(1);
        Nav.navToWatch();
        waitTime(1);
        Nav.navToDevice();
        waitTime(1);
        Nav.navToMe();
        waitTime(1);
        Nav.navToBrodcasts();
        waitTime(1);
        if (!getObjectById(Discover.ID_MAIN_TAB_AD_SPALSH).exists()){
            Spoon.screenshot("switchtabfail","切换tab失败");
            Assert.fail("切换tab失败");
        }
    }
}
