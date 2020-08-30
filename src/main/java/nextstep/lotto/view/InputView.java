package nextstep.lotto.view;

import nextstep.lotto.dto.LottoTicket;
import nextstep.lotto.utils.LottoNumberUtil;
import nextstep.lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_MINIMUM_AMOUNT_FOR_BUY;
import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_MINIMUM_MANUAL_AMOUNT_FOR_BUY;
import static nextstep.lotto.constant.PrintMessage.*;

public class InputView {

    private final int MINIMUM_BUY_AMOUNT = 1000;
    private final int MINIMUM_BUY_MANUAL_AMOUNT = 0;

    public int inputTotalAmountForBuy() {
        System.out.println(QUESTION_TEXT_BUY_TOTAL_AMOUNT);
        Scanner scanner = new Scanner(System.in);
        int totalAmount = scanner.nextInt();

        if (totalAmount < MINIMUM_BUY_AMOUNT) {
            throw new IllegalArgumentException(INVALID_INPUT_MINIMUM_AMOUNT_FOR_BUY);
        }

        return totalAmount;
    }

    public int inputManualLottoAmoutForBuy() {
        System.out.println(QUESTION_TEXT_BUY_MANUAL_AMOUNT);
        Scanner scanner = new Scanner(System.in);
        int manualAmount = scanner.nextInt();

        if (manualAmount < MINIMUM_BUY_MANUAL_AMOUNT) {
            throw new IllegalArgumentException(INVALID_INPUT_MINIMUM_MANUAL_AMOUNT_FOR_BUY);
        }

        return manualAmount;
    }

    public List<LottoTicket> inputManualNumber(int manualAmount) {
        System.out.println(QUESTION_TEXT_LOTTO_MANUAL_NUMBER);
        Scanner scanner = new Scanner(System.in);

        List<LottoTicket> manualLottoTickets = new ArrayList<>();

        for (int i = 0; i < manualAmount; i++) {
            String manualNumber = scanner.nextLine();
            List<String> manualNumbers = Arrays.asList(StringUtils.splitString(manualNumber));
            manualLottoTickets.add(LottoTicket.create(LottoNumberUtil.transStringNumberToLottoNumber(manualNumbers)));
        }

        return manualLottoTickets;
    }

    public List<String> inputWinnerNumber() {
        System.out.println(QUESTION_TEXT_LOTTO_WINNER_NUMBER);
        Scanner scanner = new Scanner(System.in);
        String winnerNumber = scanner.nextLine();
        return Arrays.asList(StringUtils.splitString(winnerNumber));
    }

    public int inputBonusNumber() {
        System.out.println(QUESTION_TEXT_LOTTO_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }
}
