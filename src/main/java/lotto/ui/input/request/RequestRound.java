package lotto.ui.input.request;

import lotto.core.round.Round;
import lotto.dto.WinningBallDTO;
import lotto.ui.input.Input;
import lotto.ui.output.Output;

public class RequestRound {
    private final Output output;
    private final Input<String> input;

    public RequestRound(final Output output, final Input<String> input) {
        this.output = output;
        this.input = input;
    }

    public Round input() {
        WinningBallDTO winningBallDTO;
        try {
            winningBallDTO = createRound();
        } catch (Exception e) {
            output.error(e.getMessage());
            return input();
        }

        return winningBallDTO.toRound();
    }

    private WinningBallDTO createRound() {
        WinningBallDTO winningBallDTO = new WinningBallDTO();

        winningBallDTO.setFixedBalls(input.request("지난 주 당첨 번호를 입력해 주세요."));
        winningBallDTO.setBounsBall(input.request("보너스 볼을 입력해 주세요."));

        return winningBallDTO;
    }
}
