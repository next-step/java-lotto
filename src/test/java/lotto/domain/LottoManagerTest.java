package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    private final List<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 8, 9))); // 4등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 8, 9, 10))); // 5등
        lottos.add(Lotto.createSpecificLotto(List.of(21, 22, 23, 24, 25, 26))); // 등수없음

        winningLotto = new WinningLotto(
            Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6)),
            new LottoNumber(7));
    }

    @Test
    @DisplayName("당첨 결과 반환 테스트.")
    void getResultTest() {
        //given
        LottoManager lottoManager = new LottoManager(lottos);

        //when
        Map<LottoRank, Long> result = lottoManager.getResult(winningLotto).getResult();

        //then
        assertThat(result).containsEntry(LottoRank.FIFTH, 1L);
        assertThat(result).containsEntry(LottoRank.FOURTH, 1L);
        assertThat(result).containsEntry(LottoRank.THIRD, 1L);
        assertThat(result).containsEntry(LottoRank.SECOND, 1L);
        assertThat(result).containsEntry(LottoRank.FIRST, 1L);
    }

    @Test
    @DisplayName("구입 금액에 따라 로또 구매 수량 테스트.")
    void createLottoManagerTest() {
        LottoManager manager = LottoManager.from(new Money(14000L));
        assertThat(manager.getLottos()).hasSize(14);
    }
}