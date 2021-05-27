package lotto.ui.input.info.request;

import lotto.core.SixBall;
import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;
import lotto.util.StringUtils;

public class WinningSixBallsRequest extends Request<SixBall> {

    public WinningSixBallsRequest(GameInput input) {
        super(input);
    }

    @Override
    public SixBall request() throws InputException {
        int[] fixedBalls = requestWinningNumber();

        if (isWinningSixBallValidation(fixedBalls.length)) {
            throw new InputException(String.format("당첨 번호는 총 %d개를 입력해주셔야 합니다.", SixBall.LENGTH));
        }

        return SixBall.valueOf(fixedBalls);
    }

    private int[] requestWinningNumber() throws InputException{
        try {
            String text = input.requestAfterNewLine("지난 주 당첨 번호를 입력해 주세요.");
            return StringUtils.csvToIntArray(text);
        } catch (NumberFormatException e) {
            throw new InputException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private boolean isWinningSixBallValidation(int length) {
        return length < SixBall.LENGTH;
    }
}
