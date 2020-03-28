package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LotteryTest {

    @DisplayName("로또 복권은 6개의 숫자를 가진다.")
    @Test
    void LottoNumbers_Have_Six_Numbers() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.valueOf(1)
                , LottoNumber.valueOf(2)
                , LottoNumber.valueOf(3)
                , LottoNumber.valueOf(4)
                , LottoNumber.valueOf(5)
                , LottoNumber.valueOf(6)
        );
        Lottery expect = new Lottery(lottoNumbers);

        Lottery actual = new Lottery(lottoNumbers);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("로또 번호 갯수가 6개가 아니라면 예외를 발생한다.")
    @Test
    void checkLottoNumberSizeSix() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.valueOf(1)
                , LottoNumber.valueOf(2)
                , LottoNumber.valueOf(3)
                , LottoNumber.valueOf(4)
                , LottoNumber.valueOf(5)
                , LottoNumber.valueOf(6)
                , LottoNumber.valueOf(7)
        );

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                () -> new Lottery(lottoNumbers)
        );
    }
}