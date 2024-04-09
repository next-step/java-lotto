package view;

import domain.LottoBall;
import domain.Money;
import domain.MyLotto;
import domain.WinStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInput {
    private final static Scanner input = new Scanner(System.in);
    public static Money money;

    public Money buyCash() {
        System.out.println("구입금액을 입력해 주세요.");
        money = new Money(input.nextInt());
        return money;
    }

    public int manualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return input.nextInt();
    }

    public void manualLottoNumbers(int count) {
        System.out.println();
        List<LottoBall> balls = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] numbers = input.nextLine().split(", ");
            for (String number : numbers) {
                balls.add(LottoBall.ball(Integer.parseInt(number)));
            }
            MyLotto.add(balls);
        }
        System.out.println();
    }
}
