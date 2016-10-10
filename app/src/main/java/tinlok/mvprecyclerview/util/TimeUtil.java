package tinlok.mvprecyclerview.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Young on 2016/10/1.
 */
public class TimeUtil {

    public static String getTime(String time){
        Date nowDate = Calendar.getInstance().getTime();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
        try {
            Date date=sdf.parse("2016-9-25 20:30:00");

            long timeLong = nowDate.getTime() - date.getTime();
            System.out.println("时间是"+timeLong);
            if (timeLong<60*1000)
                return timeLong/1000 + "秒前";
            else if (timeLong<60*60*1000){
                timeLong = timeLong/1000 /60;
                return timeLong + "分钟前";
            }
            else if (timeLong<60*60*24*1000){
                timeLong = timeLong/60/60/1000;
                return timeLong+"小时前";
            }
            else if (timeLong<60*60*24*1000*7){
                timeLong = timeLong/1000/ 60 / 60 / 24;
                return timeLong + "天前";
            }
            else if (timeLong<60l*60*24*1000*7*54){
                timeLong = timeLong/1000/ 60 / 60 / 24/7;
                return timeLong + "周前";
            }
            else {
                System.out.println("time="+timeLong+">thetime="+60*60*24*1000*7*2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                return "一年之前";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return null;
    }

    public static String[] getDate(String t){

        String s[] = t.split(" ");
        String date[] = s[0].split("-");
        String time[] = s[1].split(":");

        s[0] = date[0]+"年"+date[1]+"月"+date[2]+"日";
        s[1] = time[0]+":"+time[1];
        return s;
    }
}
