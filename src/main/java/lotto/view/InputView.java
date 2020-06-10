package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.PurchasedLottoTicket;
import lotto.model.PurchasedLottoTickets;
import lotto.utils.StringConverter;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_TEXT = "구입금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_MANUAL_LOTTO_COUNT_TEXT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBER_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUMBER_TEXT = "보너스 볼을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_TEXT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int inputPurchaseManualLottoCount() {
        System.out.println(INPUT_PURCHASE_MANUAL_LOTTO_COUNT_TEXT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static PurchasedLottoTickets inputPurchasedManualTicketsByCount(final int purchaseManualLottoCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_TEXT);

        List<PurchasedLottoTicket> purchasedLottoTickets = Stream.generate(() -> StringConverter.convertToLottoNumbers(SCANNER.nextLine()))
            .limit(purchaseManualLottoCount)
            .collect(Collectors.toList());

        return PurchasedLottoTickets.create(purchasedLottoTickets);
    }

    public static String inputWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER_TEXT);
        return SCANNER.nextLine();
    }

    public static int inputBonusLottoNumber() {
        System.out.println(INPUT_BONUS_LOTTO_NUMBER_TEXT);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
