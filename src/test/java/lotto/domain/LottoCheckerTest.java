package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {

    @Test
    @DisplayName("내가 산 복권과 당첨 복권이 3개 일치")
    void countMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(List.of(1, 2, 3, 9, 10, 11));
        assertThat(new LottoChecker().countMatch(lotto, winning)).isEqualTo(3);
    }

    @Test
    void check() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 10, 11, 12)));
        lottos.add(new Lotto(List.of(1, 2, 11, 12, 13, 14)));

        assertThat(new LottoChecker().check(lottos, winning).get(3)).isEqualTo(1);

    }
}