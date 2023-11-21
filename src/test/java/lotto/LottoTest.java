package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 생성시 랜덤 숫자 6개를 추출한다.")
    @Test
    void lotto() {
        Lotto lotto = new Lotto(Lotto.createLotto());

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("WinningNumbers와 일치하는 갯수를 반환한다.")
    @Test
    void matchCountTest() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumbers winningNumbers = new WinningNumbers(WinningNumbers.createList("1, 2, 3, 7, 8, 9"));

        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3);
    }
}