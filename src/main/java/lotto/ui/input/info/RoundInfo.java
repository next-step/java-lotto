package lotto.ui.input.info;

import lotto.core.SixBall;
import lotto.core.round.Round;
import lotto.ui.input.GameInput;
import lotto.ui.input.Input;
import lotto.util.StringUtils;

public class RoundInfo implements Info<Round> {
    private GameInput input;

    public RoundInfo(Input input) {
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

    private int[] fixs() throws Exception {
        int[] fixs = fixArray();

        if (isWinningSixBallValidation(fixs.length)) {
            throw new IllegalArgumentException(String.format("당첨 번호는 총 %d개를 입력해주셔야 합니다.", SixBall.LENGTH));
        }

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

    private int bonus() throws Exception {
        try {
            return Integer.parseInt((String) input.request("보너스 볼을 입력해 주세요."));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 볼은 숫자만 가능합니다.");
        }
    }

    private boolean isWinningSixBallValidation(int length) {
        return length < SixBall.LENGTH;
    }

}
