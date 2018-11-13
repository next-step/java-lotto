package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private static final int pickNumber_Count = 6;
    Scanner sc = new Scanner(System.in);

    int inputCost() {
        System.out.println("구입금액을 입력해 주세요.");
        int cost = sc.nextInt();

        return cost;
    }

    List<Integer> inputPickNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//        String[] temp = sc.next().split(",");
        StringTokenizer token = new StringTokenizer(sc.next(), ", ");
        List<Integer> pickNumbers = new ArrayList<>();

        for(int i = 0; i < pickNumber_Count; i++) {
            pickNumbers.add(Integer.parseInt(token.nextToken()));
//            pickNumbers.add(Integer.parseInt(temp[i]));
        }

        return pickNumbers;
    }

}
