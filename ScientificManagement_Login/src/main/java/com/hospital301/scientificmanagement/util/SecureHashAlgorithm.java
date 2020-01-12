/**
 * 使用SHA1摘要算法对数据进行加密
 */
package com.hospital301.scientificmanagement.util;

import java.security.MessageDigest;

public class SecureHashAlgorithm {
    public static String shaEncode(String passwd) throws Exception {

        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = passwd.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
   /* public static void main(String args[]) throws Exception {

        String str = new String("amigoxiexiexingxing");

        System.out.println("原始：" + str);

        System.out.println("SHA后：" + shaEncode(str));

    }*/

}
