package lotto.domain.result;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName(value = "로또 결과 초기 생성 검사")
    void test1() {
        LottoResult of = LottoResult.of();
        LottoResult lottoResult = new LottoResult(Map.of(Rank.FIRST, Rank.FIRST.initialRank()
                , Rank.SECOND, Rank.SECOND.initialRank()
                , Rank.THIRD, Rank.THIRD.initialRank()
                , Rank.FOURTH, Rank.FOURTH.initialRank()
                , Rank.NO_RANK, Rank.NO_RANK.initialRank()));
        assertThat(of).isEqualTo(lottoResult);
    }

    @ParameterizedTest(name = "3개 숫자가 일치할 경우 당첨 횟수 카운트 검사")
    @CsvSource(value = {"3:1", "2:1", "1:1"}, delimiter = ':')
    void test2(int hit, int expect) {
        LottoResult lottoResult = LottoResult.of();
        Rank rank = Rank.valueOf(hit);
        lottoResult.win(rank);

        assertThat(lottoResult.getLottoResult().get(rank)).isEqualTo(expect);
    }

}
