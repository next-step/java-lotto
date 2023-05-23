package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoValidatorTest {


    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void setup() {
        lottoNumbers = new HashSet<>();
        lottoNumbers.add(LottoNumber.valueOf(1));
        lottoNumbers.add(LottoNumber.valueOf(2));
        lottoNumbers.add(LottoNumber.valueOf(3));
        lottoNumbers.add(LottoNumber.valueOf(4));
        lottoNumbers.add(LottoNumber.valueOf(5));
        lottoNumbers.add(LottoNumber.valueOf(6));
    }

    @Test
    void null로_생성시_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.validLottoNumbers(null));
    }

    @Test
    void 로또_번호_6개_초과시_IllegalArgumentException() {
        lottoNumbers.add(LottoNumber.valueOf(7));
        assertThat(lottoNumbers).hasSize(7);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.validLottoNumbers(lottoNumbers));
    }

    @Test
    void 로또_번호_6개_미만시_IllegalArgumentException() {
        lottoNumbers.remove(LottoNumber.valueOf(1));
        assertThat(lottoNumbers).hasSize(5);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoValidator.validLottoNumbers(lottoNumbers));
    }
}
