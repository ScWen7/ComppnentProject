package scwen.com.common_base;

import android.content.Context;

import com.alibaba.fastjson.JSON;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static String JsonStr(Context context, String fileName) {
        String str = new String();
        String temp;
        try {
            InputStream fil = context.getAssets().open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fil,
                    "UTF-8"));
            while (br != null && null != (temp = br.readLine())) {
                str += temp;
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> List<T> parseAssetsJson2List(Class<T> clazz, Context context, String fileName) {

        String json = initJsonData(context, fileName);

        try {
            return JSON.parseArray(json, clazz);
        } catch (com.alibaba.fastjson.JSONException e) {
            return new ArrayList<>();
        }

    }


    /**
     * 从assert文件夹中读取省市区的json文件，然后转化为String
     */
    public static String initJsonData(Context context, String fileName) {
        try {

            StringBuffer sb = new StringBuffer();
            InputStream is = context.getAssets().open(fileName);
            BufferedInputStream bis = new BufferedInputStream(is);
            int len = -1;
            byte[] buf = new byte[is.available()];
            while ((len = bis.read(buf)) != -1) {
                sb.append(new String(buf, 0, len, "UTF-8"));
            }
            bis.close();
            is.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
