package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.exception.InputException;

public class OmrCardInfo implements Info<OmrCard> {
    private GameInput input;

    public OmrCardInfo(Input input) {
        this.input = (GameInput) input;
    }

    @Override
    public OmrCard get() {
        try {
            int money = money();
            int count = count(money);

            OmrCard omrCard = new OmrCard();
            markings(count, omrCard);

            return omrCard;
        } catch (Exception e) {
            input.redirectResponse(e.getMessage());
            return get();
        }
    }

    private void markings(int count, OmrCard omrCard) {
        for (int i = 0; i < count; i++) {
            SixBall sixBall = SixBall.get();
            omrCard.marking(sixBall);

            input.response(sixBall.toString());
        }

        input.response("\n");
    }

    private int money() throws InputException {
        String textMoney = input.request("구입금액을 입력해 주세요.");
        int money = parseIntMoney(textMoney);

        if (isValidateMinimumAmount(money)) {
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

    private boolean isValidateMinimumAmount(int money) {
        return money < OmrCard.PRICE;
    }

    private int count(int money) {
        int count = money / OmrCard.PRICE;
        int change = money % OmrCard.PRICE;

        if (change > 0) {
            input.response((String.format("거스름돈 %d원을 돌려드립니다.", change)));
        }

        input.response((String.format("%d개를 구매했습니다.", count)));

        return count;
    }
}
