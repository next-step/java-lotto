package lotto.view;

import lotto.domain.*;
import lotto.resources.StringResources;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    public Money getPurchaseAmount() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_PURCHASE_AMOUNT_HINT);

        try {
            return new Money(scanner.nextInt());
        } catch (Exception exception) {
            exception.printStackTrace();
            return getPurchaseAmount();
        }
    }

    public LottoCount getManualLottoCount(final Money money) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_PURCHASE_MANUAL_LOTTO_COUNT_HINT);
        final int manualLottoCount = Integer.parseInt(scanner.nextLine());

        try {
            return new LottoCount(money, manualLottoCount);
        } catch (Exception exception) {
            exception.printStackTrace();
            return getManualLottoCount(money);
        }
    }

    public ManualNumbersPicker getManualPickedNumberLines(final LottoCount lottoCount) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_MANUAL_LOTTO_NUMBERS_HINT);

        final List<String> manualPickedNumberLines = IntStream
                .range(0, lottoCount.getManualLottoCount())
                .mapToObj(index -> scanner.nextLine())
                .collect(Collectors.toList());

        try {
            return new ManualNumbersPicker(manualPickedNumberLines);
        } catch (Exception exception) {
            exception.printStackTrace();
            return getManualPickedNumberLines(lottoCount);
        }
    }

    public LottoTicket getWinningTicketNumbers() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(StringResources.INPUT_LAST_WINNING_LOTTO_NUMBERS_HINT);
        String inputText = scanner.nextLine();
        String[] winningTicketNumbers = inputText.trim().split(",");

        try {
            return new LottoTicket(winningTicketNumbers);
        } catch (Exception exception){
            exception.printStackTrace();
            return getWinningTicketNumbers();
        }
    }

    public LottoNumber getBonusNumber() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_BONUS_BALL_HINT);

        try{
            return new LottoNumber(scanner.nextInt());
        } catch (Exception exception){
            exception.printStackTrace();
            return getBonusNumber();
        }
    }
}
