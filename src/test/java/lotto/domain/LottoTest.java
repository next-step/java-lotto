package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setLotto() {
        lotto = new Lotto("1,2,3,4,6,7");
    }

    @Test
    @DisplayName("숫자, 문자 , 외 입력시 예외가 발생한다")
    void wrongInputException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto("1,2,3,4,5,`"))
                .withMessage("숫자, 공백 및 문자 , 만 사용 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("로또숫자가 6개가 아니면 예외가 발생한다")
    @ValueSource(strings={"1", "1,2", "1,2,3", "1,2,3,4", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void wrongSizeException(String lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers))
                .withMessage("로또 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복된 번호가 있으면 예외가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5,5"})
    void wrongNumberException(String lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumber))
                .withMessage("중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("로또번호에 많은 공백이 있어도 객체가 정상적으로 생성된다")
    void name() {
        Lotto lotto = new Lotto("1,   2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @ParameterizedTest
    @DisplayName("당첨번호를 기준으로 Rank 를 조회한다.")
    @CsvSource(value = {
            "1,2,10,11,12,13:MISS",
            "1,2,3,8,9,10:FIFTH",
            "1,2,3,4,5,9:FOURTH",
            "1,2,3,4,6,10:THIRD",
            "1,2,3,4,6,8:SECOND",
            "1,2,3,4,6,7:FIRST"
    }, delimiter = ':')
    void getRank(String lottoNumbers, Rank expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(this.lotto, LottoNumber.valueOf("8"));
        Rank rank = lotto.getRank(winningLotto);
        assertThat(rank).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("당첨번호를 기준으로 Rank 를 조회한다.")
    @CsvSource(value = {
            "1,2,10,11,12,13:2",
            "1,2,3,8,9,10:3",
            "1,2,3,4,5,9:4",
            "1,2,3,4,6,10:5",
            "1,2,3,4,6,8:5",
            "1,2,3,4,6,7:6"
    }, delimiter = ':')
    void matchCount(String lottoNumbers, int expected) {
        assertThat(new Lotto(lottoNumbers).matchCount(this.lotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 포함 여부를 true 리턴한다")
    @ValueSource(ints = {1,2,3,4,6,7})
    void containsTrue(int lottoNumber) {
        assertThat(lotto.contains(LottoNumber.valueOf(lottoNumber))).isTrue();
    }

    @ParameterizedTest
    @DisplayName("로또 번호 포함 여부를 false 리턴한다")
    @ValueSource(ints = {8,9,10,45})
    void containsFalse(int lottoNumber) {
        assertThat(lotto.contains(LottoNumber.valueOf(lottoNumber))).isFalse();
    }
}
