package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.ui.input.validation.InputValidation;
import lotto.util.StringUtils;
import java.util.Arrays;

public class RoundInfo implements Info<Round> {
    private GameInput input;

    //TODO
    private InputValidation validation;

    public RoundInfo(Input input) {
        this.input = (GameInput) input;
        this.validation = new InputValidation();
    }

    @Override
    public Round get() {
        try {
            int[] fix = fixs();
            int bonus = bonus(fix);

            return new Round(SixBall.get(fix), bonus);
        } catch (Exception e) {
            input.redirectResponse(e.getMessage());
            return get();
        }
    }

    private int[] fixs() throws Exception {
        int[] fixs = fixArray();

        validataionFix(fixs);

        return fixs;
    }

    private int[] fixArray() {
        try {
            String text = (String) input.request("지난 주 당첨 번호를 입력해 주세요.");
            return StringUtils.csvToIntArray(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private void validataionFix(int[] fixs) {
        validation.isWinningSixBallValidation(fixs);

        Arrays.stream(fixs).forEach(validation::isBallValidation);
    }

    private int bonus(int[] fixs) throws Exception {
        try {
            int bonus = Integer.parseInt((String) input.request("보너스 볼을 입력해 주세요."));

            validation.isBonusBallValidation(fixs, bonus);

            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 볼은 숫자만 가능합니다.");
        }
    }

}
