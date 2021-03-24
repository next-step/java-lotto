package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("당첨 결과")
class LottoRankTest {

    private LottoWinners winners;

    @BeforeEach
    void setUp() {
        winners = new LottoWinners(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), LottoNumber.of(45));
    }

    @Test
    @DisplayName("로또 꽝 생성 확인")
    void lottoRankMissTest() throws Exception {
        //given
        List<Integer> inputLottoZero = Arrays.asList(1,2,42,43,44,45);
        LottoTicket ticket = new LottoTicket(inputLottoZero);

        //when

        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("로또 당첨 5등 생성 확인")
    void lottoRankFiveTest() throws Exception {
        //given
        List<Integer> inputLottoThree = Arrays.asList(1,2,3,43,44,45);
        LottoTicket ticket = new LottoTicket(inputLottoThree);

        //when

        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("로또 당첨 4등 생성 확인")
    void lottoRankFourTest() throws Exception {
        //given
        List<Integer> inputLottoFour = Arrays.asList(1,2,3,4,44,45);
        LottoTicket ticket = new LottoTicket(inputLottoFour);

        //when


        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또 당첨 3등 생성 확인")
    void lottoRankThirdTest() throws Exception {
        //given
        List<Integer> inputLottoFive = Arrays.asList(1,2,3,4,5,44);
        LottoTicket ticket = new LottoTicket(inputLottoFive);

        //when


        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.THIRD);
    }


    @Test
    @DisplayName("로또 당첨 2등(보너스볼) 생성 확인")
    void lottoRankTwoTest() throws Exception {
        //given
        List<Integer> inputLottoFive = Arrays.asList(1,2,3,4,5,45);
        LottoTicket ticket = new LottoTicket(inputLottoFive);

        //when


        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 당첨 1등 생성 확인")
    void lottoRankOneTest() throws Exception {
        //given
        List<Integer> inputLottoSix = Arrays.asList(1,2,3,4,5,6);
        LottoTicket ticket = new LottoTicket(inputLottoSix);

        //when

        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FIRST);
    }
}
