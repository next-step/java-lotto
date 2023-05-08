package lotto.domain.result;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @ParameterizedTest(name = "3개 숫자가 일치할 경우 당첨 횟수 카운트 검사")
    @CsvSource(value = {"3:1", "2:0", "1:0"}, delimiter = ':')
    void test1(int hit, int expect) {
        LottoResult lottoResult = LottoResult.of(Rank.FOURTH);
        lottoResult.win(hit);
        int numberOfWin = lottoResult.getNumberOfWin();
        assertThat(numberOfWin).isEqualTo(expect);
    }
}