package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.omr.OmrCard;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;

public class OmrCardInfo implements Info<OmrCard> {
    private GameInput input;

    public OmrCardInfo(Input input) {
        this.input = (GameInput) input;
    }

    @Override
    public OmrCard get() {
        try {
            int money = money();
            int size = size(money);

            OmrCard omrCard = new OmrCard();
            markings(size, omrCard);

            return omrCard;
        } catch (Exception e) {
            input.redirectResponse(e.getMessage());
            return get();
        }
    }

    private void markings(int size, OmrCard omrCard) {
        for (int i = 0; i < size; i++) {
            omrCard.marking(SixBall.get());
        }
    }

    private int money() throws Exception {
        String textMoney = (String) input.request("구입금액을 입력해 주세요.");
        int money = parseIntMoney(textMoney);

        return validateMinimumAmount(money);
    }

    private int parseIntMoney(String textMoney) {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new RuntimeException("금액은 숫자만 가능합니다.");
        }
    }

    private int validateMinimumAmount(int money) {
        if (money < OmrCard.PRICE) {
            throw new RuntimeException(String.format("구입 최소금액은 %d원 입니다.", OmrCard.PRICE));
        }

        return money;
    }

    private int size(int money) {
        int size = money / OmrCard.PRICE;
        int change = money % OmrCard.PRICE;

        if (change > 0) {
            input.response((String.format("거스름돈 %d원을 돌려드립니다.", change)));
        }

        input.response((String.format("%d개를 구매했습니다.", size)));

        return size;
    }

}
