package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinNumberTest {

    private Lotto lotto;

    @BeforeEach
    public void setUp() {
        lotto = Lotto.of(5,10,15,20,25,30);
    }

    @DisplayName("번호 중에 당첨번호가 몇 개 있다는 것을 알 수 있다.")
    @Test
    public void distinguish_WinNumber_ExtractNumber() {
        Lotto winLotto = Lotto.of(1,2,3,4,5,6);
        WinNumber winNumber = new WinNumber(winLotto);
        int matchingCount = winNumber.distinguish(lotto);

        Assertions.assertThat(matchingCount).isEqualTo(1);
    }
}
