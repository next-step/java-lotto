package lotto.domain;

import lotto.domain.game.Round;

import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-12-02.
 */
public class InputManualLotto {

    private final Round round;
    private final List<String> inputLottos;

    private InputManualLotto(Round round, List<String> inputLottos) {
        this.round = round;
        this.inputLottos = inputLottos;
    }

    public static InputManualLotto of(Round round, List<String> inputLottos) {
        return new InputManualLotto(round, inputLottos);
    }

    public int getRound() {
        return this.round.getRound();
    }

    public List<String> getInputLottos() {
        return this.inputLottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputManualLotto that = (InputManualLotto) o;
        return Objects.equals(round, that.round) &&
                Objects.equals(inputLottos, that.inputLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, inputLottos);
    }
}
