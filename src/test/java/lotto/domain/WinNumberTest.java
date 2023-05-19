package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.Rank;
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
        winNumber = new WinNumber(new Lotto(Arrays.asList(1,2,3,4,5,6)), LottoNumber.of(45));
    }

    @DisplayName("로또번호중에 맞은 갯수를 구할 수 있다.")
    @Test
    public void distinguish_CountNumber_Correct() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertThat(winNumber.matchRank(lotto)).isEqualTo(Rank.FIRST);
    }
}
