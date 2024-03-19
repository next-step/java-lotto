package lotto.domain;

import lotto.data.LottoWinInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.ConstUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @DisplayName("생성자를 넣지 않으면, 로또 번호를 자동으로 생성 해 준다.")
    @Test
    void selectAutoNumberOfLotto() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers();

        // then
        lottoNumbers.getPurchasedLottoNumber()
                .forEach(number -> assertThat(number.getLottoNumber()).isBetween(MINIMUM_LOTTO_RANGE, MAXIMUM_LOTTO_RANGE));
    }

    @DisplayName("생성자를 넣으면, 로또 번호를 수기로 생성 해 준다.")
    @Test
    void selectManualNumberOfLotto() {
        // given
        List<Integer> manualNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(manualNumbers);

        // then
        LottoWinInfo lottoWinInfo = lottoNumbers.countMatchWithWinningLottoNumbers(new LottoNumbers(manualNumbers));
        assertThat(lottoWinInfo).isEqualTo(LottoWinInfo.WIN_FIRST);
    }

    @DisplayName("로또 번호가 1~45가 아닐 경우, IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenLottoNumbersAreOutOfRange() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(List.of(55, 1, 2, 3, 4, 5)));
    }

    @DisplayName("로또 번호는 6자로만 생성이 가능하다. 6자가 아니라면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenNotSizeSix() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(List.of(55, 1, 2, 3, 4)));
    }

    @DisplayName("두 로또 번호를 비교하여, 몇개가 매칭되는지 알 수 있다.")
    @Test
    void canKnowHowManyMatchedBetweenTwoLottoNumbers() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 7, 8, 9));

        // when
        LottoWinInfo lottoWinInfo = lottoNumbers.countMatchWithWinningLottoNumbers(winningNumbers);

        // then
        assertThat(lottoWinInfo).isEqualTo(LottoWinInfo.WIN_FOURTH);
    }
}
