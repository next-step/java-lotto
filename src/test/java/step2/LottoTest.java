package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.Lotto.LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE;
import static step2.Lotto.LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE;

public class LottoTest {

    @Test
    @DisplayName("로또번호를 통해 Lotto 객체 생성시, 중복된 숫자는 없는지 검증한다.")
    void assertNumbers_duplicate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(3));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).withMessage(LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("로또번호를 통해 Lotto 객체 생성시, 숫자 개수가 6개인지 검증한다.")
    void assertNumbers_count() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).withMessage(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
    }
}
