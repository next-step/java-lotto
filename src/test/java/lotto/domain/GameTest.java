package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import lotto.game.Game;
import lotto.view.InputView;

public class GameTest {

    @Test
    void 지난주_로또_번호는_쉼표를_구분지어_입력한다() {
        assertThatThrownBy(() -> {
            Game game = new Game();
            game.play(InputView.convertStringToList("1, 2, 3, 4, 5, 6, 10"));
        }).hasMessage("로또 번호는 6개여야 합니다.");

        assertThatThrownBy(() -> {
            Game game = new Game();
            game.play(InputView.convertStringToList("1. 2. 3. 4. 5"));
        }).hasMessage("For input string: \"1. 2. 3. 4. 5\"");

        assertThatThrownBy(() -> {
            Game game = new Game();
            game.play(InputView.convertStringToList("1, 2, 3, 4, 5, 46"));
        }).hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");

        assertThatCode(() -> {
            Game game = new Game();
            game.calculateLottoCount(1000);
            game.rollingLotto();
            game.play(InputView.convertStringToList("1, 2, 3, 4, 5, 6"));
        }).doesNotThrowAnyException();
    }

}
