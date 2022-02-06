package view;

import domain.LottoGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String MESSAGE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_ANSWER_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
    private static final String MESSAGE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";
    Scanner scanner = new Scanner(System.in);

    public int inputPurchasePrice() {
        System.out.println(MESSAGE_INPUT_PURCHASE_PRICE);
        return scanner.nextInt();
    }

    public List<Integer> inputAnswerNumber() {
        System.out.println("\n" + MESSAGE_INPUT_ANSWER_NUMBER);
        return splitAnswerNumber(scanner.next());
    }

    public int inputBonusNumber() {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }


    public List<Integer> splitAnswerNumber(String answerNumbers) {
        return Arrays.stream(answerNumbers.split(COMMA))
                .map(stringNumber -> Integer.parseInt(stringNumber.trim()))
                .collect(Collectors.toList());
    }
}
