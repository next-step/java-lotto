package lotto.ui;

import lotto.core.Ball;
import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.core.round.Round;
import lotto.util.StringUtils;
import java.util.Arrays;
import java.util.Scanner;

public class GameInput {
    private GameOutput output;
    private Scanner sc;

    public GameInput(GameOutput output, Scanner sc) {
        this.output = output;
        this.sc = sc;
    }

    public OmrCard inputOmrInfo() {
        try {
            int money = getMoney();
            int size = getSize(money);

            OmrCard omrCard = new OmrCard();
            markings(size, omrCard);

            return omrCard;
        } catch (Exception e) {
            output.println(String.format("[부적합한 입력값] %s\n", e.getMessage()));
            return inputOmrInfo();
        }
    }

    private void markings(int size, OmrCard omrCard) {
        for (int i = 0; i < size; i++) {
            omrCard.marking(SixBall.get());
        }
    }

    public Round inputRound() {
        int[] fix = getFix();
        int bonus = getBonus(fix);

        return new Round(SixBall.get(fix), bonus);
    }

    private int getMoney() {
        int money;
        try {
            String strMoney = (String) response("구입금액을 입력해 주세요.");
            money = Integer.parseInt(strMoney);
        } catch (NumberFormatException e) {
            throw new RuntimeException("금액은 숫자만 가능합니다.");
        }

        if (money < OmrCard.PRICE) {
            throw new RuntimeException(String.format("구입 최소금액은 %d입니다.", OmrCard.PRICE));
        }

        return money;
    }

    private int getSize(int money) {
        int size = money / OmrCard.PRICE;
        int change = money % OmrCard.PRICE;

        if (change > 0) {
            output.println(String.format("거스름돈 %d원을 돌려드립니다.", change));
        }

        output.println(String.format("%d개를 구매했습니다.", size));

        return size;
    }

    private int[] getFix() {
        try {
            String text = (String) response("지난 주 당첨 번호를 입력해 주세요.");
            int[] fix = StringUtils.csvToIntArray(text);

            Arrays.stream(fix).forEach(this::ballValidation);

            return fix;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private int getBonus(int[] fix) {
        try {
            int bonus = Integer.parseInt((String) response("보너스 볼을 입력해 주세요."));

            bonusBallValidation(fix, bonus);

            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 볼은 숫자만 가능합니다.");
        }
    }

    private boolean bonusBallValidation(int[] fix, int bonus) {
        int index = 0;
        if (fix[index++] == bonus) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호에 포함되어 있습니다.");
        }

        return ballValidation(bonus);
    }

    private boolean ballValidation(int bonus) {
        if (Ball.validation(bonus)) {
            throw new IllegalArgumentException(String.format("번호는 %d이상 %d이하의 숫자만 존재할수있습니다.", Ball.MIN, Ball.MAX));
        }

        return true;
    }

    private Object response(String messaage) {
        output.println(messaage);

        return sc.nextLine();
    }

}
