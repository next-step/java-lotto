package lotto.domain;

import lotto.enumerate.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private final int loseNumber = -1;
    private final int bonusNumber = 0;

    @Test
    @DisplayName("로또 당첨 결과가 제대로 저장되는지 테스트")
    void saveResultTest() {
        LottoNumbersWrapper collectNumberList = new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = getTestLotts();

        Result result = new Result(new LottoWrapper(lottos), collectNumberList, loseNumber);

        for (Rank rank : Rank.values()) {
            assertThat(result.getWinCount(rank)).isEqualTo(1);
        }
    }

    private List<Lotto> getTestLotts() {
        Lotto lotto1 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, bonusNumber)));
        Lotto lotto3 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, 5, loseNumber)));
        Lotto lotto4 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, 4, loseNumber, loseNumber)));
        Lotto lotto5 = new Lotto(new LottoNumbersWrapper(Arrays.asList(1, 2, 3, loseNumber, loseNumber, loseNumber)));
        return Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);
    }

}