package usa.page;

import android.os.Environment;

import java.io.File;

import ckt.tools.Property;

/**
 * Created by elon on 2016/10/28.
 */
public class Constant {
    //sio-eye account
    public static  final  String userName ="tyokyo@126.com";
    public static  final  String passwd   = "123456789";

    //sio-eye error account
    public static  final  String error_userName ="tyokyo@126.com";
    public static  final  String error_passwd   = "0123456789";
    public static String getUserName(){
        String config= Environment.getExternalStorageDirectory()+ File.separator+"config.properties";
        String userName= Property.getValueByKey(config,"user_name");
        return userName;
    }
    public static String getPassword(){
        String config= Environment.getExternalStorageDirectory()+ File.separator+"config.properties";
        String userName=Property.getValueByKey(config,"user_password");
        return userName;
    }
    }
