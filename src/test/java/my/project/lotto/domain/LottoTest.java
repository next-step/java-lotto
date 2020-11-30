package my.project.lotto.domain;

import my.project.lotto.dto.LottoNumber;
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
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
    }

    @DisplayName("정상")
    @Test
    void testConstructor() {
        lottoNumbers.add(new LottoNumber(6));
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
        lottoNumbers.add(new LottoNumber(5));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testContains() {
        lottoNumbers.add(new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.contains(new LottoNumber(7))).isFalse();
    }

    @Test
    void testContainsCount() {
        lottoNumbers.add(new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);

        List<LottoNumber> lastWinningNumber = new ArrayList<>();
        lastWinningNumber.add(new LottoNumber(1));
        lastWinningNumber.add(new LottoNumber(2));
        lastWinningNumber.add(new LottoNumber(3));
        lastWinningNumber.add(new LottoNumber(4));
        lastWinningNumber.add(new LottoNumber(5));
        lastWinningNumber.add(new LottoNumber(6));
        Lotto winningLotto = new Lotto(lastWinningNumber);

        assertThat(lotto.count(winningLotto)).isEqualTo(6);
    }

    @Test
    void testToNumbers() {
        lottoNumbers.add(new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.toNumbers()).isEqualTo("[ 1, 2, 3, 4, 5, 6 ]");
    }

}