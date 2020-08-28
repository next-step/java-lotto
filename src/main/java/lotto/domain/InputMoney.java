package lotto.domain;

import lotto.context.Error;

public class InputMoney {
    private static Integer money;

    public InputMoney(String inputMoney) {
        try {
            this.money = Integer.parseInt(inputMoney);
            if (this.money < 1000) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e ) {
            throw new NumberFormatException(Error.ERROR_INPUT_TYPE.getMsg());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_MIN_MONEY.getMsg());
        }
    }

    public static Integer getMoney() {
        return money;
    }
}
