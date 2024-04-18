package view;

import domain.LottoBall;
import domain.Money;
import domain.MyLotto;

import java.util.*;

public class LottoInput {
    private final static Scanner input = new Scanner(System.in);
    public static Money money;

    public Money buyCash() {
        System.out.println("구입금액을 입력해 주세요.");
        money = new Money(input.nextInt());
        System.out.println();
        return money;
    }

    public int manualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return input.nextInt();
    }

    public void manualLottoNumbers(int count) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        input.nextLine();
        for (int i = 0; i < count; i++) {
            List<LottoBall> balls = new ArrayList<>();

            String[] numbers = input.nextLine().split(", ");

            validateNumber(balls, numbers);
            Collections.sort(balls, Comparator.comparingInt(LottoBall::getNumber));
            MyLotto.add(balls);
        }
        System.out.println();
    }

    private void validateNumber(List<LottoBall> balls, String[] numbers) {
        for (String number : numbers) {
            int num = parseInt(number);
            balls.add(LottoBall.ball(num));
        }
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
