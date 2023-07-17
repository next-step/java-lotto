package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 볼이 중복되면 예외를 던진다.")
    void 당첨_번호_보너스볼_중복_예외() {
        assertThatCode(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 7))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 볼을 입력 받는다.")
    void 당첨_번호_보너스볼_생성() {
        assertThatCode(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호 비교")
    void 당첨_번호로_비교() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(createLottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        // when
        Rank rank = winningLotto.compare(lotto);
        // then
        assertThat(rank).isEqualTo(Rank.SIX);
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> container) {
        return container.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
