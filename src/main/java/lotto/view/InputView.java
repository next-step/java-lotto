package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseInfo;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmountGuide() {
        System.out.println("구매 금액을 입력해주세요.");
        return inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        int amount;
        try {
            amount = scanner.nextInt();
            validCanPurchaseLotto(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            clearBuffer();
            return inputPurchaseAmountGuide();
        }
        return calculateNumberOfTotalLotto(amount);
    }

    private int calculateNumberOfTotalLotto(int amount) {
        return amount / LOTTO_PRICE;
    }

    public int inputManualLottoPurchaseAmount(int purchaseAmount) {
        clearBuffer();
        System.out.println("\n수동으로 구매할 로또 수를 입력해주세요.");
        return inputNumberOfManualLotto(purchaseAmount);
    }

    private int inputNumberOfManualLotto(int purchaseAmount) {
        int numberOfManualLotto;
        try {
            numberOfManualLotto = scanner.nextInt();
            validManualPurchaseIsNegative(numberOfManualLotto);
            validNumberOfManualLotto(purchaseAmount, numberOfManualLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return inputManualLottoPurchaseAmount(purchaseAmount);
        }
        return numberOfManualLotto;
    }

    private void clearBuffer() {
        scanner.nextLine();
    }

    public Lotto inputWinnerNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(convertStringToIntList(scanner.nextLine()));
    }

    public LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.of(scanner.nextInt());
    }

    public List<LottoNumber> convertStringToIntList(String stringWinningNumber) {
        return Arrays.stream(splitString(stringWinningNumber))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private String[] splitString(String stringWinningNumber) {
        return stringWinningNumber.split(", ");
    }

    public Lottos inputManualLottoGuide(PurchaseInfo purchaseInfo) {
        clearBuffer();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return Lottos.createLottosByManual(inputManualLottos(purchaseInfo));
    }

    private List<Lotto> inputManualLottos(PurchaseInfo purchaseInfo) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseInfo.getNumberOfManualPurchase(); i++) {
            lottos.add(new Lotto(convertStringToIntList(scanner.nextLine())));
        }
        return lottos;
    }

    public void validCanPurchaseLotto(int totalAmount) {
        if (totalAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 미만으론 살 수 없음");
        }
    }

    public void validNumberOfManualLotto(int purchaseAmount, int manualPurchase) {
        if (manualPurchase > purchaseAmount) {
            throw new IllegalArgumentException("구매한 로또 수량보다 많의 수의 로또를 수동 구매 할 수 없습니다");
        }
    }

    public void validManualPurchaseIsNegative(int manualPurchase) {
        if (manualPurchase < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력해야 합니다");
        }
    }

    private int calculateNumberOfTotalPurchase(int totalAmount) {
        return totalAmount / LOTTO_PRICE;
    }

}
