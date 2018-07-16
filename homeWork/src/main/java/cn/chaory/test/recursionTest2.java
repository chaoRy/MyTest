package cn.chaory.test;

import java.util.*;


/**
 * 递归测试
 *
 *     输入一个字符串(无相同字符)，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符
 * 串abc、acb、bac、bca、cab和cba。（使用递归）+
 */
public class recursionTest2 {

    public static void main(String[] args) {
        String str = "abc";
        char[] strs = str.toCharArray();
        List<char[]> ret = permutation(strs);
        for (char[] item : ret) {
            for (int i = 0; i < item.length; i++)
                System.out.println(item[i]);
            System.out.println();
        }

    }

    public static List<char[]> permutation(char[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        List<char[]> ret = new LinkedList<char[]>();
        permutationCore(strs, ret, 0);
        return ret;
    }
    //下标为bound的字符依次与[bound,length)的字符交换，如果相同不交换，直到最后一个元素为止。
    //如a,b,c
    //0与0交换,得a,b,c => 1与1交换,得a,b,c =>2与2交换,得a,b,c(存入)
    //                => 1与2交换，得a,c,b =>2与2交换,得a,c.b(存入)
    //0与1交换,得b,a,c => 1与1交换,得b,a,c =>2与2交换,得b,a,c(存入)
    //                => 1与2交换，得b,c,a =>2与2交换,得b,c,a(存入)
    //0与2交换,得c,b,a => 1与1交换,得c,b,a =>2与2交换,得c,b,a(存入)
    //                => 1与2交换，得c,a,b =>2与2交换,得c,a.b(存入)

    //如a,a,b
    //0与0交换,得a,a,b => 1与1交换,得a,a,b =>2与2交换,得a,a,b(存入)
    //                => 1与2交换，得a,b,a =>2与2交换,得a,b,a(存入)
    //0与1相同,跳过
    //0与2交换,得b,a,a =>2与2交换，得b,a,a(存入)
    public static void permutationCore(char[] strs, List<char[]> ret, int bound) {
        if (bound == strs.length)
            ret.add(Arrays.copyOf(strs, strs.length));
        Set<Character> set = new HashSet<Character>();
        for (int i = bound; i < strs.length; i++) {
            if (set.add(strs[i])) {
                swap(strs, bound, i);
                permutationCore(strs, ret, bound + 1);
                swap(strs, bound, i);
            }
        }
    }

    /**
     * 置换
     * @param strs
     * @param x
     * @param y
     */
    public static void swap(char[] strs, int x, int y) {
        char temp = strs[x];
        strs[x] = strs[y];
        strs[y] = temp;
    }




}
