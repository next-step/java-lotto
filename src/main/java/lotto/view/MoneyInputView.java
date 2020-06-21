package lotto.view;

import lotto.domain.LottoMoney;

import java.math.BigDecimal;
import java.util.Scanner;

public class MoneyInputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final LottoMoney lottoMoney;

    private MoneyInputView(BigDecimal money) {
        this.lottoMoney = new LottoMoney(money);
    }

    public static MoneyInputView enterMoney() {
        return new MoneyInputView(getInput());
    }

    private static BigDecimal getInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        return SCANNER.nextBigDecimal();
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }

}
