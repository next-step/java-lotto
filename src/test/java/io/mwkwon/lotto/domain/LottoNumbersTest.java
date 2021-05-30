package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    void create() {
        List<LottoNumber> lottoNumber = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6)
        );

        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber);
        assertThat(lottoNumbers).isEqualTo(LottoNumbers.create(lottoNumber));

    }

    @Test
    void 로또_객체_생성_테스트() {
        List<LottoNumber> lottoNumber = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6)
        );

        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber);
        assertThat(lottoNumbers.createLotto()).isEqualTo(Lotto.create(lottoNumber));
    }
}
