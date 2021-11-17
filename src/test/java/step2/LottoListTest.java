package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoList;
import step2.domain.starategy.RandomGetLottoImpl;
import step2.view.Input;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottoListTest {
    @Test
    void checkMatchingTest() {
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 7, 8, 9);
        LottoList lottoList = new LottoList(7000, () -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoList.checkMatching(winningNumber)).isEqualTo(Arrays.asList(0, 0, 0, 7, 0, 0, 0));
    }

}
