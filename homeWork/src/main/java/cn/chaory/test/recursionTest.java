package cn.chaory.test;

/**
 * 递归测试
 *
 *     输入一个字符串(无相同字符)，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符
 * 串abc、acb、bac、bca、cab和cba。（使用递归）
 */
public class recursionTest {

    public static void main(String[] args) {
        String str = "abc";
        recursion(str.toCharArray(),0);
    }


    private static void recursion(char[] chararr, int i) {
    try {
        if (i >= chararr.length) {
           return;
        }

        if (i == chararr.length - 1) {
            System.out.println(String.valueOf(chararr));
        } else {
            for (int j = i; j < chararr.length; j++) {
                char temp = chararr[j];
                chararr[j] = chararr[i];
                chararr[i] = temp;

                recursion(chararr, i + 1);

                temp = chararr[j];
                chararr[j] = chararr[i];
                chararr[i] = temp;
            }

        }
    }catch (ArrayIndexOutOfBoundsException e){
        System.err.println("数组越界异常");
    }

    }
}
