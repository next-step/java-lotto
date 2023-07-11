package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    private final List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 8, 9))); // 4등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 8, 9, 10))); // 5등
        lottos.add(Lotto.createSpecificLotto(List.of(21, 22, 23, 24, 25, 26))); // 등수없음
    }

    @Test
    @DisplayName("구입 금액에 따라 로또 구매 수량 테스트.")
    void createLottoGroupTest() {
        LottoGroup lottoGroup = LottoGroup.from(new Money(14000L));
        assertThat(lottoGroup.getLottos()).hasSize(14);
    }
}