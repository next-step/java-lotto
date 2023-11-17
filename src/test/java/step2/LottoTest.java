package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step2.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("로또번호가 없거나 비어있다면 예외를 발생시킨다.")
    void lottoValidateTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 없습니다.");
    }

    @Test
    @DisplayName("로또 숫자가 6개가 아닌경우 예외를 발생시킨다.")
    void lottoValidateOverSixTest() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개가 되어야 합니다.");
    }

    @Test
    @DisplayName("로또 당첨번호와 일치하는 숫자가 3개가 있다면 3을 리턴한다.")
    void lottoWinnerTest() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        int count = lotto.getLottoWinner(winNumbers);
        assertThat(count).isEqualTo(3);
    }
}
