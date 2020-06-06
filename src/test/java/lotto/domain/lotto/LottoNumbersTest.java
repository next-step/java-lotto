package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    void 여섯자리_로또번호를_생성한다() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.getLottoNumbers()).size().isEqualTo(6);
    }

    @Test
    void 매번_다른번호를_생성한다() {
        LottoNumbers firstLottoNumber = new LottoNumbers();
        LottoNumbers secondLottoNumber = new LottoNumbers();

        //일치하는 값 비교
        assertThat(Arrays.asList(1, 2, 3, 4)).isEqualTo(Arrays.asList(1, 2, 3, 4));

        assertThat(firstLottoNumber.getLottoNumbers())
                .isNotEqualTo(secondLottoNumber.getLottoNumbers());
    }

    @Test
    void 로또번호가_중복없이_6자리인지_확인한다() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers.getLottoNumbers());

        assertThat(lottoNumberSet).size().isEqualTo(6);

    }

}