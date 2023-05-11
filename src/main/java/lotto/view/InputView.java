package lotto.view;

import lotto.domain.LottoConstant;
import lotto.util.Util;

import java.util.Scanner;

public class InputView {

    private static final String ERROR_INPUT = "잘못된 값을 입력했습니다.";
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String FIRST_LOTTO_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String BOUNS_LOTTO_NUMBER = "\n보너스 볼을 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        String purchaseAmount = scanner.nextLine();
        validateInput(purchaseAmount);
        System.out.printf(PURCHASE_MESSAGE, Integer.parseInt(purchaseAmount) / LottoConstant.LOTTO_PRICE);
        return purchaseAmount;
    }

    public String inputFirstLottoNumber() {
        System.out.println(FIRST_LOTTO_NUMBER);
        String lottoNumber =  scanner.nextLine();
        validateInput(lottoNumber);
        return lottoNumber;
    }

    public String inputBonusLottoNumber() {
        System.out.println(BOUNS_LOTTO_NUMBER);
        String bonusNumber = scanner.nextLine();
        validateInput(bonusNumber);
        return bonusNumber;
    }

    private void validateInput(String input) {
        if(Util.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ERROR_INPUT);
        }
    }
}
