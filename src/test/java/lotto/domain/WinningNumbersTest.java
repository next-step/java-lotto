package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    WinningNumbers winningLottoNumbers;

    @BeforeEach
    void beforeEach() {
        TreeSet<LottoNumber> winningNumberTreeSet = new TreeSet<>();
        winningNumberTreeSet.add(new LottoNumber(1));
        winningNumberTreeSet.add(new LottoNumber(2));
        winningNumberTreeSet.add(new LottoNumber(3));
        winningNumberTreeSet.add(new LottoNumber(4));
        winningNumberTreeSet.add(new LottoNumber(5));
        winningNumberTreeSet.add(new LottoNumber(6));

        winningLottoNumbers = new WinningNumbers(winningNumberTreeSet);
    }

    @Test
    @DisplayName("로또 번호가 당첨번호이면 true 반환한다.")
    void isWinning() {
        assertThat(winningLottoNumbers.isWinningNumber(new LottoNumber(1))).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 당첨번호가 아니면 false 반환한다.")
    void isNotWinning() {
        int[] winningNumber = {1,2,3,4,5,6};
        TreeSet<LottoNumber> winningNumberTreeSet = new TreeSet<>();
        for (int number : winningNumber) {
            winningNumberTreeSet.add(new LottoNumber(number));
        }

        assertThat(winningLottoNumbers.isWinningNumber(new LottoNumber(7))).isFalse();
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐경우 InvalidLottoNumberCount 를 반환한다.")
    void InvalidNumberException() {
        TreeSet<LottoNumber> lottoNumberTreeSet = new TreeSet<>();
        lottoNumberTreeSet.add(new LottoNumber(1));

        assertThatThrownBy(() -> new WinningNumbers(lottoNumberTreeSet)).isInstanceOf(InvalidLottoNumberCount.class);
    }

}