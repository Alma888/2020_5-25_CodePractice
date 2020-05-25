//题目：神奇的口袋
//
//有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。John现在
//有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的
//物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。现在的问题是，John有多少种不
//同的选择物品的方式。
//输入描述：
//输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正
//整数，分别给出a1，a2……an的值。
//输出描述：
//输出不同的选择物品的方式的数目。
//示例1:
//输入  3
//     20
//     20
//     20
//输出 3

//【题目解析】： 大家以后看到这种一堆文字的题目一定不要害怕，多读几遍题大家就会发现，其实这道题就
//是一个高中就学过的排列组合问题，这类问题使用递归就可以解决。
//【解题思路】： 采用递归思想： ①物品n个，物品体积逐一放入weight[]中 ②递归函数count(int s,int n) : 其
//中s为剩余物品重量，n为剩余可选的物品个数
//则分以下两步递归求解：
//a.从后往前装，装上weight[n]后，若剩余物品仍然有解
//则count(s-weight[n],n-1);
//b.若装了weight[n]后，无解，则删除该包,尝试第n-1个
//count(s,n-1);
import java.util.Scanner;

public class Main {
    static int[] weight;  //想要的n个物品的体积
    static int N;         //想要N个物品
    static int count=0;   //记录不同选择物品的方式
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            N=sc.nextInt();
            weight=new int[N];
            for(int i=0;i<N;i++){
                weight[i]=sc.nextInt();
            }
            Count(40,N);
            System.out.println(count);
        }
    }

    private static void Count(int s, int n) {
        //如果正好装满
        if(s==0){
            count++;
            return;
        }
        //是s<0或n<1则不能完成
        if(s<0||s>0&&n<1){
            return;
        }
        Count(s-weight[n-1],n-1);
        Count(s,n-1);
    }
}
