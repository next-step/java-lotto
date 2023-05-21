package lotto.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = LottoResult.of();
    }

    @Test
    @DisplayName(value = "로또 결과 초기 생성 검사")
    void test1() {
        // given
        LottoResult lottoResult = new LottoResult(Map.of(Rank.FIRST, Rank.FIRST.initialRank()
                , Rank.SECOND, Rank.SECOND.initialRank()
                , Rank.THIRD, Rank.THIRD.initialRank()
                , Rank.FOURTH, Rank.FOURTH.initialRank()
                , Rank.FIFTH, Rank.FIFTH.initialRank()
                , Rank.NO_RANK, Rank.NO_RANK.initialRank()));

        // then
        assertThat(this.lottoResult).isEqualTo(lottoResult);
    }

    @Test
    @DisplayName(value = "결과 랭크와 일치하는 랭크 개수 증가 검사")
    void test2() {
        // given
        lottoResult.plusWinOfCount(Rank.FOURTH);

        // then
        assertThat(lottoResult.getLottoResult().get(Rank.FOURTH)).isEqualTo(1);
    }

}
