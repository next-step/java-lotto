package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.exception.InputException;
import lotto.util.StringUtils;

public class RoundInputData implements InputData<Round> {
    private final GameInput input;

    public RoundInputData(Input input) {
        this.input = (GameInput) input;
    }

    @Override
    public Round request() {
        try {
            int[] fixedBalls = requestFixedBalls();
            int bonus = requestBonus();

            return new Round(SixBall.valueOf(fixedBalls), bonus);
        } catch (Exception e) {
            input.alertWarn(e.getMessage());
            return request();
        }
    }

    private int[] requestFixedBalls() throws InputException {
        int[] fixedBalls = requestWinningNumber();

        if (isWinningSixBallValidation(fixedBalls.length)) {
            throw new InputException(String.format("당첨 번호는 총 %d개를 입력해주셔야 합니다.", SixBall.LENGTH));
        }

        return fixedBalls;
    }

    private int[] requestWinningNumber() throws InputException{
        try {
            String text = input.requestAfterNewLine("지난 주 당첨 번호를 입력해 주세요.");
            return StringUtils.csvToIntArray(text);
        } catch (NumberFormatException e) {
            throw new InputException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private int requestBonus() throws InputException {
        try {
            return Integer.parseInt(input.request("보너스 볼을 입력해 주세요."));
        } catch (NumberFormatException e) {
            throw new InputException("보너스 볼은 숫자만 가능합니다.");
        }
    }

    private boolean isWinningSixBallValidation(int length) {
        return length < SixBall.LENGTH;
    }

}
