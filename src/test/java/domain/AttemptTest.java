package domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static domain.LottoNo.generateLottoNos;
import static domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AttemptTest {

    private Attempt attempt;

    @Test
    public void 로또번호_추출_45이하_6개() {
        attempt = new Attempt(new RandomNumberGenerator());

        List<LottoNo> numbers = attempt.getLottoNos();
        assertThat(numbers).hasSize(6);

        for (LottoNo number : numbers) {
            assertThat(number.getNumber()).isBetween(0,45);
        }
    }

    @Test
    public void 로또담첨_확인() {
        //when
        TestNumberGenerator generator = new TestNumberGenerator();
        List<LottoNo> attemptNumbers = generateLottoNos(Arrays.asList( 1, 2, 3, 4, 5, 6));
        generator.setRandomNumber(attemptNumbers);
        attempt = new Attempt(generator);

        List<LottoNo> winnerNumbers = generateLottoNos(Arrays.asList(4 ,5 ,6));

        //given
        Integer matchCount = attempt.calculateMatchCount(winnerNumbers);

        //then
        Assertions.assertThat(matchCount).isEqualTo(3);
    }

    @Test
    public void 숫자_다섯개와_보너스번호가_일치하면_2등() {
        //when
        TestNumberGenerator generator = new TestNumberGenerator();
        List<LottoNo> attemptNumbers = generateLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6));
        generator.setRandomNumber(attemptNumbers);
        attempt = new Attempt(generator);

        List<LottoNo> winnerNumbers = generateLottoNos(Arrays.asList(1, 2, 3, 4, 5));
        int bounusNumber = 6;

        //given
        attempt.calculateRank(winnerNumbers, bounusNumber);

        //then
        Assertions.assertThat(attempt.getRank())
                .isEqualTo(SECOND);
    }

    @Test
    public void 숫자_다섯개_일치하면_3등() {
        //when
        TestNumberGenerator generator = new TestNumberGenerator();
        List<LottoNo> attemptNumbers = generateLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6));
        generator.setRandomNumber(attemptNumbers);
        attempt = new Attempt(generator);

        List<LottoNo> winnerNumbers = generateLottoNos(Arrays.asList(1, 2, 3, 4, 5));
        int bounusNumber = 7;

        //given
        attempt.calculateRank(winnerNumbers, bounusNumber);

        //then
        Assertions.assertThat(attempt.getRank())
                .isEqualTo(THIRD);
    }
}
