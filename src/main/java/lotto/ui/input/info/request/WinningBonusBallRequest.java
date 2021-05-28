package lotto.ui.input.info.request;

import lotto.core.Ball;
import lotto.core.Machine;
import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;

public class WinningBonusBallRequest extends Request<Ball> {

    public WinningBonusBallRequest(GameInput input) {
        super(input);
    }

    @Override
    public Ball request() throws InputException {
        try {
            int bonus = Integer.parseInt(input.request("보너스 볼을 입력해 주세요."));
            return Machine.draw(bonus);
        } catch (NumberFormatException e) {
            throw new InputException("보너스 볼은 숫자만 가능합니다.");
        }
    }
}
