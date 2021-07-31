package lotto.view;

import lotto.domain.dto.WinningLottoRequest;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class DosInputView implements InputView {
    private final Scanner scanner;

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private String inputLottoNumbers() {
        String strLottoNumbers = inputLine(Text.INPUT_WINNING_NUMBERS);
        if (!RegexPatterns.LOTTO_NUMBER.test(strLottoNumbers)) {
            System.out.println("로또 번호의 형식이 아닙니다.");
            return inputLottoNumbers();
        }
        return strLottoNumbers;
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

    private String inputLine(Text guideText) {
        System.out.println(guideText.toString());

        return scanner.nextLine();
    }

    @Override
    public long inputMoney() {
        return inputNumber(Text.INPUT_MONEY);
    }

    @Override
    public WinningLottoRequest inputWinningLotto() {
        String winningLottoNumbers = inputLottoNumbers();
        int bonusNumber = inputNumber(Text.INPUT_BONUS_NUMBER);

        return new WinningLottoRequest(winningLottoNumbers, bonusNumber);
    }

    private enum Text {
        INPUT_MONEY("구입금액을 입력해 주세요."),
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
