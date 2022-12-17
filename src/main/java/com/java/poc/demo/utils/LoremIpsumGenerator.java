package com.java.poc.demo.utils;

import java.util.Random;

public class LoremIpsumGenerator {

    private static final String loremipsum = "lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Quisque mattis quis libero et accumsan. Vivamus at magna magna. Integer dapibus lorem libero," +
            " eget maximus risus interdum sit amet. Cras sapien diam, vestibulum ut tempus malesuada, facilisis et" +
            " ante. Integer convallis urna nisi, a finibus ante iaculis a. Proin at auctor felis, ut ullamcorper risus." +
            " Donec sodales efficitur egestas. Praesent interdum leo est, eu rutrum risus pretium nec, Maecenas et velit vel eros " +
            "pulvinar luctus eu in elit. Donec pharetra eu justo at tristique. Fusce faucibus ligula erat. " +
            "Vestibulum congue a odio in dictum. Ut a massa a nunc vestibulum feugiat";

    private static final String[] wArr;

    static{
        wArr = loremipsum.split(" ");
    }

    private static String getRandomWord(Random random){
            return wArr[random.nextInt(wArr.length)];
    }

    private static String capFirstLetter(String word){
        return word.substring(0,1).toUpperCase()+word.substring(1);
    }

    public static String getText(int wc){
        StringBuffer response = new StringBuffer();
        Random random = new Random();
        int para = 300;
        int pgBreak = 0;
        for (int i = 0; i < wc; i++) {
            response.append( pgBreak == 0 ? (capFirstLetter(getRandomWord(random))+" "):getRandomWord(random)+" ");
            pgBreak++;
            if(pgBreak >= para){
                response.delete(response.length() - 1 , response.length());
                response.append(".<br/><br/>");
                pgBreak = 0;
            }
        }
        return response.toString();
    }

}
