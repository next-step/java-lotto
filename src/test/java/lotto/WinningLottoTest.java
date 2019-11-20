package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private List<LottoNo> numbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3),
                new LottoNo(4), new LottoNo(5), new LottoNo(6));
        lotto = new Lotto(numbers);
    }

    @Test
    void getCountWhenHitWinNumber() {
        int[] testLottos = new int[] {1,2,3,7,8,9};
        WinningLotto winningLotto = new WinningLotto(testLottos);
        assertThat(winningLotto.checkWinNumber(lotto)).isEqualTo(3);
    }

}
