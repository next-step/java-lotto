package lotto.view;

import lotto.domain.dto.LottoBuyInfo;
import lotto.domain.dto.WinningLottoInfo;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class DosInputView implements InputView {
    private final Scanner scanner;

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private String inputLottoNumbers() {
        String strLottoNumbers = scanner.nextLine();

        if (!RegexPatterns.LOTTO_NUMBER.test(strLottoNumbers)) {
            System.out.println("로또 번호의 형식이 아닙니다.");
            return inputLottoNumbers();
        }
        return strLottoNumbers;
    }

    private List<String> inputLottoList(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> inputLottoNumbers())
                .collect(Collectors.toList());
    }

    private String inputLine(Text guideText) {
        System.out.println(guideText.toString());
        String input = scanner.nextLine();

        printEmptyLine();

        return input;
    }

    private int inputNumber(Text guideText) {
        String input = inputLine(guideText);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자의 형식이 아닙니다.");
            return inputNumber(guideText);
        }
    }


    public LottoBuyInfo inputLottoBuyInfo() {
        int inputMoney = inputNumber(Text.INPUT_MONEY);

        int inputManualLottoSize = inputNumber(Text.INPUT_MANUAL_LOTTO_SIZE);

        if (inputManualLottoSize > 0) {
            System.out.println(Text.INPUT_MANUAL_LOTTO);
        }
        List<String> inputManualLottoList = inputLottoList(inputManualLottoSize);

        printEmptyLine();

        return new LottoBuyInfo(inputMoney, inputManualLottoList);
    }

    @Override
    public WinningLottoInfo inputWinningLottoInfo() {
        System.out.println(Text.INPUT_WINNING_NUMBERS);
        String winningLottoNumbers = inputLottoNumbers();
        printEmptyLine();

        int bonusNumber = inputNumber(Text.INPUT_BONUS_NUMBER);

        return new WinningLottoInfo(winningLottoNumbers, bonusNumber);
    }

    private enum Text {
        INPUT_MONEY("구입금액을 입력해 주세요."),
        INPUT_MANUAL_LOTTO_SIZE("수동으로 구매할 로또 수를 입력해 주세요."),
        INPUT_MANUAL_LOTTO("수동으로 구매할 번호를 입력해 주세요."),
        INPUT_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요.");

        private final String str;

        Text(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    private enum RegexPatterns {
        LOTTO_NUMBER(
                Pattern.compile("[0-9\\s*]+(,[0-9\\s*]+){5}")
        );

        private final Pattern pattern;

        RegexPatterns(Pattern pattern) {
            this.pattern = pattern;
        }

        public boolean test(String text) {
            return pattern.matcher(text).matches();
        }
    }
}
