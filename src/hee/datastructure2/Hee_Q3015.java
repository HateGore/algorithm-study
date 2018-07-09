package hee.datastructure2;

import java.util.Scanner;
import java.util.Stack;

public class Hee_Q3015 {
    static Scanner  scanner = new Scanner(System.in);

    public static void run() {
        int n = scanner.nextInt();

        // 입력 받은 높이를 배열에 저장
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        // 한 명씩 줄을 설 때 자기 앞에 총 몇명을 볼 수 있는지
        // Stack에 들어있는 사람: 뒤에 들어올 사람이 볼 수도 있는 사람
        // Stack에서 이미 나간 사람: 뒤에 들어올 사람이 절대 볼 수 없는 사람
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i=0; i<n; i++) {
            // Stack의 top위치의 사람(S) 키 < 새로 줄을 설 사람(A)의 키
            // A 뒤에 들어올 사람들은 S를 절대 볼 수 없다.
            while (!stack.empty()) {
                if (height[stack.peek()] < height[i]){
                    // (Stack이 비어있지 않으면) A는 S를 볼 수 있기 때문에 +1
                    count++;
                    // Stack의 top위치의 사람(S)을 Stack에서 pop()
                    stack.pop();
                }
                else {
                    break;
                }
            }
            if (!stack.empty()) {
                count++;
            }
            // 새로 줄을 설 사람(A)을 Stack에 push()
            stack.push(height[i]);
        }
    }
}
