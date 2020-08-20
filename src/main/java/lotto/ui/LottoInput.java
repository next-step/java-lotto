package lotto.ui;

import common.StringResources;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResultNumber;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInput {

    private static final String DELIMITER = ", ";
    private static final int ZERO = 0;

    public static final int LOTTO_PRICE = 1000;

    private final Input input;

    public LottoInput(Input input) {
        this.input = input;
    }

    public int inputPrincipal() {

        ResultView.print(StringResources.MSG_BUY_MONEY);
        int principal = input.nextInt();

        verifyPositiveMoney(principal);
        verifyMoneyUnit(principal);

        return principal;
    }

    public int inputManualLottoCount() {

        ResultView.print(StringResources.MSG_MANUAL_LOTTO_COUNT);
        return input.nextInt();
    }

    private void verifyPositiveMoney(int money) {
        if (money <= ZERO) {
            throw new IllegalArgumentException(StringResources.ERR_MUST_BUY);
        }
    }

    private void verifyMoneyUnit(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_UNIT);
        }
    }

    public List<LottoNumber> inputManualLottoList(int manualLottoCount) {

        ResultView.print(StringResources.MSG_MANUAL_LOTTO_NUMBER);

        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            lottoNumbers.add(new LottoNumber(makeTicket()));
        }

        return lottoNumbers;
    }

    private Ticket makeTicket() {

        String inputLine = input.nextLine();
        verifyResultInput(inputLine);

        String[] split = inputLine.split(DELIMITER);
        verifySplitArray(split);

        return new Ticket(
                Arrays.stream(split)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()),
                inputBonus());
    }

    public LottoResultNumber inputLottoResult() {

        ResultView.print(StringResources.MSG_WINNING_NUMBER);
        return new LottoResultNumber(makeTicket());
    }

    private void verifyResultInput(String inputLine) {
        if (inputLine == null || inputLine.trim().equals("")) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RESULT_INPUT);
        }
    }

    private void verifySplitArray(String[] split) {
        if (split.length != Ticket.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RESULT_INPUT);
        }
    }

    private int inputBonus() {
        System.out.println(StringResources.MSG_BONUS_NUMBER);
        return input.nextInt();
    }
}
