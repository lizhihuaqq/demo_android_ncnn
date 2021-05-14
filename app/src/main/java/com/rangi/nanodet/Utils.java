package com.rangi.nanodet;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        String dateString = formatter.format(currentTime);

        return dateString;
    }

    public static File saveBitmap(Bitmap bmp, String picName, Context ctx) {
        String path = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "HDL";
        File file = new File(path, picName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bmp.compress(Bitmap.CompressFormat.JPEG, 80, bos);//向缓冲区压缩图片
            bos.flush();
            bos.close();
        } catch (Exception e) {
            Log.e("lzh", "Exception===" + e.toString());
        }
        return file;
    }
}
