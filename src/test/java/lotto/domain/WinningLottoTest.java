package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class WinningLottoTest {
    private Lotto lotto;
    private LottoNumber bonusNumber;
    @BeforeEach
    void setUp() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(new LottoNumber(i));
        }

        lotto = new Lotto(new LottoManualGenerator(numbers).generateNumbers());
        bonusNumber = new LottoNumber(5);
    }

    @DisplayName("당첨 로또의 등수를 구할 수 있다.")
    @Test
    void testLottoNumberMatch() {

        WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(7));
        assertThat(Prize.FIRST).isSameAs(winningLotto.match(lotto));
    }

    @DisplayName("당첨번호와 보너스번호는 중복될 수 없다.")
    @Test
    void testBonusNumberValid() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningLotto(lotto, bonusNumber));
    }
}
