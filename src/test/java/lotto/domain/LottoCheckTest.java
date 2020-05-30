package lotto.domain;

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
    private static final int INDEX_RANK_5 = 4;
    private static final int INDEX_BOOM = 5;

    @DisplayName("구매한 로또 중에 각 등수에 해당하는 로또 당첨 수 리턴한다.")
    @Test
    public void getWinningLottoCountTest() {
        int bonus = 7;
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", bonus);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(1,2,3,4,5,8)),
                new Lotto(List.of(1,2,3,9,10,8)),
                new Lotto(List.of(7,8,9,12,10,11)),
                new Lotto(List.of(1,10,3,9,5,8)),
                new Lotto(List.of(1,2,3,4,5,7)));
        final int[] count = new int[6];

        count[INDEX_RANK_1] = LottoCheck.getWinningLottoCount(lottos, winningLotto, RANK1);
        count[INDEX_RANK_2] = LottoCheck.getWinningLottoCount(lottos, winningLotto, RANK2);
        count[INDEX_RANK_3] = LottoCheck.getWinningLottoCount(lottos, winningLotto, RANK3);
        count[INDEX_RANK_4] = LottoCheck.getWinningLottoCount(lottos, winningLotto, RANK4);
        count[INDEX_RANK_5] = LottoCheck.getWinningLottoCount(lottos, winningLotto, RANK5);
        count[INDEX_BOOM] = LottoCheck.getWinningLottoCount(lottos, winningLotto, BOOM);

        assertAll(
            () -> assertThat(count[INDEX_RANK_1]).isEqualTo(0),
            () -> assertThat(count[INDEX_RANK_2]).isEqualTo(1),
            () -> assertThat(count[INDEX_RANK_3]).isEqualTo(1),
            () -> assertThat(count[INDEX_RANK_4]).isEqualTo(0),
            () -> assertThat(count[INDEX_RANK_5]).isEqualTo(2),
            () -> assertThat(count[INDEX_BOOM]).isEqualTo(1)
        );
    }

    @DisplayName("총 당첨금액을 리턴한다.")
    @Test
    public void getWinningAmountTest() {
        int bonus = 7;
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", bonus);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(1,2,3,4,5,8)), // 5개 일치 15
                new Lotto(List.of(1,2,3,9,10,8)), // 3개 5000
                new Lotto(List.of(7,8,9,12,10,11)), // 0개
                new Lotto(List.of(1,10,3,9,5,8)), //3
                new Lotto(List.of(1,2,3,4,5,7))); // 5 개 보너스

        BigDecimal expectedAmount = BigDecimal.valueOf(2 * 5000)
                .add(BigDecimal.valueOf(1500000))
                .add(BigDecimal.valueOf(30000000));
        BigDecimal actualAmount = LottoCheck.getTotalWinningAmount(lottos, winningLotto);

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

}
