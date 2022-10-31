package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputView {

    private InputView() {
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPurchaseAmount = SCANNER.nextInt();
        SCANNER.skip("\n");
        return lottoPurchaseAmount;
    }

    public static List<LottoNumbers> inputManualPurchaseLottoNumbers() {
        return inputManualPurchaseLottoNumbersStrings(inputManualPurchaseLottoCount()).stream()
                                                                                      .map(InputView::toLottoNumbers)
                                                                                      .collect(Collectors.toList());
    }

    private static int inputManualPurchaseLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualPurchaseLottoCount = SCANNER.nextInt();
        SCANNER.skip("\n");
        return manualPurchaseLottoCount;
    }

    private static List<String> inputManualPurchaseLottoNumbersStrings(final int manualPurchaseLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.rangeClosed(1, manualPurchaseLottoCount)
                        .mapToObj(order -> SCANNER.nextLine())
                        .collect(Collectors.toList());
    }

    public static LottoNumbers inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return toLottoNumbers(SCANNER.nextLine());
    }

    public static LottoNumber inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusLottoNumber = SCANNER.nextInt();
        SCANNER.skip("\n");
        return new LottoNumber(bonusLottoNumber);
    }

    private static LottoNumbers toLottoNumbers(final String lottoNumbersString) {
        return new LottoNumbers(Stream.of(lottoNumbersString.split(","))
                                      .map(String::trim)
                                      .map(Integer::parseInt)
                                      .map(LottoNumber::new)
                                      .collect(Collectors.toList()));
    }
}
