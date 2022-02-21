package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class InputView {

    private static final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTO_PURCHASE = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final int LOTTO_LENGTH = 6;

    private final Scanner scanner = new Scanner(System.in);

    private String getInputValue(final String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }

    public final int getTotalPrice() {
        int totalPrice = 0;
        try {
            totalPrice = Integer.parseInt(getInputValue(PRICE_MESSAGE));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
        return totalPrice;
    }

    public final List<LottoNumber> getWinNumbers() {
        String[] winLines = getInputValue(WIN_NUMBER_MESSAGE).split(",");
        if (winLines.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요");
        }
        try {
            return Arrays.stream(winLines)
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }

    public LottoNumber getBonusNumber() {
        try {
            return new LottoNumber(getInputValue(BONUS_NUMBER_MESSAGE));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }

    public final int getPurchaseManualLottoNumber() {
        System.out.println(MANUAL_LOTTO_PURCHASE);
        return scanner.nextInt();
    }

    public final List<List<LottoNumber>> getManualLottoNumbers(int purchaseManualLottoNumber) {
        System.out.println(MANUAL_LOTTO_NUMBERS_MESSAGE);
        List<List<LottoNumber>> manualLottos = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < purchaseManualLottoNumber; i++) {
            String string = scanner.nextLine();
            manualLottos.add(
                Arrays.stream(string.split(",")).map(LottoNumber::new)
                    .collect(Collectors.toList()));
        }
        return manualLottos;
    }
}
