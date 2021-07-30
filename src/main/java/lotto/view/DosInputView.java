package lotto.view;

import lotto.domain.dto.WinningLottoRequest;
import lotto.exception.InvalidFormatStringException;

import java.util.Scanner;

public final class DosInputView implements InputView {
    private final Scanner scanner;

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private int inputNumber(Text guideText) {
        String input = inputLine(guideText);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidFormatStringException("숫자만 입력 해주세요.");
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
        String winningLottoNumbers = inputLine(Text.INPUT_WINNING_NUMBERS);
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
}
