package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Match;
import step2.domain.WinningMoney;

public class WinningMoneyTest {

    @ParameterizedTest(name = "일치하는 수가 {0}개이고, 보너스볼 일치가 {1}이면 상금은 {2}원이다.")
    @CsvSource(value = {"3:false:5000", "4:false:50000", "5:false:1500000", "5:true:30000000",  "6:false:2000000000"},
            delimiter = ':')
    void 일치하는_수의_개수와_보너스_볼의_일치_여부에_따른_상금이_반환된다(int count, boolean isBonus, int result) {

        // given
        Match match = Match.from(count, isBonus);

        // when
        Integer winningMoney = WinningMoney.winningMoney(match);

        // then
        Assertions.assertThat(winningMoney).isEqualTo(result);
    }
}
