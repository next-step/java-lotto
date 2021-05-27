package lotto.ui.input.info.request;

import lotto.ui.input.GameInput;
import lotto.ui.input.exception.InputException;

public class WinningBonusRequest extends Request<Integer> {

    public WinningBonusRequest(GameInput input) {
        super(input);
    }

    @Override
    public Integer request() throws InputException {
        try {
            return Integer.parseInt(input.request("보너스 볼을 입력해 주세요."));
        } catch (NumberFormatException e) {
            throw new InputException("보너스 볼은 숫자만 가능합니다.");
        }
    }
}
