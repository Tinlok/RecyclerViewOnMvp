package tinlok.mvprecyclerview.util;

/**
 * 字符串工具类
 * Created by Young on 2016/9/16.
 */
public class StringUtil {
    private static String  result;

    /**
     * 裁剪文本长度
     * @param contents 字符串
     * @param length 裁剪的长度
     * @return
     */
    public static String cutContents(String contents,int length){
        if(contents.length() >= length){
            result = contents.substring(0,length)+"...";

        }else{
            result = contents;
        }
        return result;
    }

    public static  String phoneUtil(String phoneNum){
        return phoneNum.substring(0,3)+"****"+phoneNum.substring(7,11);
    }

    public static  String invitationIdUtil(String title){
        String result = null;
        switch (title){
            case "我发起的":
                result = null;
                break;
            case  "运动" :
                result =  "1";
                break;
            case  "网游" :
                result =  "2";
                break;
            case  "桌游" :
                result =  "3";
                break;
            case  "学习" :
                result =  "4";
                break;
            case  "聚会" :
                result =  "5";
                break;
            case  "其他" :
                result =  "6";
                break;
            case  "篮球" :
                result =  "7";
                break;
            case  "排球" :
                result =  "8";
                break;
            case  "桌球" :
                result =  "9";
                break;
            case  "足球" :
                result =  "10";
                break;
            case  "乒乓球" :
                result =  "11";
                break;
            case  "羽毛球" :
                result =  "12";
                break;
            case  "网球" :
                result =  "13";
                break;
            case  "跑步" :
                result =  "14";
                break;
            case  "健身" :
                result =  "15";
                break;
            case  "游泳" :
                result =  "16";
                break;
            case  "户外" :
                result =  "17";
                break;
            case  "溜冰" :
                result =  "18";
                break;
            case  "其他运动" :
                result =  "19";
                break;
            case  "英雄联盟" :
                result =  "20";
                break;
            case  "守望先锋" :
                result =  "21";
                break;
            case  "三国杀Online" :
                result =  "22";
                break;
            case  "Dota2" :
                result =  "23";
                break;
            case  "王者荣耀" :
                result =  "24";
                break;
            case  "CF" :
                result =  "25";
                break;
            case  "斗地主" :
                result =  "26";
                break;
            case  "DNF" :
                result =  "27";
                break;
            case  "其他网游" :
                result =  "28";
                break;
            case  "象棋" :
                result =  "29";
                break;
            case  "围棋" :
                result =  "30";
                break;
            case  "五子棋" :
                result =  "31";
                break;
            case  "德州扑克" :
                result =  "33";
                break;
            case  "21点" :
                result =  "34";
                break;
            case  "三国杀" :
                result =  "35";
                break;
            case  "狼人杀" :
                result =  "36";
                break;
            case  "UNO" :
                result =  "37";
                break;
            case  "其他线下游戏" :
                result =  "38";
                break;
            case  "自习" :
                result =  "39";
                break;
            case  "英语口语" :
                result =  "40";
                break;
            case  "英语四六级" :
                result =  "41";
                break;
            case  "晨读" :
                result =  "42";
                break;
            case  "看书" :
                result =  "43";
                break;
            case  "考研" :
                result =  "44";
                break;
            case  "BEC" :
                result =  "45";
                break;
            case  "其他学习" :
                result =  "46";
                break;
            case  "电影" :
                result =  "47";
                break;
            case  "吃饭" :
                result =  "48";
                break;
            case  "唱K" :
                result =  "49";
                break;
            case  "露营" :
                result =  "50";
                break;
            case  "散步" :
                result =  "51";
                break;
            case  "演唱会" :
                result =  "52";
                break;
            case  "其他约会" :
                result =  "53";
                break;

        }
        return result;
    }
    public  static int getIndex(int typeId){
        int result;
        if(typeId>=7&&typeId<=19)
            result = typeId - 7;
        else if(typeId>=20&&typeId<=28)
            result = typeId - 20;
        else if(typeId>=29&&typeId<=38)
            result = typeId - 29;
        else if(typeId>=39&&typeId<=46)
            result = typeId - 39;
        else if(typeId>=47&&typeId<=53)
            result = typeId - 47;
        else
            result = 0 ;
        System.out.println("result="+result);
        return result;
    }
}
