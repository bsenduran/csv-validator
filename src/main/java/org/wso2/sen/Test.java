package org.wso2.sen;

/**
 * Created by senduran on 6/11/15.
 */
public class Test {

    public static void main(String[] args) {
        String str = "name|10|city|country";
        String validRegex = "^([a-z]+)\\|(\\d)+\\|([a-z]+)\\|([a-z]+)$";
        System.out.println(str.matches(validRegex));


    }

}
