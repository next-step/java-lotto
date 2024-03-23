package lotto.domain;

import lotto.data.LottoWinInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("생성자를 넣으면, 로또 번호를 수기로 생성 해 준다.")
    @Test
    void selectManualNumberOfLotto() {
        // given
        List<Integer> manualNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lottoNumbers = new Lotto(manualNumbers);

        // then
        LottoWinInfo lottoWinInfo = lottoNumbers.countMatch(new Lotto(manualNumbers));
        assertThat(lottoWinInfo).isEqualTo(LottoWinInfo.WIN_FIRST);
    }

    @DisplayName("로또 번호는 정확히 6개 아니면, IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenNotExactlySix() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3)));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @DisplayName("로또 번호가 1~45가 아닐 경우, IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenLottoNumbersAreOutOfRange() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(55, 1, 2, 3, 4, 5)));
    }

    @DisplayName("로또 번호는 6자로만 생성이 가능하다. 6자가 아니라면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenNotSizeSix() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(55, 1, 2, 3, 4)));
    }

    @DisplayName("중복된 값이 입력되면, IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenNumberDuplicate() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 1, 2, 2, 3)));
    }

    @DisplayName("두 로또 번호를 비교하여, 몇개가 매칭되는지 알 수 있다.")
    @Test
    void canKnowHowManyMatchedBetweenTwoLottoNumbers() {
        // given
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // when
        LottoWinInfo lottoWinInfo = lottoNumbers.countMatch(winningNumbers);

        // then
        assertThat(lottoWinInfo).isEqualTo(LottoWinInfo.WIN_FOURTH);
    }
}
