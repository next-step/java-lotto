package step4.view;

import step4.model.Lotto;
import step4.model.LottoCount;
import step4.model.LottoNumbers;
import step4.model.Price;
import step4.utils.NumberSplitUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PUT_PAY_PRICE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PUT_LAST_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public Price payPriceInput() {
        System.out.println(PUT_PAY_PRICE);
        return new Price(scanner.nextInt());
    }

    public LottoCount manualLottoCountInput() {
        scanner.nextLine();
        System.out.println(MANUAL_LOTTO_COUNT);
        return new LottoCount(scanner.nextInt());
    }

    public List<Lotto> manualLottoNumberInput(LottoCount manualLottoCount) {
        scanner.nextLine();
        System.out.println(MANUAL_LOTTO_NUMBERS);

        return IntStream.range(0, manualLottoCount.getCount())
                .mapToObj(n -> new Lotto(new LottoNumbers(NumberSplitUtils.splitWinNumberString(scanner.nextLine()))))
                .collect(Collectors.toList());
    }

    public String putLastWinNumbers() {
        System.out.println(PUT_LAST_WIN_NUMBERS);
        return scanner.nextLine();
    }

    public int bonusNumberInput() {
        System.out.println(PUT_BONUS_NUMBER);
        return scanner.nextInt();
    }
}
