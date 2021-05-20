package lotto.ui.input;

import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.core.round.Round;
import lotto.ui.input.validation.InputValidation;
import lotto.ui.output.Output;
import lotto.util.StringUtils;
import java.util.Arrays;
import java.util.Scanner;

public class GameInput {
    private static final int ZERO = 0;

    private Output output;
    private Scanner scanner;
    private InputValidation validation;

    public GameInput(Output output, Scanner scanner) {
        this.output = output;
        this.scanner = scanner;
        this.validation = new InputValidation();
    }

    public OmrCard inputOmrInfo() {
        try {
            int money = money();
            int size = size(money);

            OmrCard omrCard = new OmrCard();
            markings(size, omrCard);

            return omrCard;
        } catch (Exception e) {
            output.println(String.format("[부적합한 입력값] %s\n", e.getMessage()));
            return inputOmrInfo();
        }
    }

    private void markings(int size, OmrCard omrCard) {
        //리뷰어님 시작 index도 상수화를 해야하는건가요?
        for (int i = 0; i < size; i++) {
            omrCard.marking(SixBall.get());
        }
    }

    public Round inputRound() {
        int[] fix = fixs();
        int bonus = bonus(fix);

        return new Round(SixBall.get(fix), bonus);
    }

    private int money() {
        int money;
        try {
            String strMoney = (String) response("구입금액을 입력해 주세요.");
            money = Integer.parseInt(strMoney);
        } catch (NumberFormatException e) {
            throw new RuntimeException("금액은 숫자만 가능합니다.");
        }

        if (money < OmrCard.PRICE) {
            throw new RuntimeException(String.format("구입 최소금액은 %d원 입니다.", OmrCard.PRICE));
        }

        return money;
    }

    private int size(int money) {
        int size = money / OmrCard.PRICE;
        int change = money % OmrCard.PRICE;

        if (change > ZERO) {
            output.println(String.format("거스름돈 %d원을 돌려드립니다.", change));
        }

        output.println(String.format("%d개를 구매했습니다.", size));

        return size;
    }

    private int[] fixs() {
        try {
            String text = (String) response("지난 주 당첨 번호를 입력해 주세요.");
            int[] fixs = StringUtils.csvToIntArray(text);

            validation.winningSixBallValidation(fixs);

            Arrays.stream(fixs).forEach(validation::ballValidation);

            return fixs;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private int bonus(int[] fixs) {
        try {
            int bonus = Integer.parseInt((String) response("보너스 볼을 입력해 주세요."));

            validation.bonusBallValidation(fixs, bonus);

            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 볼은 숫자만 가능합니다.");
        }
    }

    private Object response(String messaage) {
        output.println(messaage);

        return scanner.nextLine();
    }

}
