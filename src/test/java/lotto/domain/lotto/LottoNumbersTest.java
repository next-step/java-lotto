package lotto.domain.lotto;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


class LottoNumbersTest {

    @Test
    void 생성_테스트() {
        assertThatCode(() -> LottoNumbers.create()).doesNotThrowAnyException();
        assertThatCode(() -> LottoNumbers.create(Arrays.asList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @Test
    void 여섯자리_로또번호를_생성한다() {
        LottoNumbers lottoNumbers = LottoNumbers.create();
        assertThat(lottoNumbers.getLottoNumbers()).size().isEqualTo(6);
    }

    @Test
    void 매번_다른번호를_생성한다() {
        LottoNumbers firstLottoNumber = LottoNumbers.create();
        LottoNumbers secondLottoNumber = LottoNumbers.create();

        assertThat(firstLottoNumber.getLottoNumbers())
                .isNotEqualTo(secondLottoNumber.getLottoNumbers());
    }

}