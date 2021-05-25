package lotto;

import java.util.Scanner;

public class InputView {
    public static final String LOTTO_BUY_PAY_INPUT = "구입금액을 입력해 주세요.";
    public static final String WIN_LOTTO_NUMBER_INPUT = "지난 주 당첨 번호를 입력해 주세요.";

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
        try {
            System.out.println(WIN_LOTTO_NUMBER_INPUT);
            winNumber = scanner.nextLine();
            System.out.println(winNumber);
        } finally {
            if (scanner != null) scanner.close();
        }
        return new Lotto(LottoValidationUtils.lottoNumberToList(winNumber));
    }
}
