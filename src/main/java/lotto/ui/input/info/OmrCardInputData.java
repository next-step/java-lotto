package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.exception.InputException;
import lotto.ui.output.GameOutput;

public class OmrCardInputData implements InputData<OmrCard> {
    private GameInput input;

    public OmrCardInputData(Input input) {
        this.input = (GameInput) input;
    }

    @Override
    public OmrCard request() {
        try {
            int money = requestMoney();
            int count = requestCount(money);

            OmrCard omrCard = new OmrCard();
            markings(count, omrCard);

            return omrCard;
        } catch (Exception e) {
            input.alertWarn(e.getMessage());
            return request();
        }
    }

    private void markings(int count, OmrCard omrCard) {
        for (int i = 0; i < count; i++) {
            SixBall sixBall = SixBall.valueOf();
            omrCard.marking(sixBall);

            input.response(sixBall.toString());
        }

        input.response(GameOutput.NEW_LINE);
    }

    private int requestMoney() throws InputException {
        String textMoney = input.request("구입금액을 입력해 주세요.");
        int money = parseIntMoney(textMoney);

        if (OmrCard.isValidateMinimumAmount(money)) {
            throw new InputException(String.format("구입 최소금액은 %d원 입니다.", OmrCard.PRICE));
        }

        return money;
    }

    private int parseIntMoney(String textMoney) throws InputException {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new InputException("금액은 숫자만 가능합니다.");
        }
    }

    private int requestCount(int money) {
        int count = money / OmrCard.PRICE;
        int change = money % OmrCard.PRICE;

        if (change > 0) {
            input.response((String.format("거스름돈 %d원을 돌려드립니다.", change)));
        }

        input.response((String.format("%d개를 구매했습니다.", count)));

        return count;
    }
}
