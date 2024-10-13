package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchasePrice;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ", ";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static LottoPurchasePrice readTotalPurchasePrice() {
        System.out.println(PURCHASE_PRICE_QUESTION);
        return LottoPurchasePrice.valueOf(readNextInt());
    }

    public static List<Lotto> readManualLotto(final LottoPurchasePrice purchasePrice) {
        System.out.println(MANUAL_LOTTO_COUNT_QUESTION);
        int manualLottoCount = readNextInt();
        int autoLottoCount = purchasePrice.getLottoCount() - manualLottoCount;
        validateLottoCount(manualLottoCount, autoLottoCount);
        System.out.println(
                "수동으로 " + manualLottoCount
                        + "장, 자동으로 " + (purchasePrice.getLottoCount() - manualLottoCount)
                        + "개를 구매했습니다."
        );
        return getLottoTicket(manualLottoCount);
    }

    private static void validateLottoCount(final int manualLottoCount, final int autoLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("수동 로또 발급 횟수는 음수일 수 없습니다.");
        }
        if (autoLottoCount < 0) {
            throw new IllegalArgumentException("로또 구매 금액보다 많은 양의 로또는 구매할 수 없습니다.");
        }
    }

    private static int readNextInt() {
        int number = SCANNER.nextInt();
        SCANNER.nextLine();
        return number;
    }

    private static List<Lotto> getLottoTicket(int manualLottoCount) {
        List<Lotto> manualTicket = new ArrayList<>();
        System.out.println(MANUAL_LOTTO_NUMBER_QUESTION);
        for (int i = 0; i < manualLottoCount; i++) {
            manualTicket.add(new Lotto(getLottoNumbers()));
        }
        return manualTicket;
    }

    public static Lotto readLastWeekWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBERS_QUESTION);
        Set<LottoNumber> winningNumbers = getLottoNumbers();
        System.out.println(BONUS_NUMBER_QUESTION);
        LottoNumber bonusNumber = getBonusNumber();
        return new Lotto(winningNumbers, bonusNumber);
    }

    private static Set<LottoNumber> getLottoNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(number -> LottoNumber.valueOf(Integer.parseInt(number)))
                .collect(Collectors.toSet());
    }

    private static LottoNumber getBonusNumber() {
        return LottoNumber.valueOf(SCANNER.nextInt());
    }
}
