package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void 생성() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 45);

        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(1, 45));
    }

    @Test
    void 로또_번호를_생성한다() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 45);
        List<Integer> lottoNumber = lottoNumbers.pickLottoNumber();

        assertThat(lottoNumber).hasSize(6);
    }
}
