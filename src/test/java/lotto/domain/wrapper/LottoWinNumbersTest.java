package lotto.domain.wrapper;

import lotto.domain.LottoWinNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoWinNumbersTest {

    @Test
    void invalid_일반당첨번호와_보너스번호_중복입력_Test() {
        assertThatThrownBy(() ->
                new LottoWinNumbers("1,2,3,4,5,6", 6)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalid_일반당첨번호와_보너스번호_범위_Test() {
        assertThatThrownBy(() ->
                new LottoWinNumbers("1,2,3,4,5,6", 0)
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                new LottoWinNumbers("1,2,3,4,5,6", 46)
        ).isInstanceOf(IllegalArgumentException.class);

    }
    
}
