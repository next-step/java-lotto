package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 일치하는_로또넘버_개수_test() {

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningList = new ArrayList<>(Arrays.asList(2, 3, 4, 7, 8, 9));
        Lotto lotto = new Lotto(intList);

        lotto.getOverlappingLottoNum(new Lotto(winningList));
        assertThat(lotto.isWinningNumberEqual(3)).isTrue();
    }
}
