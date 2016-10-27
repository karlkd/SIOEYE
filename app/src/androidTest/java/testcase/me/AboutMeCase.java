package testcase.me;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.squareup.spoon.Spoon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import ckt.base.VP2;
import page.App;
import page.Me;

/**
 * Created by elon on 2016/10/12.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class AboutMeCase extends VP2 {
    @Before
    public  void setup(){
        openAppByPackageName(App.SIOEYE_PACKAGE_NAME_USA);
    }
    public String getAboutMe() throws UiObjectNotFoundException {
        UiObject u =  gDevice.findObject(new UiSelector().resourceId(Me.ABOUT_ME_ID));
        String me = u.getChild(new UiSelector().resourceId(Me.ABOUT_ME_CONTENT_TEXT)).getText();
        return  me;
    }
    @Test
    public void testEdit10C() throws UiObjectNotFoundException {
        //clickByText("Me");
        clickById(Me.ID_MAIN_TAB_ME);
        String user_id = getObjectById(Me.SIOEYE_USER_ID).getText();
        Spoon.screenshot(gDevice,"Me");
        clickById(Me.ID_USER_EDIT);
        clickByText("About Me");
        getObjectById(Me.ABOUT_ME_CONTENT).clearTextField();
        String input = getRandomString(10);
        getObjectById(Me.ABOUT_ME_CONTENT).setText(input);
        clickByText("Done");
        String me = getAboutMe();
        Assert.assertEquals("change success",input,me);
        gDevice.pressBack();
        String expect = getUiObjectById(Me.ABOUT_ME_DISPLAY).getText();
        Assert.assertEquals("change success",expect,input);
        Spoon.screenshot(gDevice,input);
        gDevice.pressBack();
    }
    @Test
    public void testMesSearch() throws UiObjectNotFoundException {
        clickByText("Me");
        String user_id = getObjectById(Me.SIOEYE_USER_ID).getText();
        Spoon.screenshot(gDevice,"Me");
        clickById(Me.ID_USER_EDIT);
        clickByText("About Me");
        getObjectById(Me.ABOUT_ME_CONTENT).clearTextField();
        String input = getRandomString(40);
        getObjectById(Me.ABOUT_ME_CONTENT).setText(input);
        clickByText("Done");
        gDevice.pressBack();
        String expect = getUiObjectById(Me.ABOUT_ME_DISPLAY).getText();
        if (!expect.equals(input)){
            Assert.fail(expect+" not equal "+input);
        }
        Spoon.screenshot(gDevice,input);

        clickByText("Watch");
        clickById(Me.SEARCH_BTN_WATCH);
        getObjectById(Me.SEARCH_BTN_WATCH_FILTER).setText(user_id);

        waitTime(5);
        Assert.assertTrue(input+" save success",getUiObjectByText(input).exists());

    }

    @Test
    public void testEdit60C() throws UiObjectNotFoundException {
        clickByText("Me");
        Spoon.screenshot(gDevice,"Me");
        clickById(Me.ID_USER_EDIT);
        clickByText("About Me");
        getObjectById(Me.ABOUT_ME_CONTENT).clearTextField();
        String input = getRandomString(60);
        getObjectById(Me.ABOUT_ME_CONTENT).setText(input);
        clickByText("Done");
        gDevice.pressBack();
        String expect = getUiObjectById(Me.ABOUT_ME_DISPLAY).getText();
        if (!expect.equals(input)){
            Assert.fail(expect+" not equal "+input);
        }
        Spoon.screenshot(gDevice,input);

    }
    @Test
    public void testEdit61C() throws UiObjectNotFoundException {
        clickByText("Me");
        Spoon.screenshot(gDevice,"Me");
        clickById(Me.ID_USER_EDIT);
        clickByText("About Me");
        getObjectById(Me.ABOUT_ME_CONTENT).clearTextField();
        String input = getRandomString(100);
        try {
            gDevice.executeShellCommand("input text "+input);
        } catch (IOException e) {
            e.printStackTrace();


        }
        clickByText("Done");
        gDevice.pressBack();
        String expect = getUiObjectById(Me.ABOUT_ME_DISPLAY).getText();
        input = input.substring(0,60);
        if (!expect.equals(input)){
            Assert.fail(expect+" not equal "+input);
        }
        Spoon.screenshot(gDevice,input);
    }
    @Test
    public void testNotSave() throws UiObjectNotFoundException {
        clickByText("Me");
        Spoon.screenshot(gDevice,"Me");
        String expect = getUiObjectById(Me.ABOUT_ME_DISPLAY).getText();
        clickById(Me.ID_USER_EDIT);
        clickByText("About Me");
        getObjectById(Me.ABOUT_ME_CONTENT).clearTextField();
        String input = getRandomString(50);
        getObjectById(Me.ABOUT_ME_CONTENT).setText(input);
        gDevice.pressBack();
        gDevice.pressBack();
        String  active= getUiObjectById(Me.ABOUT_ME_DISPLAY).getText();
        if (!expect.equals(active)){
            Assert.fail(expect+" not equal "+input);
        }
        Spoon.screenshot(gDevice,input);
    }
    @Test
    public void testDeleteToNull() throws UiObjectNotFoundException {
        clickByText("Me");
        Spoon.screenshot(gDevice,"Me");
        clickById(Me.ID_USER_EDIT);
        clickByText("About Me");
        getObjectById(Me.ABOUT_ME_CONTENT).clearTextField();
        clickByText("Done");
        gDevice.pressBack();
        String expect = getUiObjectById(Me.ABOUT_ME_DISPLAY).getText();
        if (!expect.equals("")){
            Assert.fail(expect+" not equal null ");
        }
        Spoon.screenshot(gDevice,"delete_all");
    }
}
