package lotto.ui.input.info.request;

import lotto.core.rule.GameMoney;
import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;

public class TotalPurchaseCountRequest extends Request<Integer> {
    public TotalPurchaseCountRequest(GameInput input) {
        super(input);
    }

    @Override
    public Integer request() throws InputException {
        String textMoney = input.request("구입금액을 입력해 주세요.");
        int money = parseInt(textMoney);

        GameMoney gameMoney = new GameMoney(money);
        if (gameMoney.isCange()) {
            input.response((String.format("거스름돈 %d원을 돌려드립니다.", gameMoney.change())));
        }

        return gameMoney.numberOfGamesPlayed();
    }

    private int parseInt(String textMoney) throws InputException {
        try {
            return Integer.parseInt(textMoney);
        } catch (NumberFormatException e) {
            throw new InputException("구입금액은 숫자만 가능합니다.");
        }
    }
}
