package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottosTest {

    @DisplayName("로또가 여러개 생성된다.")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(Set.of(1, 2, 3, 4, 5, 6))
                )
        );
        assertThat(lottos.getLottos()).hasSize(2);
    }

    @DisplayName("로또가 생성 되지 않았을 경우 에러를 반환한다.")
    @Test
    void validateLottos() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lottos(null);
                });
    }

    @DisplayName("로또 정답이 입력되면 로또 결과를 반환한다.")
    @Test
    void getResult() {
        Lotto winningNumbers = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(Set.of(11, 2, 3, 4, 5, 6)),
                        new Lotto(Set.of(11, 12, 3, 4, 5, 6)),
                        new Lotto(Set.of(11, 12, 13, 4, 5, 6)),
                        new Lotto(Set.of(11, 12, 13, 14, 5, 6)),
                        new Lotto(Set.of(11, 12, 13, 14, 15, 6))
                )
        );

        LottoResult result = lottos.getResult(winningNumbers);
        List<Rank> ranks = result.getRanks();

        assertThat(ranks).isEqualTo(List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.NONE, Rank.NONE));
    }
}
