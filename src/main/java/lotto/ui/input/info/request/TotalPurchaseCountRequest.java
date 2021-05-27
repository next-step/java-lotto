package lotto.ui.input.info.request;

import lotto.core.omr.OmrCard;
import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;

public class TotalPurchaseCountRequest extends Request<Integer> {
    public TotalPurchaseCountRequest(GameInput input) {
        super(input);
    }

    @Override
    public Integer request() throws InputException {
        int money = requestMoney();
        int count = calculateCountPurchases(money);

        return count;
    }

    private int requestMoney() throws InputException {
        String textMoney = input.request("구입금액을 입력해 주세요.");
        int money = parseInt(textMoney);

        if (OmrCard.isValidateMinimumAmount(money)) {
            throw new InputException(String.format("구입 최소금액은 %d원 입니다.", OmrCard.PRICE));
        }

        return money;
    }

    private int calculateCountPurchases(int money) {
        int count = money / OmrCard.PRICE;
        int change = money % OmrCard.PRICE;

        if (change > 0) {
            input.response((String.format("거스름돈 %d원을 돌려드립니다.", change)));
        }

        return count;
    }

    private int parseInt(String textMoney) throws InputException {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new InputException("구입금액은 숫자만 가능합니다.");
        }
    }
}
