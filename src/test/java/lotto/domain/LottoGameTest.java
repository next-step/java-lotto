package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGameTest {

    Lotto winningLotto;
    LottoNumber bonusNumber;

    @BeforeEach
    public void setup() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        winningLotto = Lotto.of(lottoNumbers);
        bonusNumber = LottoNumber.of(7);
    }

    @DisplayName("로또 자동 생성")
    @Test
    void autoGenerate() {
        Lotto lotto = LottoGame.autoGenerate();
        assertThat(lotto).isNotNull();
    }

    @DisplayName("금액에 맞게 로또 구매")
    @ParameterizedTest
    @CsvSource({"1000, 1", "2000, 2", "3000, 3"})
    void buy(long money, int expectedSize) {
        List<Lotto> lottos = LottoGame.buy(money);
        assertThat(lottos.size()).isEqualTo(expectedSize);
    }

    @DisplayName("천원미만 구매 불가 에러")
    @Test
    void cantBuy() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoGame.buy(900));
    }

    @DisplayName("1등")
    @Test
    void match1st() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        Lotto lotto = Lotto.of(lottoNumbers);
        assertThat(LottoGame.match(lotto, winningLotto, bonusNumber)).isEqualTo(1);
    }

    @DisplayName("2등")
    @Test
    void match2nd() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7)
        );
        Lotto lotto = Lotto.of(lottoNumbers);
        assertThat(LottoGame.match(lotto, winningLotto, bonusNumber)).isEqualTo(2);
    }

    @DisplayName("3등")
    @Test
    void match3rd() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(8)
        );
        Lotto lotto = Lotto.of(lottoNumbers);
        assertThat(LottoGame.match(lotto, winningLotto, bonusNumber)).isEqualTo(3);
    }

    @DisplayName("4등")
    @Test
    void match4() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(9),
                LottoNumber.of(10)
        );
        Lotto lotto = Lotto.of(lottoNumbers);
        assertThat(LottoGame.match(lotto, winningLotto, bonusNumber)).isEqualTo(4);
    }

    @DisplayName("5등")
    @Test
    void match5th() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(9),
                LottoNumber.of(10),
                LottoNumber.of(11)
        );
        Lotto lotto = Lotto.of(lottoNumbers);
        assertThat(LottoGame.match(lotto, winningLotto, bonusNumber)).isEqualTo(5);
    }

    @DisplayName("꽝")
    @Test
    void match6th() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(9),
                LottoNumber.of(10),
                LottoNumber.of(11),
                LottoNumber.of(12)
        );
        Lotto lotto = Lotto.of(lottoNumbers);
        assertThat(LottoGame.match(lotto, winningLotto, bonusNumber)).isEqualTo(0);
    }

}