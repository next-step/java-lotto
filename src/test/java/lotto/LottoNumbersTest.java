package lotto;

import lotto.domain.BonusBall;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {


    @Test
    public void 당첨번호_일치개수별_랭크테스트() {
        final int EXPECTED_RANK = 5;
        int bonusNumber = 10;
        BonusBall bonusBall = new BonusBall(bonusNumber);
        List<LottoNumber> numberList = IntStream.range(4, 10)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        List<LottoNumber> testNumberList = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottoWinningNumbers = new LottoNumbers(testNumberList);
        assertThat(lottoWinningNumbers.lottoRank(numberList, bonusBall.checkMatching(numberList))).isEqualTo(EXPECTED_RANK);
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
