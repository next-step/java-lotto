package view;

import domain.*;
import util.CustomScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CASH_INPUT_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
    private static final String MANUAL_COUNT_INPUT_ANNOUNCEMENT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_INPUT_ANNOUNCEMENT = "수동으로 구매할 번호를 입력해 주세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static Lottos printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.toList().forEach(System.out::println);
        System.out.println();
        return lottos;
    }

    public Cash scanCashWithAnnouncement() {
        System.out.println(CASH_INPUT_ANNOUNCEMENT);
        return scanCash();
    }

    public LottoNumbersList scanManualLottoNumbers(Cash cash) {
        System.out.println(MANUAL_COUNT_INPUT_ANNOUNCEMENT);
        ManualLottoCount manualLottoCount = scanManualLottoCount(cash.divide(Lotto.PRICE).longValue());

        System.out.println(MANUAL_LOTTO_NUMBERS_INPUT_ANNOUNCEMENT);
        LottoNumbersList manualLottoNumbers = new LottoNumbersList(new ArrayList<>());
        for (long i = 0; manualLottoCount.isBiggerThan(i); i++) {
            manualLottoNumbers = manualLottoNumbers.add(scanManualLottoNumbers());
        }
        return manualLottoNumbers;
    }

    private Cash scanCash() {
        try {
            Cash inputCash = new Cash(CustomScanner.scanInt(scanner));
            validateMin(inputCash);
            validateMultiple(inputCash);
            return inputCash;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanCash();
        }
    }

    private ManualLottoCount scanManualLottoCount(long maxCount) {
        try {
            ManualLottoCount manualLottoCount = new ManualLottoCount(CustomScanner.scanInt(scanner));
            validateMaxCount(manualLottoCount, maxCount);
            return manualLottoCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanManualLottoCount(maxCount);
        }
    }

    private LottoNumbers scanManualLottoNumbers() {
        try {
            List<Integer> inputNumbers = CustomScanner.scanCommaSeparatedInts(scanner);
            return LottoNumbers.create(inputNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanManualLottoNumbers();
        }
    }

    private void validateMin(Cash inputCash) {
        if (inputCash.isLessThan(Lotto.PRICE)) {
            throw new IllegalArgumentException(String.format("구입금액은 %s 이상이어야 합니다.", Lotto.PRICE));
        }
    }

    private void validateMultiple(Cash inputCash) {
        if (!inputCash.isMultipleOf(Lotto.PRICE)) {
            throw new IllegalArgumentException(String.format("구입금액은 %s의 배수여야 합니다.", Lotto.PRICE));
        }
    }

    private void validateMaxCount(ManualLottoCount manualCount, long maxCount) {
        if (manualCount.isBiggerThan(maxCount)) {
            throw new IllegalArgumentException("수동 로또 개수는 총 로또 개수 이하여야 합니다.");
        }
    }
}
