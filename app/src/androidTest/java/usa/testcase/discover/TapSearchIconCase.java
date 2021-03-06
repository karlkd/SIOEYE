package usa.testcase.discover;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.squareup.spoon.Spoon;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.io.IOException;
import ckt.base.VP2;
import usa.action.DiscoverAction;
import usa.page.App;
import usa.page.Discover;


/**
 * Created by admin on 2016/11/02   .
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class TapSearchIconCase extends VP2{
    @Before
    public  void setup(){
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_USA);
    }
    @Test
    //单击search按钮进入搜索
    public void TapSearchIconOnce() throws IOException, UiObjectNotFoundException {
        DiscoverAction.navToSearch();
        waitTime(1);
        if (!getObjectById(Discover.ID_SEARCH_FILTER_INPUT).exists()){
            Spoon.screenshot("tap_search_once_fail","点击一次进入搜索界面");
            Assert.fail("跳转失败");
        }
    }
}
