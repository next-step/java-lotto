package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("수익률 계산하기")
    void calculateRate() {
        // given
        EnumMap<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> winningResult.put(rank, 1));
        LottoResult lottoResult = new LottoResult(winningResult);

        // when
        BigDecimal result = lottoResult.calculateRate(BigDecimal.valueOf(6000));

        // then
        assertThat(result).isEqualTo(BigDecimal.valueOf(338592.50).setScale(2));

    }

    @Test
    @DisplayName("등수 인원 조회하기")
    void getRankCount() {
        // given
        EnumMap<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        winningResult.put(Rank.FIFTH, 10);
        winningResult.put(Rank.FIRST, 1);
        winningResult.put(Rank.FOURTH, 2);

        // when
        LottoResult lottoResult = new LottoResult(winningResult);

        // then
        Integer count = lottoResult.getRankCount(Rank.FOURTH);
        assertThat(count).isEqualTo(2);

    }
}