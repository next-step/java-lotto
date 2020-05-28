package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoCheckTest {
    private static final int INDEX_RANK_1 = 0;
    private static final int INDEX_RANK_2 = 1;
    private static final int INDEX_RANK_3 = 2;
    private static final int INDEX_RANK_4 = 3;
    private static final int INDEX_BOOM = 4;

    @DisplayName("구매한 로또 중에 각 등수에 해당하는 로또 당첨 수 리턴한다.")
    @Test
    public void getWinningLottoCountTest() {
        String winningNumber = "1,2,3,4,5,6";
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(1,2,3,4,5,8)),
                new Lotto(List.of(1,2,3,9,10,8)),
                new Lotto(List.of(7,8,9,12,10,11)),
                new Lotto(List.of(1,10,3,9,5,8)));
        LottoCheck lottoCheck = LottoCheck.newInstance(lottos, winningNumber);
        final int[] count = new int[5];

        count[INDEX_RANK_1] = lottoCheck.getWinningLottoCount(RANK1);
        count[INDEX_RANK_2] = lottoCheck.getWinningLottoCount(RANK2);
        count[INDEX_RANK_3] = lottoCheck.getWinningLottoCount(RANK3);
        count[INDEX_RANK_4] = lottoCheck.getWinningLottoCount(RANK4);
        count[INDEX_BOOM] = lottoCheck.getWinningLottoCount(BOOM);

        assertAll(
            () -> assertThat(count[INDEX_RANK_1]).isEqualTo(0),
            () -> assertThat(count[INDEX_RANK_2]).isEqualTo(1),
            () -> assertThat(count[INDEX_RANK_3]).isEqualTo(0),
            () -> assertThat(count[INDEX_RANK_4]).isEqualTo(2),
            () -> assertThat(count[INDEX_BOOM]).isEqualTo(1)
        );
    }

    @DisplayName("총 당첨금액을 리턴한다.")
    @Test
    public void getWinningAmountTest() {
        String winningNumber = "1,2,3,4,5,6";
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(1,2,3,4,5,8)),
                new Lotto(List.of(1,2,3,9,10,8)),
                new Lotto(List.of(7,8,9,12,10,11)),
                new Lotto(List.of(1,10,3,9,5,8)));

        LottoCheck lottoCheck =  LottoCheck.newInstance(lottos, winningNumber);
        BigDecimal expectedAmount = BigDecimal.valueOf(2 * 5000).add(BigDecimal.valueOf(1500000));
        BigDecimal actualAmount = lottoCheck.getWinningAmount();

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

}
