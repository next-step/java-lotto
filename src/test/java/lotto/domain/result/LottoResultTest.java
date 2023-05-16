package lotto.domain.result;

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
        Map<Rank, Integer> result = Map.of(Rank.FOURTH, 0);
        assertThat(LottoResult.of(Rank.FOURTH)).isEqualTo(new LottoResult(result));
    }

    @ParameterizedTest(name = "3개 숫자가 일치할 경우 당첨 횟수 카운트 검사")
    @CsvSource(value = {"3:1", "2:0", "1:0"}, delimiter = ':')
    void test2(int hit, int expect) {
        LottoResult lottoResult = LottoResult.of(Rank.FOURTH);
        lottoResult.win(Rank.valueOf(hit));
        assertThat(lottoResult.getValue()).isEqualTo(expect);
    }

}
