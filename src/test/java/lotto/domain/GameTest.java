package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import lotto.game.Game;
import lotto.view.InputView;

public class GameTest {

    private int bonusNumber = 7;

    @Test
    void 지난주_로또_번호는_쉼표를_구분지어_입력한다() {
        assertThatThrownBy(() -> {
            Game game = new Game(1000, 0);
            game.play(createFixture(Arrays.asList(1, 2, 3, 4, 5, 6, 10)), bonusNumber);
        }).hasMessage("로또 번호는 6개여야 합니다.");

        assertThatThrownBy(() -> {
            Game game = new Game(1000, 0);
            game.play(InputView.convertStringToList("1. 2. 3. 4. 5"), bonusNumber);
        }).hasMessage("For input string: \"1. 2. 3. 4. 5\"");

        assertThatThrownBy(() -> {
            Game game = new Game(1000, 0);
            game.play(createFixture(Arrays.asList(1, 2, 3, 4, 5, 46)), bonusNumber);
        }).hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");

        assertThatCode(() -> {
            Game game = new Game(1000, 0);
            game.generateLottos(new ArrayList<>());
            game.play(createFixture(Arrays.asList(1, 2, 3, 4, 5, 6)), bonusNumber);
        }).doesNotThrowAnyException();
    }

    public List<LottoNum> createFixture(List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNum::new)
            .collect(Collectors.toList());
    }
}
