package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_MONEY = "로또의 최소금액은 1000원입니다.";
    private static final String ERROR_INPUT = "잘못된 값을 입력했습니다.";
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String FIRST_LOTTO_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String BOUNS_LOTTO_NUMBER = "\n보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_AMOUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String SPLIT_REGEX = ", ";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        String purchaseAmount = scanner.nextLine();
        validateMoney(purchaseAmount);
        return purchaseAmount;
    }

    public String inputFirstLottoNumber() {
        System.out.println(FIRST_LOTTO_NUMBER);
        String lottoNumber =  scanner.nextLine();
        validateNullOrEmpty(lottoNumber);
        return lottoNumber;
    }

    public String inputBonusLottoNumber() {
        System.out.println(BOUNS_LOTTO_NUMBER);
        String bonusNumber = scanner.nextLine();
        validateNullOrEmpty(bonusNumber);
        return bonusNumber;
    }

    public String inputManualAmount() {
        System.out.println(MANUAL_LOTTO_AMOUNT);
        String manualLottoAmount = scanner.nextLine();
        validateNullOrEmpty(manualLottoAmount);
        return manualLottoAmount;
    }

    public List<Lotto> inputManualLottoNumber(LottoPurchase lottoPurchase) {
        System.out.println(MANUAL_LOTTO_NUMBER);
        List<Lotto> manualLotto = new ArrayList<>();
        lottoPurchase.manualStream().forEach(i -> manualLotto.add(createLotto()));
        return manualLotto;
    }

    private Lotto createLotto() {
        String input = scanner.nextLine();
        validateNullOrEmpty(input);
        String[] lottoNumbers = input.split(SPLIT_REGEX);
        return new Lotto(lottoNumbers);
    }

    private void validateNullOrEmpty(String input) {
        if(Util.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ERROR_INPUT);
        }
    }

    private void validateMoney(String input) {
        if(Util.convertInt(input) < LOTTO_PRICE) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }


}
