package step2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final Lotto lotto = new Lotto(randomNumberGenerator);
    private final List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

    @Test
    public void 로또_번호는_6개_이다() {
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Nested
    class 로또_번호는_중복이_없다 {

        @RepeatedTest(10000)
        public void 로또_번호_중복_테스트() {
            Lotto lottoTest = new Lotto(randomNumberGenerator);
            List<LottoNumber> lottoTestNumbers = lottoTest.getLottoNumbers();
            Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoTestNumbers);
            assertThat(lottoNumberSet.size()).isEqualTo(6);
        }
    }
}
