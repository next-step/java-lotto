package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.resources.StringResources;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public Money getPurchaseAmount() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_PURCHASE_AMOUNT_HINT);
        return new Money(scanner.nextInt());
    }

    public List<String> getManualPickedNumberLines() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_PURCHASE_MANUAL_LOTTO_COUNT_HINT);
        final int manualLottoCount = Integer.parseInt(scanner.nextLine());

        final List<String> manualPickedNumberLines = new ArrayList<>();
        System.out.println(StringResources.INPUT_MANUAL_LOTTO_NUMBERS_HINT);
        for(int i=0; i<manualLottoCount; i++){
            String inputManualLottoLine = scanner.nextLine();
            manualPickedNumberLines.add(inputManualLottoLine);
        }

        return manualPickedNumberLines;
    }

    public String[] getWinningTicketNumbers() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(StringResources.INPUT_LAST_WINNING_LOTTO_NUMBERS_HINT);
        String inputText = scanner.nextLine();
        String[] winningTicketNumbers = inputText.trim().split(",");

        return winningTicketNumbers;
    }

    public LottoNumber getBonusNumber() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(StringResources.INPUT_BONUS_BALL_HINT);
        int bonusNumber = scanner.nextInt();

        return new LottoNumber(bonusNumber);
    }
}
