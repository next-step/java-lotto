package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottosTest {

    @Test
    @DisplayName("로또1과 로또2를 합칠 수 있다.")
    void lottos_addAll() {
        Lottos lotto1 = LottoMachine.issueManualLottos(List.of("1, 2, 3, 4, 5, 6", "8, 21, 23, 41, 42, 43"));
        Lottos lotto2 = LottoMachine.issueManualLottos(List.of("7, 11, 16, 35, 36, 44"));

        Lottos lottos = new Lottos(lotto1, lotto2);

        assertThat(lottos.getLottos()).hasSize(3)
                .containsAnyElementsOf(lotto1.getLottos())
                .containsAnyElementsOf(lotto2.getLottos());
    }

    @Test
    @DisplayName("맞춘 번호 개수에 맞는 Rank의 카운트를 반환한다.")
    void winning_result() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 30),
                new Lotto(1, 2, 3, 4, 5, 23),
                new Lotto(1, 2, 3, 4, 21, 23),
                new Lotto(1, 2, 3, 20, 21, 23)
        ));

        Map<Rank, Integer> result = lottos.calculateWinningResult(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(30));

        assertAll(
                () -> assertThat(result.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(result.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(result.get(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(result.get(Rank.FOURTH)).isEqualTo(1),
                () -> assertThat(result.get(Rank.FIFTH)).isEqualTo(1),
                () -> assertThat(result.containsKey(Rank.ZERO)).isFalse()
        );
    }
}
