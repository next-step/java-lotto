package lotto.view;

import lotto.model.Money;
import lotto.model.lottos.Lotto;
import lotto.model.lottos.LottoNumber;
import lotto.util.ScannerUtil;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.Messages.*;

public class InputView {
    private static final int ZERO = 0;
    private static final String DELIMITER = ",";

    public static Money getMoney() {
        printMessage(MESSAGE_MONEY_INPUT);

        return new Money(ScannerUtil.readInt());
    }

    public static int getManualLottoCount(Money money) {
        printMessage(MESSAGE_MANUAL_LOTTO_COUNT);

        int allLottoCount = money.getLottoCount();
        int manualLottoCount = ScannerUtil.readInt();
        validatePurchasable(isPurchasable(allLottoCount, manualLottoCount));

        return manualLottoCount;
    }

    public static List<Lotto> getManualLottos(int manualLottoCount) {
        printMessage(MESSAGE_LOTTO_MANUAL);

        if (manualLottoCount == ZERO) {
            return Collections.EMPTY_LIST;
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            lottos.add(splitByComma(ScannerUtil.readLine()));
        }

        return lottos;
    }

    public static Lotto getWinningLottoNumbers() {
        printMessage(MESSAGE_WINNING_LOTTO);
        return splitByComma(ScannerUtil.readLine());
    }

    public static LottoNumber getBonusBallNumber() {
        printMessage(MESSAGE_BONUS_BALL);
        return new LottoNumber(ScannerUtil.readInt());
    }

    private static boolean isPurchasable(int allLottoCount, int manualLottoCount) {
        return manualLottoCount <= allLottoCount;
    }

    private static void validatePurchasable(boolean isPurchasable) {
        if (!isPurchasable) {
            System.out.println(WARNING_LOTTO_COUNT);
        }
    }

    private static Lotto splitByComma(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(it -> it.trim())
                .map(it -> ScannerUtil.convertStringToInteger(it))
                .map(it -> new LottoNumber(it))
                .sorted(comparing(LottoNumber::getLottoNumber))
                .collect(collectingAndThen(toList(), Lotto::new));
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}