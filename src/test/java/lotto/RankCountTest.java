package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RankCountTest {
    @Test
    void countMatchNumber() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 3, 5, 7, 9, 11), 13);
        System.out.println();
    }
}
