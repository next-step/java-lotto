package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.vo.Money;
import lotto.domain.vo.Profit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6)); // 1등
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 7)); // 2등
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 8)); // 3등
        lottoNumbers.add(List.of(1, 2, 3, 4, 8, 9)); // 4등
        lottoNumbers.add(List.of(1, 2, 3, 8, 9, 10)); // 5등
        lottoNumbers.add(List.of(21, 22, 23, 24, 25, 26)); // 등수없음
        lottoGroup = LottoGroup.createRandomAndManualLottos(new Money(6000L), lottoNumbers);

        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    @DisplayName("수익률 계산 기능 테스트")
    void calculateProfit() {
        //when, then
        assertThat(result.calculateProfit()).isEqualTo(new Profit(163831.35135135136));
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