package lotto.domain;

import lotto.domain.strategy.ManualLottoGeneration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    private static LottoRank lottoRank;

    @BeforeEach
    void create() {
        Lotto lotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        Lotto winLotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 9)).generate());

        lottoRank = LottoRank.findMatchCount(lotto.matchCount(winLotto), lotto.contains(new LottoNumber(6)));
    }

    @Test
    @DisplayName("맞춘 숫자수와 보너스 점수 이용하여 로또 랭크 찾기")
    void 로또랭크_찾기() {
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 랭크에 맞는 상금과 맞춘 횟수 계산하여 리턴 확인")
    void 상금계산_확인() {
        assertThat(lottoRank.sumPrize(1)).isEqualTo(lottoRank.prize());
    }
}
