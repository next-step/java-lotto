package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.exception.InputException;
import lotto.util.StringUtils;

public class RoundInputData implements InputData<Round> {
    private GameInput input;

    public RoundInputData(Input input) {
        this.input = (GameInput) input;
    }

    @Override
    public Round get() {
        try {
            int[] fix = fixs();
            int bonus = bonus();

            return new Round(SixBall.get(fix), bonus);
        } catch (Exception e) {
            input.redirectResponse(e.getMessage());
            return get();
        }
    }

    private int[] fixs() throws InputException {
        int[] fixs = fixArray();

        if (isWinningSixBallValidation(fixs.length)) {
            throw new InputException(String.format("당첨 번호는 총 %d개를 입력해주셔야 합니다.", SixBall.LENGTH));
        }

        return fixs;
    }

    private int[] fixArray() throws InputException{
        try {
            String text = input.request("지난 주 당첨 번호를 입력해 주세요.");
            return StringUtils.csvToIntArray(text);
        } catch (NumberFormatException e) {
            throw new InputException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private int bonus() throws InputException {
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
