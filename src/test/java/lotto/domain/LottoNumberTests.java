package lotto.domain;

import lotto.exception.LottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTests {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void createLottoNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(4);

        assertThat(lottoNumber).isEqualTo(4);
    }

    @DisplayName("로또 번호 생성시 로또 번호 생성 범위 넘었을 때 exception 테스트")
    @Test
    void createLottoNumberExceptionTest() {

        assertThatExceptionOfType(LottoNumberRangeException.class)
                .isThrownBy(() -> {
                    LottoNumber lottoNumber = new LottoNumber(46);
                }).withMessageMatching("로또 숫자는 1 ~ 45 사이의 숫자만 가능 합니다.");


    }
}
