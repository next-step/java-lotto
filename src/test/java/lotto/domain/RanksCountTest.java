package lotto.domain;

import lotto.enums.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksCountTest {

    @Test
    @DisplayName("당첨된 로또 티켓의 당첨 금액들을 제공하면 총 당첨 금액이 나온다.")
    public void totalPrize() throws Exception {
        //when
        TotalPrize totalPrize = new TotalPrize(Arrays.asList(
                WinningRank.FIRST_PLACE.prize(),
                WinningRank.SECOND_PLACE.prize(),
                WinningRank.THIRD_PLACE.prize()
        ));

        //then
        assertThat(totalPrize.sum()).isEqualTo(
                WinningRank.FIRST_PLACE.prize().prize() +
                        WinningRank.SECOND_PLACE.prize().prize() +
                        WinningRank.THIRD_PLACE.prize().prize());
    }
}
