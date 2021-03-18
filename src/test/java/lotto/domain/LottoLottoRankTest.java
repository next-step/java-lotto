package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoLottoRankTest {

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    public List<LottoTicket> createLottoTikect() {
        return Arrays.asList(new LottoTicket(createLottoNumber()));
    }

    public LottoMachine createLottoMachine() {
        return new LottoMachine(createLottoTikect());
    }

    @Test
    @DisplayName("로또 당첨 4등 생성 확인")
    public void lottoRankFourTest() throws Exception {
        //given
        String inputLottoThree = "1,2,3,43,44,45";
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoThree);
        LottoRank lottoRank = LottoRank.THREE;
        lottoRank.rank(createLottoMachine(), winnerNumber);

        //when


        //then
        assertThat(lottoRank.winnerCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 3등 생성 확인")
    public void lottoRankThreeTest() throws Exception {
        //given
        String inputLottoFour = "1,2,3,4,44,45";
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoFour);
        LottoRank lottoRank = LottoRank.FOUR;
        lottoRank.rank(createLottoMachine(), winnerNumber);

        //when


        //then
        assertThat(lottoRank.winnerCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 2등 생성 확인")
    public void lottoRankTwoTest() throws Exception {
        //given
        String inputLottoFive = "1,2,3,4,5,45";
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoFive);
        LottoRank lottoRank = LottoRank.FIVE;
        lottoRank.rank(createLottoMachine(), winnerNumber);

        //when


        //then
        assertThat(lottoRank.winnerCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 1등 생성 확인")
    public void lottoRankOneTest() throws Exception {
        //given
        String inputLottoSix = "1,2,3,4,5,6";
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoSix);
        LottoRank lottoRank = LottoRank.SIX;
        lottoRank.rank(createLottoMachine(), winnerNumber);

        //when

        //then
        assertThat(lottoRank.winnerCount()).isEqualTo(1);
    }
}
