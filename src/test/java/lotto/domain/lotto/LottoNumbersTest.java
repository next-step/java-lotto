package lotto.domain.lotto;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


class LottoNumbersTest {

    @Test
    void 생성_테스트() {
        List<LottoNumber> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(k -> LottoNumber.create(k)).collect(Collectors.toList());

        assertThatCode(() -> LottoNumbers.create()).doesNotThrowAnyException();
        assertThatCode(() -> LottoNumbers.create(lottoNumber)).doesNotThrowAnyException();
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