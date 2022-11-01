package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.input.LottoTicketInput;
import lotto.input.ManualLottoInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.util.StringUtils.refineNumbers;

public class InputView {

    private static final String PURCHASE_PRICE_MSG = "구입금액을 입력해 주세요";
    private static final String MANUAL_LOTTO_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_WINNING_NUMBER_MSG = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);


    public LottoTicketInput getLottoTicket() {
        System.out.println(PURCHASE_PRICE_MSG);
        LottoTicketInput result;
        int priceInput = scanner.nextInt();
        result = new LottoTicketInput(priceInput);
        return result;
    }

    public ManualLottoInput getManualCountInput(LottoTicketInput lottoTicketInput) {
        System.out.println(MANUAL_LOTTO_COUNT_MSG);
        int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        validateManualCount(lottoTicketInput, manualLottoCount);
        System.out.println(MANUAL_LOTTO_NUMBERS_MSG);
        List<String> lottoInputs = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            lottoInputs.add(scanner.nextLine());
        }
        return new ManualLottoInput(lottoInputs);
    }

    private void validateManualCount(LottoTicketInput lottoTicketInput, int manualLottoCount) {
        if (manualLottoCount > lottoTicketInput.getTicketCount()) {
            throw new IllegalArgumentException("manual input count cannot be bigger than total lotto count");
        }
    }

    public WinningLotto getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MSG);
        Scanner scanner = new Scanner(System.in);
        String winningNumbers = scanner.nextLine();
        System.out.println(BONUS_WINNING_NUMBER_MSG);
        String bonusWinningNumber = scanner.nextLine();

        return new WinningLotto(Lotto.from(refineNumbers(winningNumbers)),
                new LottoNumber(Integer.parseInt(bonusWinningNumber)));
    }

}
