package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private LottoResult result;
    private LottoGroup lottoGroup;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Map<LottoRank, Long> rankResult = new HashMap<>();
        rankResult.put(LottoRank.FIRST, 3L);
        rankResult.put(LottoRank.SECOND, 2L);
        rankResult.put(LottoRank.THIRD, 1L);
        rankResult.put(LottoRank.FOURTH, 4L);
        rankResult.put(LottoRank.FIFTH, 12L);
        rankResult.put(LottoRank.NONE, 15L);
        result = new LottoResult(rankResult);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 4, 8, 9))); // 4등
        lottos.add(Lotto.createManualLotto(List.of(1, 2, 3, 8, 9, 10))); // 5등
        lottos.add(Lotto.createManualLotto(List.of(21, 22, 23, 24, 25, 26))); // 등수없음
        lottoGroup = new LottoGroup(lottos);

        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    @DisplayName("총 상금 계산")
    void calculateTotalPrizeTest() {
        //when
        Money totalPrize = result.calculateTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(new Money(6_061_760_000L));
    }

    @Test
    @DisplayName("수익률 계산 기능 테스트")
    void calculateYield() {
        //when, then
        assertThat(result.calculateYield()).isEqualTo(163831.35135135136);
    }

    @Test
    @DisplayName("당첨 결과 반환 테스트.")
    void getResultTest() {
        //when
        LottoResult result = LottoResult.of(lottoGroup, winningLotto);

        //then
        assertThat(result.getResult()).containsEntry(LottoRank.FIFTH, 1L);
        assertThat(result.getResult()).containsEntry(LottoRank.FOURTH, 1L);
        assertThat(result.getResult()).containsEntry(LottoRank.THIRD, 1L);
        assertThat(result.getResult()).containsEntry(LottoRank.SECOND, 1L);
        assertThat(result.getResult()).containsEntry(LottoRank.FIRST, 1L);
    }
}