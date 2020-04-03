package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusBall;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        bonusBall = LottoNumber.valueOf(7);
    }

    @DisplayName("당첨 번호 객체를 생성할 수 있다.")
    @Test
    void create() {
        WinningLotto expect = WinningLotto.of(lottoNumbers, bonusBall);

        WinningLotto actual = WinningLotto.of(new LottoNumbers("1, 2, 3, 4, 5, 7"), LottoNumber.valueOf(7));

        assertThat(actual).isEqualTo(expect);
    }
}