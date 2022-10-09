package lotto.domain;

public class NotThousandUnitsMoneyException extends CanNotBuyLottoException {

    private static final NotThousandUnitsMoneyException NOT_THOUSAND_UNITS_MONEY_EXCEPTION = new NotThousandUnitsMoneyException("천 단위의 돈이 아닙니다.");

    private NotThousandUnitsMoneyException(String message) {
        super(message);
    }

    public static NotThousandUnitsMoneyException of() {
        return NOT_THOUSAND_UNITS_MONEY_EXCEPTION;
    }
}
