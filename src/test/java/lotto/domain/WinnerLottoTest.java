package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerLottoTest {

    @Test
    @DisplayName("당첨로또와 일치하는 개수를 찾아 당첨Type을 반환한다.")
    void findWinnerType() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(numbers), 7);

        List<Integer> buyLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Optional<WinnerType> winnerType = winnerLotto.findWinnerType(new Lotto(buyLottoNumbers));

        assertThat(winnerType.isPresent()).isTrue();
        assertThat(winnerType.get()).isEqualTo(WinnerType.SECOND);
    }

    @Test
    @DisplayName("로또 당첨번호와 보너스볼의 번호는 같을 수 없다.")
    void validateDuplicate() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> {
            new WinnerLotto(new Lotto(numbers), 6);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("lotto 당첨 번호와 보너스볼 번호는 같을 수 없습니다.");
    }
}
