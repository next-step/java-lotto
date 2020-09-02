package lotto.domain;

import lotto.context.Error;

public class InputMoney {
    private static final int MIN_INPUT_MONEY = 1000;
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public InputMoney(String inputMoney) {
        validInputMoney(inputMoney);
        this.money = Integer.parseInt(inputMoney);
    }

    private void validInputMoney(String inputMoney) {
        try {
            if (Integer.parseInt(inputMoney) < MIN_INPUT_MONEY) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e ) {
            throw new NumberFormatException(Error.ERROR_INPUT_TYPE.getMsg());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_MIN_MONEY.getMsg());
        }
    }

    public int getPaperCount() {
        return this.money / LOTTO_PRICE;
    }

    public WinningEarningsRate makeWinningEarningsRate() {
        return new WinningEarningsRate(money);
    }
}
