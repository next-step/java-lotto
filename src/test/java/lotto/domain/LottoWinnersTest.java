package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnersTest
{

    @Test
    @DisplayName("1등에 당첨된 로또인지 확인한다.")
    void createLottoListTest() {

        //given
        Lotto weekendLotto = Lotto.from(Sets.set(1,2,3,4,5,6));
        List<Lotto> lottoList = List.of(weekendLotto);
        //when
        LottoWinners lottoWinners = LottoWinners.of(lottoList, weekendLotto);
        //then
        assertThat(lottoWinners.getTotalPrize()).isEqualTo(2000000000);
        assertThat(lottoWinners.getLottoPlaceCount(6)).isEqualTo(1);
    }
}
