package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnersTest {

    private Lotto weekendLotto;
    private List<Lotto> lottoList;
    private LottoNumber bonusNumber;

    @BeforeEach
    void setUp() {

        weekendLotto = Lotto.from(Sets.set(1,2,3,4,5,6));
        lottoList = List.of(weekendLotto, Lotto.from(Set.of(1,2,3,4,5,13)));
        bonusNumber = LottoNumber.from(13);
    }

    @Test
    @DisplayName("1등에 당첨된 로또가 있는지 확인한다.")
    void createFirstLottoListTest() {

        //when
        LottoWinners lottoWinners = LottoWinners.of(lottoList, weekendLotto, bonusNumber);
        //then
        assertThat(lottoWinners.getWinnerValue(LottoPlace.FIRST_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등에 당첨된 로또가 있는지 확인한다.")
    void createSecondLottoListTest() {

        //when
        LottoWinners lottoWinners = LottoWinners.of(lottoList, weekendLotto, bonusNumber);
        //then
        assertThat(lottoWinners.getWinnerValue(LottoPlace.SECOND_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당청금을 확인한다.")
    void totalPrizeConfirmTest() {

        //when
        LottoWinners lottoWinners = LottoWinners.of(lottoList, weekendLotto, bonusNumber);
        //then
        assertThat(lottoWinners.getTotalPrize()).isEqualTo(2030000000);
    }
}
