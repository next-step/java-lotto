package lotto.view;

import lotto.*;

import java.util.Scanner;

public class InputView {
    public static final String LOTTO_BUY_PAY_INPUT = "구입금액을 입력해 주세요.";
    public static final String WIN_LOTTO_NUMBER_INPUT = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_LOTTO_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    private Scanner scanner;

    public Pay payForLotto() {
        Pay pay;
        try {
            scanner = new Scanner(System.in);
            System.out.println(LOTTO_BUY_PAY_INPUT);
            int payForLotto = scanner.nextInt();
            pay = new Pay(payForLotto);
        } finally {
            scanner.nextLine();
        }
        return pay;
    }

    public Lotto inputWinLottoNumber() {
        String winNumber;
        System.out.println(WIN_LOTTO_NUMBER_INPUT);
        winNumber = scanner.nextLine();
        return new Lotto(LottoValidationUtils.lottoNumberToListNumbers(winNumber));
    }

    public LottoNumber inputBonusNumber(Lotto winLotto) {
        LottoNumber bonusNumber;
        try {
            System.out.println(BONUS_LOTTO_NUMBER_INPUT);
            int inputBonusNumber = scanner.nextInt();
            bonusNumber = new LottoNumber(winLotto, inputBonusNumber);
        } finally {
            if (scanner != null) scanner.close();
        }
        return bonusNumber;
    }
}
