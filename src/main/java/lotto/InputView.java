package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private static final int PICK_NUMBER_COUNT = 6;

    static int inputCost() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    static Lotto inputWinningLotto() {
        List<Integer> pickNumbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        StringTokenizer token = new StringTokenizer(sc.next(), ", ");

        return Lotto.from(split(pickNumbers, token));
    }

    static int inputWinningBonus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    private static List<Integer> split(List<Integer> pickNumbers, StringTokenizer token) {
        for(int i = 0; i < PICK_NUMBER_COUNT; i++) {
            pickNumbers.add(Integer.parseInt(token.nextToken()));
        }
        return pickNumbers;
    }

}
