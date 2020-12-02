package my.project.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-27 오전 9:55
 * Developer : Seo
 */
class LottoTest {
    List<LottoNumber> lottoNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoNumbers.add(LottoNumber.valueOf(1));
        lottoNumbers.add(LottoNumber.valueOf(2));
        lottoNumbers.add(LottoNumber.valueOf(3));
        lottoNumbers.add(LottoNumber.valueOf(4));
        lottoNumbers.add(LottoNumber.valueOf(5));
    }

    @DisplayName("정상")
    @Test
    void testConstructor() {
        lottoNumbers.add(LottoNumber.valueOf(6));
        assertThat(new Lotto(lottoNumbers)).isNotNull();
    }

    @DisplayName("6개 번호")
    @Test
    void shouldHaveParamSixDigit_OtherwiseThrowException() {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 방지")
    @Test
    void shouldNotBeDuplicated() {
        lottoNumbers.add(LottoNumber.valueOf(5));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testContains() {
        lottoNumbers.add(LottoNumber.valueOf(6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.contains(LottoNumber.valueOf(7))).isFalse();
    }

    @Test
    void testContainsCount() {
        lottoNumbers.add(LottoNumber.valueOf(6));
        Lotto lotto = new Lotto(lottoNumbers);

        List<LottoNumber> lastWinningNumber = new ArrayList<>();
        lastWinningNumber.add(LottoNumber.valueOf(1));
        lastWinningNumber.add(LottoNumber.valueOf(2));
        lastWinningNumber.add(LottoNumber.valueOf(3));
        lastWinningNumber.add(LottoNumber.valueOf(4));
        lastWinningNumber.add(LottoNumber.valueOf(5));
        lastWinningNumber.add(LottoNumber.valueOf(6));
        Lotto winningLotto = new Lotto(lastWinningNumber);

        assertThat(lotto.count(winningLotto)).isEqualTo(6);
    }

    @Test
    void testToNumbers() {
        lottoNumbers.add(LottoNumber.valueOf(6));
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.toNumbers()).isEqualTo("[ 1, 2, 3, 4, 5, 6 ]");
    }

}