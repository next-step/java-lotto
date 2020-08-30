package step2.domain.lottoResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @DisplayName("3개의 숫자 이상 일치 시 당첨 횟수가 잘 카운트 되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 :1", "5 :0", "1 :0", "2 :0"}, delimiter = ':')
    void win_Test(int hitNumber, boolean matchBonus, int expect) {
        LottoResult lotto_4st = LottoResult.of(WinNumber.FOURTH);

        lotto_4st.win(hitNumber, matchBonus);

        assertThat(lotto_4st.getWinCount()).isEqualTo(expect);
    }
}