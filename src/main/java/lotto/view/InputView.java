package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.model.LottoInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern NON_NUMERIC_PATTERN = Pattern.compile(".*[ㄱ-ㅎㅏ-ㅣ가-힣|a-z|A-Z]+.*");

    public static final Scanner scanner = new Scanner(System.in);

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요 :)");
        int price = scanner.nextInt();
        validateNegativeNumberOrZero(price);

        return Money.wons(price);
    }

    private static void validateNegativeNumberOrZero(long amount) {
        if (amount < LottoInformation.LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException("1000원 이상 입력해주세요 :)");
        }
    }

    public static LottoNumbers inputWinningNumbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 압력해주세요 :)");
        String inputWinnerLottoNumber = scanner.nextLine();
        validateEmptyString(inputWinnerLottoNumber);
        validateNonNumeric(inputWinnerLottoNumber);

        return LottoNumbers.of(inputWinnerLottoNumber);
    }

    public static LottoNumber inputBonusNumber(LottoNumbers winnerLottoNumbers) {
        System.out.println("보너스 볼을 입력해주세요 :)");
        LottoNumber bonusNumber = LottoNumber.provideLottoNumber(scanner.nextInt());
        validateExistSameNumber(winnerLottoNumbers, bonusNumber);

        return bonusNumber;
    }

    public static Money inputManualNumberOfPurchases(Money inputMoney) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요");
        int numberOfPurchases = scanner.nextInt();
        validateEnoughMoney(numberOfPurchases, inputMoney);

        return Money.wons(LottoInformation.LOTTO_UNIT_PRICE).times(numberOfPurchases);
    }

    public static List<LottoNumbers> inputManualLottoNumber(Money manualPurchaseAmount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        Money money = Money.wons(manualPurchaseAmount.getAmount());
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        while (isEnoughBuyMoney(money)) {
            money = calculateCurrentMoney(money);
            lottoNumbersList.add(LottoNumbers.of(scanner.next()));
        }
        return lottoNumbersList;
    }

    private static void validateEmptyString(String inputWinnerLottoNumber) {
        if (inputWinnerLottoNumber == null) {
            throw new IllegalArgumentException("입력 값이 비었어요  :(");
        }
        if (inputWinnerLottoNumber.length() == 0) {
            throw new IllegalArgumentException("입력 값이 비었어요  :(");
        }
    }

    private static void validateNonNumeric(String inputWinnerLottoNumber) {
        if (NON_NUMERIC_PATTERN.matcher(inputWinnerLottoNumber).find()) {
            throw new IllegalArgumentException("숫자만 입력 가능하세요 :(");
        }
    }

    private static void validateExistSameNumber(LottoNumbers lottoNumber, LottoNumber bonusNumber) {
        if (lottoNumber.isMatchingLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("로또번호에 존재해요 :(");
        }
    }

    private static void validateEnoughMoney(int numberOfPurchases, Money inputMoney) {
        Money lottoPrice = Money.wons(LottoInformation.LOTTO_UNIT_PRICE).times(numberOfPurchases);

        if (lottoPrice.isGreaterThan(inputMoney)) {
            throw new IllegalArgumentException("잔액이 부족해요 :( \n 현재 잔액 [" + inputMoney.getAmount() + "원]");
        }
    }

    private static boolean isEnoughBuyMoney(Money money) {
        return money.isGreaterThan(LottoInformation.LOTTO_FEE);
    }

    private static Money calculateCurrentMoney(Money money) {
        return money.minus(LottoInformation.LOTTO_FEE);
    }
}
