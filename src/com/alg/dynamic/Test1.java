package com.alg.dynamic;

import java.util.Objects;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Test1 {

    public static void main(String[] args) {

        String s = "zudfweormatjycujjirzjpyrmaxurectxrtqedmmgergwdvjmjtstdhcihacqnothgttgqfywcpgnuvwglvfiuxteopoyizgehkwuvvkqxbnufkcbodlhdmbqyghkojrgokpwdhtdrwmvdegwycecrgjvuexlguayzcammupgeskrvpthrmwqaqsdcgycdupykppiyhwzwcplivjnnvwhqkkxildtyjltklcokcrgqnnwzzeuqioyahqpuskkpbxhvzvqyhlegmoviogzwuiqahiouhnecjwysmtarjjdjqdrkljawzasriouuiqkcwwqsxifbndjmyprdozhwaoibpqrthpcjphgsfbeqrqqoqiqqdicvybzxhklehzzapbvcyleljawowluqgxxwlrymzojshlwkmzwpixgfjljkmwdtjeabgyrpbqyyykmoaqdambpkyyvukalbrzoyoufjqeftniddsfqnilxlplselqatdgjziphvrbokofvuerpsvqmzakbyzxtxvyanvjpfyvyiivqusfrsufjanmfibgrkwtiuoykiavpbqeyfsuteuxxjiyxvlvgmehycdvxdorpepmsinvmyzeqeiikajopqedyopirmhymozernxzaueljjrhcsofwyddkpnvcvzixdjknikyhzmstvbducjcoyoeoaqruuewclzqqqxzpgykrkygxnmlsrjudoaejxkipkgmcoqtxhelvsizgdwdyjwuumazxfstoaxeqqxoqezakdqjwpkrbldpcbbxexquqrznavcrprnydufsidakvrpuzgfisdxreldbqfizngtrilnbqboxwmwienlkmmiuifrvytukcqcpeqdwwucymgvyrektsnfijdcdoawbcwkkjkqwzffnuqituihjaklvthulmcjrhqcyzvekzqlxgddjoir";
        System.out.println(longestPalindrome(s));
    }


    /**
     * 按照动态规划，找出每一个回文串，记录其中最大的回文串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        if (Objects.equals(s.length() ,1)) {
            return s;
        }
        char[] array = s.toCharArray();
        int begin = 0;
        int end = 0;
        int length = 0;
        for (int i=0;i<array.length;i++) {
            for (int j=i;j<array.length;j++) {
                String str = s.substring(i, j + 1);
                int strLength = str.length();
                if (str.length() == 1) {
                    if (str.length() > length) {
                        begin = i;
                        end = j;
                        length = strLength;
                    }
                    continue;
                }
                int num = strLength % 2;
                int middle = strLength / 2;
                if (num == 0) {
                    //反转中间之后的字符串
                    String revert = revertString(str.substring(middle ,strLength));
                    if (Objects.equals(str.substring(0 ,middle) ,revert)) {
                        if (strLength > length) {
                            begin = i;
                            end = j;
                            length = strLength;
                        }
                    }
                }else {
                    String revert = revertString(str.substring(middle + 1 ,strLength));
                    if (Objects.equals(str.substring(0 ,middle) ,revert)) {
                        if (strLength > length) {
                            begin = i;
                            end = j;
                            length = strLength;
                        }
                    }
                }

            }

        }
        return s.substring(begin ,end + 1);

    }

    private static String revertString(String s){
        if (s == null || s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        char[] sChar = s.toCharArray();
        int length = sChar.length;
        char[] revert = new char[length];
        for (int i =  length - 1 ;i >= 0 ; i--) {
            revert[length - 1 - i] = sChar[i];
        }
        return new String(revert);

    }

}
