package lotto.domain;

import lotto.strategy.Auto;
import lotto.strategy.Manual;
import lotto.strategy.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 당첨 정보")
public class LottoRankTest {

    private Numbers winnerNumber;

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    @BeforeEach
    public void setUp() {
        winnerNumber = new Auto(createLottoNumber());
    }

    @Test
    @DisplayName("로또 꽝 생성 확인")
    public void lottoRankOutTest() throws Exception {
        //given
        String inputLottoThree = "1,2,42,43,44,45";
        LottoTicket ticket = new LottoTicket(inputLottoThree);

        //when

        //then
        assertThat(ticket.rank(winnerNumber)).isEqualTo(LottoRank.ZERO);
    }

    @Test
    @DisplayName("로또 당첨 4등 생성 확인")
    public void lottoRankFourTest() throws Exception {
        //given
        String inputLottoThree = "1,2,3,43,44,45";
        LottoTicket ticket = new LottoTicket(inputLottoThree);

        //when

        //then
        assertThat(ticket.rank(winnerNumber)).isEqualTo(LottoRank.THREE);
    }

    @Test
    @DisplayName("로또 당첨 3등 생성 확인")
    public void lottoRankThreeTest() throws Exception {
        //given
        String inputLottoFour = "1,2,3,4,44,45";
        LottoTicket ticket = new LottoTicket(inputLottoFour);

        //when


        //then
        assertThat(ticket.rank(winnerNumber)).isEqualTo(LottoRank.FOUR);
    }

    @Test
    @DisplayName("로또 당첨 2등 생성 확인")
    public void lottoRankTwoTest() throws Exception {
        //given
        String inputLottoFive = "1,2,3,4,5,45";
        LottoTicket ticket = new LottoTicket(inputLottoFive);

        //when


        //then
        assertThat(ticket.rank(winnerNumber)).isEqualTo(LottoRank.FIVE);
    }

    @Test
    @DisplayName("로또 당첨 1등 생성 확인")
    public void lottoRankOneTest() throws Exception {
        //given
        String inputLottoSix = "1,2,3,4,5,6";
        LottoTicket ticket = new LottoTicket(inputLottoSix);

        //when

        //then
        assertThat(ticket.rank(winnerNumber)).isEqualTo(LottoRank.SIX);
    }
}
