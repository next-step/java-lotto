package lotto;

import lotto.domain.BonusBall;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

//
    @ParameterizedTest
    @CsvSource(value = {"3,9,6,3","2,8,1,3","2,8,6,2","1,7,7,1","1,7,6,1"})
    public void 당첨번호_일치개수별_랭크테스트_보너스볼포함(int startNumber, int endNumber, int bonusNumber, int expectedRankNumber) {
        BonusBall bonusBall = new BonusBall(bonusNumber);

        List<LottoNumber> winnerNumberList = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        List<LottoNumber> numberList = IntStream.range(startNumber, endNumber)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottoWinningNumbers = new LottoNumbers(winnerNumberList);
        assertThat(lottoWinningNumbers.lottoRank(numberList, bonusBall)).isEqualTo(expectedRankNumber);
    }

    @Test
    public void 개수_6개_불일치_테스트() {
        final List<LottoNumber> testNumberList = IntStream.range(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumbers lottoWinningNumbers = new LottoNumbers(testNumberList);
        });
    }


}
