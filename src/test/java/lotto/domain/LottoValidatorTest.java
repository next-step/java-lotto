package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoValidatorTest {


    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void setup() {
        lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
    }

    @Test
    void null로_생성시_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.validLottoNumbers(null));
    }

    @Test
    void 로또_번호_6개_초과시_IllegalArgumentException() {
        lottoNumbers.add(new LottoNumber(7));
        assertThat(lottoNumbers).hasSize(7);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.validLottoNumbers(lottoNumbers));
    }

    @Test
    void 로또_번호_6개_미만시_IllegalArgumentException() {
        lottoNumbers.remove(new LottoNumber(1));
        assertThat(lottoNumbers).hasSize(5);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.validLottoNumbers(lottoNumbers));
    }
}
