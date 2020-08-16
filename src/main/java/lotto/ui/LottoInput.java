package lotto.ui;

import common.StringResources;
import lotto.domain.LottoResultNumber;
import lotto.domain.Ticket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInput {

    private static final String DELIMITER = ", ";

    public static final int LOTTO_PRICE = 1000;

    private final Input input;

    public LottoInput(Input input) {
        this.input = input;
    }

    public int inputMoney() {

        ResultView.print(StringResources.MSG_BUY_MONEY);
        int money = input.nextInt();

        verifyPositiveMoney(money);
        verifyMoneyUnit(money);

        ResultView.print(String.valueOf(money));
        return money;
    }

    private void verifyPositiveMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(StringResources.ERR_MUST_BUY);
        }
    }

    private void verifyMoneyUnit(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_UNIT);
        }
    }

    public LottoResultNumber inputLottoResult() {

        ResultView.print(StringResources.MSG_WINNING_NUMBER);

        String inputLine = input.nextLine();
        verifyResultInput(inputLine);

        String[] split = inputLine.split(DELIMITER);
        verifySplitArray(split);

        return new LottoResultNumber(new Ticket(
                Arrays.stream(split)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList())));
    }

    private void verifyResultInput(String inputLine) {
        if (inputLine == null || inputLine.trim().equals("")) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RESULT_INPUT);
        }
    }

    private void verifySplitArray(String[] split) {
        if (split.length != 6) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RESULT_INPUT);
        }
    }
}
