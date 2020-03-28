package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @DisplayName("로또 복권은 6개의 로또 번호를 가지도록 객체 생성을 할 수 있다.")
    @Test
    void create() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                LottoNumber.valueOf(1)
                , LottoNumber.valueOf(2)
                , LottoNumber.valueOf(3)
                , LottoNumber.valueOf(4)
                , LottoNumber.valueOf(5)
                , LottoNumber.valueOf(6)
        ));
        Lottery expect = new Lottery(lottoNumbers);

        Lottery actual = new Lottery(lottoNumbers);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("입력받은 당첨 번호 문자열을 Lottery 객체로 생성할 수 있다.")
    @Test
    void createFromInput() {
        final String input = "1, 2, 3, 4, 5, 6";
        Lottery expect = new Lottery(input);

        Lottery actual = new Lottery(input);

        assertThat(actual).isEqualTo(expect);
    }
}