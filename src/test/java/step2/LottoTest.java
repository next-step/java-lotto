package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.Lotto.LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE;

public class LottoTest {

    @Test
    @DisplayName("로또번호를 통해 Lotto 객체 생성시, 맞는 개수가 입력되었는지 검증한다.")
    void assertNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).withMessage(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
    }
}
