package view;

import domain.LottoBall;
import domain.Money;
import domain.MyLotto;
import domain.WinStatus;

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
            parseNumber(numbers);
            for (String number : numbers) {
                balls.add(LottoBall.ball(Integer.parseInt(number)));
            }
            Collections.sort(balls, Comparator.comparingInt(LottoBall::getNumber));
            MyLotto.add(balls);
        }
        System.out.println();
    }

    private void parseNumber(String[] numbers) {
        Set<Integer> balls = new HashSet<>();
        for (String number : numbers) {
            int ball = Integer.parseInt(number);
            if (ball < 0 || ball > 45)
                throw new IllegalArgumentException("로또 범위를 벗어났습니다");
            balls.add(ball);
        }
        if (6 > balls.size())
            throw new IllegalArgumentException("중복된 번호가 있습니다");
    }
}
