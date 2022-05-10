package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void 로또_6자리_번호_자동_생성() {
        final int LOTTO_COUNT = 6;

        List<LottoNumber> lottoNumbers = LottoFactory.createAutoLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_COUNT);
    }

}
