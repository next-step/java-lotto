package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    public static final Long THREE_PRICE = 5000L;
    public static final Long FOUR_PRICE = 50_000L;
    public static final Long FIVE_PRICE = 1_500_000L;
    public static final Long SIX_PRICE = 2_000_000_000L;

    @Test
    void winningPriceTest() {
        assertThat(Rank.matchRank(0).getWinningMoney()).isEqualTo(0L);
        assertThat(Rank.matchRank(1).getWinningMoney()).isEqualTo(0L);
        assertThat(Rank.matchRank(2).getWinningMoney()).isEqualTo(0L);
        assertThat(Rank.matchRank(3).getWinningMoney()).isEqualTo(THREE_PRICE);
        assertThat(Rank.matchRank(4).getWinningMoney()).isEqualTo(FOUR_PRICE);
        assertThat(Rank.matchRank(5).getWinningMoney()).isEqualTo(FIVE_PRICE);
        assertThat(Rank.matchRank(6).getWinningMoney()).isEqualTo(SIX_PRICE);
    }



    @Test
    void calculateTest() {
        //given
        int[] match = new int[]{0, 1, 2, 3, 4, 5, 6};
        Long expectMatch = 0 * 0 + 1 * 0 + 2 * 0
                + 3 * THREE_PRICE + 4 * FOUR_PRICE + 5 * FIVE_PRICE + 6 * SIX_PRICE;

        //when
        Long result = Rank.calculate(match);

        //then
        assertThat(result).isEqualTo(expectMatch);
    }
}
