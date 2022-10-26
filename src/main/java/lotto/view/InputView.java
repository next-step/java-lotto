package lotto.view;

import lotto.domain.Lotto;
import lotto.input.TicketPriceInput;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class InputView {

    private static final String FIRST_MSG = "구입금액을 입력해 주세요";
    private static final String TICKET_AMT_MSG = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_WINNING_NUMBER_MSG = "보너스 볼을 입력해 주세요.";

    public TicketPriceInput getTicketPriceInput() {
        System.out.println(FIRST_MSG);
        TicketPriceInput result;
        Scanner scanner = new Scanner(System.in);
        int priceInput = scanner.nextInt();
        result = new TicketPriceInput(priceInput);
        System.out.println(result.getTicketAmt() + TICKET_AMT_MSG);
        return result;
    }

    public WinningLotto getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MSG);
        Scanner scanner = new Scanner(System.in);
        String winningNumbers =  scanner.nextLine();
        System.out.println(BONUS_WINNING_NUMBER_MSG);
        String bonusWinningNumber = scanner.nextLine();

        Set<Integer> refinedWinningNumbers = Arrays.stream(splitStringToLottoNumbers(removeSpace(winningNumbers)))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
        int refinedBonusNumber = Integer.parseInt(bonusWinningNumber);

        return new WinningLotto(new Lotto(refinedWinningNumbers), refinedBonusNumber);
    }

    private static String[] splitStringToLottoNumbers(String winningNumbersNoSpace) {
        return winningNumbersNoSpace.split(",");
    }

    private static String removeSpace(String winningLottoNumbers) {
        return winningLottoNumbers.replace(" ", "");
    }
}
