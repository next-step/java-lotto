package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @ParameterizedTest
    @CsvSource(value={"1,2,3,4,5,6:7:6:true","1,2,3,4,5,7:6:5:true","1,2,3,4,5,7:8:5:false"}, delimiter = ':') // 당첨로또:보너스번호:당첨갯수:보너스일치여부
    public void lottoTest(String winningLottoStr, int bonusNumber, int countOfMatch, boolean isBonusMatch){
        String[] lottoNumbers = new String[]{"1","2","3","4","5","6"};
        Lotto lotto = new Lotto(lottoNumbers);

        WinningLotto winningLotto = new WinningLotto(winningLottoStr.split(","), bonusNumber);

        assertThat(winningLotto.countWinningNumber(lotto)).isEqualTo(Rank.valueOf(Count.of(countOfMatch), isBonusMatch));
        assertThat(winningLotto.countWinningNumber(lotto).getCountOfMatch()).isEqualTo(Count.of(countOfMatch));
    }
}
