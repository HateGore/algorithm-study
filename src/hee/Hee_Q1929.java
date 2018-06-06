package hee;

import java.util.Scanner;

// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1≤M≤N≤1,000,000)
public class Hee_Q1929 {
    static Scanner scanner = new Scanner(System.in);

    //                                 어떤 수 N이 소수인지 아닌지를 판단하는 시간복잡도: O(N)
    static public boolean prime(int num){
        if(num < 2){
            return false; // num=0, 1이면 소수가 아니다
        }
        // 2 ~ 루트num까지 나누어지는지 확인한다
        for (int i=2; i*i<=num; i++){
            if(num%i == 0){
                return false; // 소수가 아니다
            }
        }
        return true;
    }

    static public void run(){
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        for(int i=m; i<=n; i++){
            if (prime(i) == true){
                System.out.println(i);
            }
        }
    }
}
