package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatics;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    /**
     * Lotto class test
     */
    @Test
    void checkMatchingNumbersTest() {
        String input = "1, 2, 3, 4, 5, 6";
        List<String> winningNumbers = LottoFactory.getLastWeekWinningNumbers(input);
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(7),
                new LottoNumber(9),
                new LottoNumber(11)
        );
        Lotto lotto = new Lotto(0, lottoNumbers);

        lotto.checkMatchingNumbers(winningNumbers);

        assertThat(lotto.getMatchCnt()).isEqualTo(3);
    }

    /**
     * LottoGenerator class Test
     */
    @Test
    void createLottoNumberTest() {
        assertThat(LottoGenerator.generateLottoNumber().size()).isEqualTo(6);
    }

    /**
     * LottoStatics class Test
     */
    @Test
    void setLottoStaticsTest() {
        LottoStatics.setLottoStatics(3L);
        assertThat(LottoStatics.THREE.getCount()).isEqualTo(1);
    }

    @Test
    void getWinningPrizeTest() {
        LottoStatics.setLottoStatics(4L);
        assertThat(LottoStatics.getWinningPrize()).isEqualTo(50000);
    }
}
