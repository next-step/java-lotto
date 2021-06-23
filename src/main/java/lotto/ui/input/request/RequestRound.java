package lotto.ui.input.request;

import lotto.core.round.Round;
import lotto.dto.WinningBallDTO;
import lotto.ui.input.Input;
import lotto.ui.output.Output;

public class RequestRound extends Request<Round> {
    private final WinningBallDTO winningBallDTO;

    public RequestRound(final Output output, final Input<String> input) {
        super(output, input);
        winningBallDTO = new WinningBallDTO();
    }

    @Override
    public Round input() {
        request(() -> winningBallDTO.setFixedBalls(input.request("지난 주 당첨 번호를 입력해 주세요.")));

        Round round = request(() -> {
            winningBallDTO.setBounsBall(input.request("보너스 볼을 입력해 주세요."));

            return winningBallDTO.toRound();
        });

        return round;
    }
}
