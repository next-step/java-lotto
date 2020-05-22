package lotto.ui;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTicket;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrizeInputView {
    private String value;

    public PrizeInputView(String inputValue) {
        validation(inputValue);
        this.value = inputValue;
    }

    private void validation(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException("Input value must not null");
        }

        if (inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Input value must not empty");
        }
    }

    public static PrizeInputView create(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new PrizeInputView(scanner.nextLine());
    }

    public LottoTicket convertToWinTicket() {
        return LottoGenerator.createManualByIntList(
                Arrays.asList(this.value.split(","))
                        .stream()
                        .map(inputValue -> Integer.parseInt(inputValue.trim()))
                        .collect(Collectors.toList())
        );
    }
}
