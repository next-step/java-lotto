package lotto.domain.user;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.Test;

class UserLottoTest {


    @Test
    void 로또_넘버가_6개를_넘으면_예외처리() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new UserLotto(lottoNumbers))
            .withMessage("[ERROR] 로또 넘버는 6개여야 합니다.");
    }

    @Test
    void 로또_넘버에_중복이_있으면_예외처리() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(4),
            new LottoNumber(5));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new UserLotto(lottoNumbers))
            .withMessage("[ERROR] 로또 넘버에 중복이 있습니다.");
    }
}
