package view;

import domain.Lotto;
import domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String MESSAGE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_INPUT_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_ANSWER_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
    private static final String MESSAGE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";
    Scanner scanner = new Scanner(System.in);

    public int inputPurchasePrice() {
        System.out.println(MESSAGE_INPUT_PURCHASE_PRICE);
        return scanner.nextInt();
    }

    public int inputManualLottoCount() {
        System.out.println("\n" + MESSAGE_INPUT_LOTTO_COUNT);
        return scanner.nextInt();
    }

    public List<Lotto> inputManualLotto(int manualCount) {
        System.out.println("\n" + MESSAGE_INPUT_LOTTO_NUMBER);
        return IntStream.range(0, manualCount)
                .mapToObj(i -> inputLotto())
                .map(Lotto::create)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> inputAnswerNumber() {
        System.out.println("\n" + MESSAGE_INPUT_ANSWER_NUMBER);
        return inputLotto();
    }

    public List<LottoNumber> inputLotto() {
        return splitAnswerNumber(scanner.next());
    }


    public int inputBonusNumber() {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }


    public List<LottoNumber> splitAnswerNumber(String answerNumbers) {
        return Arrays.stream(answerNumbers.split(COMMA))
                .map(stringNumber -> new LottoNumber(Integer.parseInt(stringNumber.trim())))
                .collect(Collectors.toList());
    }
}
