package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;
import lotto.domain.WinningLottoNumbers;
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
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(Lists.list(1, 2, 3, 4, 5, 6));
        LottoNumbers otherLottoNumbers = LottoNumbers.valueOf(Lists.list(5, 4, 3, 2, 1, 6));

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

    @ParameterizedTest
    @ValueSource(strings = {
            "7, 4, 26, 25, 8, 1",
            "26, 24, 33, 1, 45, 27",
    })
    @DisplayName("일치하는 숫자가 3 미만이면 꽝이다")
    void missRankTest(String input) {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumbers, bonusNumber);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(input.split(", "));

        assertThat(lottoNumbers.rank(winningLottoNumbers)).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("숫자 3개 일치하면 5 등이다")
    void fifthRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumbers, bonusNumber);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 7, 8, 9);

        assertThat(lottoNumbers.rank(winningLottoNumbers)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("숫자 4개 일치하면 4 등이다")
    void forthRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumbers, bonusNumber);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 7, 8);

        assertThat(lottoNumbers.rank(winningLottoNumbers)).isEqualTo(LottoRank.FOURTH);
    }


    @Test
    @DisplayName("보너스 숫자 제외하고 숫자 5개 일치하면 3등이다.")
    void thirdRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(9);
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumbers, bonusNumber);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 7);

        assertThat(lottoNumbers.rank(winningLottoNumbers)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("숫자 5개 일치하고 보너스 숫자 까지 일치하면 2등이다.")
    void secondRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumbers, bonusNumber);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 7);

        assertThat(lottoNumbers.rank(winningLottoNumbers)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("숫자 6개 일치하면 1등이다.")
    void firstRankTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumbers, bonusNumber);
        LottoNumbers lottoNumbers = LottoNumbers.valueOf(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.rank(winningLottoNumbers)).isEqualTo(LottoRank.FIRST);
    }

}
