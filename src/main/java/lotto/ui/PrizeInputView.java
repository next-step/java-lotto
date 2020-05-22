package lotto.ui;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrizeInputView {
    private String winTicketValue;
    private int winBonusNumber;

    public PrizeInputView(String inputValue, int winBonusNumber) {
        validation(inputValue);
        this.winTicketValue = inputValue;
        this.winBonusNumber = winBonusNumber;
    }

    private void validation(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException("Input value must not null");
        }

        if (inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Input value must not empty");
        }
    }

    public static PrizeInputView getThisWeekWinningInfo(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winTicketValue = scanner.nextLine();
        System.out.println("보너스 볼을 입력해주세요.");
        int winBonusNumber = scanner.nextInt();
        return new PrizeInputView(winTicketValue, winBonusNumber);
    }

    public LottoTicket convertToWinTicket() {
        return LottoGenerator.createManualByIntList(
                Arrays.asList(this.winTicketValue.split(","))
                        .stream()
                        .map(inputValue -> Integer.parseInt(inputValue.trim()))
                        .collect(Collectors.toList())
        );
    }

    public LottoNumber getWinBonusNumber() {
        return LottoNumber.create(this.winBonusNumber);
    }
}
