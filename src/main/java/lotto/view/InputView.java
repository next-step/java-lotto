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

    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmountGuide() {
        System.out.println("구매 금액을 입력해주세요.");
        return inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        return scanner.nextInt();
    }

    public int inputManualLottoPurchaseAmount() {
        clearBuffer();
        System.out.println("\n수동으로 구매할 로또 수를 입력해주세요.");
        return inputPurchaseAmount();
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
        return LottoNumber.createLottoNumber(scanner.nextInt());
    }

    public List<LottoNumber> convertStringToIntList(String stringWinningNumber) {
        return Arrays.stream(splitString(stringWinningNumber))
                .map(Integer::parseInt)
                .map(LottoNumber::createLottoNumber)
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

}
