package lotto.view;

import lotto.domain.Lotto;
import lotto.input.ManualLottoInput;
import lotto.input.TicketPriceInput;
import lotto.domain.WinningLotto;

import java.util.*;

import static lotto.util.StringUtils.refineNumbers;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    private static final String PURCHASE_PRICE_MSG = "구입금액을 입력해 주세요";
    private static final String MANUAL_LOTTO_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_LOTTO_NUMBERS_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_WINNING_NUMBER_MSG = "보너스 볼을 입력해 주세요.";

    public TicketPriceInput getTicketPriceInput() {
        System.out.println(PURCHASE_PRICE_MSG);
        TicketPriceInput result;
        int priceInput = scanner.nextInt();
        result = new TicketPriceInput(priceInput);
        return result;
    }

    public ManualLottoInput getManualCountInput(){
        System.out.println(MANUAL_LOTTO_COUNT_MSG);
        int lottoCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println(MANUAL_LOTTO_NUMBERS_MSG);
        List<String> lottoInputs = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoInputs.add(scanner.nextLine());
        }
        return new ManualLottoInput(lottoInputs);
    }

    public WinningLotto getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MSG);
        Scanner scanner = new Scanner(System.in);
        String winningNumbers =  scanner.nextLine();
        System.out.println(BONUS_WINNING_NUMBER_MSG);
        String bonusWinningNumber = scanner.nextLine();

        Set<Integer> refinedWinningNumbers = refineNumbers(winningNumbers);
        int refinedBonusNumber = Integer.parseInt(bonusWinningNumber);

        return new WinningLotto(new Lotto(refinedWinningNumbers), refinedBonusNumber);
    }

}
