package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    @DisplayName("같은 숫자의 로또 번호는 같은 로또 번호이다.")
    void createLottoNumbersTest() {
        LottoNumbers lottoNumbers = new LottoNumbers(Lists.list(1, 2, 3, 4, 5, 6));
        LottoNumbers otherLottoNumbers = new LottoNumbers(Lists.list(5, 4, 3, 2, 1, 6));

        assertThat(lottoNumbers).isEqualTo(otherLottoNumbers);
    }

    @Test
    @DisplayName("로또 숫자는 중복되면 안된다.")
    void distinctTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.valueOf(1, 2, 3, 4, 5, 5));
    }

    @Test
    @DisplayName("로또 숫자는 6 개 이어야 한디.")
    void sizeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.valueOf(1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.valueOf(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    @DisplayName("당첨 번호에 보너스 숫자가 포함되면 IllegalArgumentException 이 발생되어야 한다.")
    void rankExceptionTest() {
        LottoNumbers winningNums = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(5);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException().isThrownBy(() -> lottoNumbers.rank(winningNums, bonusNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "7, 4, 26, 25, 8, 1",
            "26, 24, 33, 1, 45, 27",
    })
    @DisplayName("일치하는 숫자가 3 미만이면 꽝이다")
    void missRankTest(String input) {
        LottoNumbers winningNums = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(input.split(", "));

        assertThat(lottoNumbers.rank(winningNums, bonusNumber)).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("숫자 3개 일치하면 5 등이다")
    void fifthRankTest() {
        LottoNumbers winningNums = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 7, 8, 9);

        assertThat(lottoNumbers.rank(winningNums, bonusNumber)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("숫자 4개 일치하면 4 등이다")
    void forthRankTest() {
        LottoNumbers winningNums = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 7, 8);

        assertThat(lottoNumbers.rank(winningNums, bonusNumber)).isEqualTo(LottoRank.FOURTH);
    }


    @Test
    @DisplayName("보너스 숫자 제외하고 숫자 5개 일치하면 3등이다.")
    void thirdRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(9);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 7);

        assertThat(lottoNumbers.rank(winningNumbers, bonusNumber)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("숫자 5개 일치하고 보너스 숫자 까지 일치하면 2등이다.")
    void secondRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 7);

        assertThat(lottoNumbers.rank(winningNumbers, bonusNumber)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("숫자 6개 일치하면 1등이다.")
    void firstRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.rank(winningNumbers, bonusNumber)).isEqualTo(LottoRank.FIRST);
    }

}
