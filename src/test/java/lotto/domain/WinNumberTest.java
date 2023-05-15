package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinNumberTest {

    private WinNumber winNumber;

    @BeforeEach
    public void setUp() {
        winNumber = new WinNumber(Lotto.of(Arrays.asList(1,2,3,4,5,6)), new LottoNumber(45));
    }

    @DisplayName("로또번호중에 맞은 갯수를 구할 수 있다.")
    @Test
    public void distinguish_CountNumber_Correct() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertThat(winNumber.distinguish(lotto)).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 있는지 가릴 수 있다.")
    @Test
    public void haveBonus_CountBonus_Correct() {
        Lotto lotto = Lotto.of(Arrays.asList(11,12,13,14,15,45));
        Assertions.assertThat(winNumber.haveBonus(lotto)).isTrue();
    }
}
