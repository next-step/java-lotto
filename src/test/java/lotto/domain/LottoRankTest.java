package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoRankTest {
    private String inputLottoThree;
    private String inputLottoFour;
    private String inputLottoFive;
    private String inputLottoSix;

    @BeforeEach
    public void setUp() {
        inputLottoThree = "1,2,3,43,44,45";
        inputLottoFour = "1,2,3,4,44,45";
        inputLottoFive = "1,2,3,4,5,45";
        inputLottoSix = "1,2,3,4,5,6";
    }

    public List<Integer> createLottoNumber() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    public List<LottoTicket> createLottoTikect() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(createLottoNumber()));
        return lottoTickets;
    }

    public LottoMachine createLottoMachine() {
        return new LottoMachine(createLottoTikect());
    }

    @Test
    @DisplayName("로또 당첨 4등 생성 확인")
    public void lottoRankFourTest() throws Exception {
        //given
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoThree);
        Rank rank = Rank.THREE;
        LottoRank lottoRank = new LottoRank(rank, createLottoMachine(), winnerNumber);
        
        //when


        //then
        assertThat(lottoRank.getWinnerCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 3등 생성 확인")
    public void lottoRankThreeTest() throws Exception {
        //given
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoFour);
        Rank rank = Rank.FOUR;
        LottoRank lottoRank = new LottoRank(rank, createLottoMachine(), winnerNumber);

        //when


        //then
        assertThat(lottoRank.getWinnerCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 2등 생성 확인")
    public void lottoRankTwoTest() throws Exception {
        //given
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoFive);
        Rank rank = Rank.FIVE;
        LottoRank lottoRank = new LottoRank(rank, createLottoMachine(), winnerNumber);

        //when


        //then
        assertThat(lottoRank.getWinnerCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 1등 생성 확인")
    public void lottoRankOneTest() throws Exception {
        //given
        WinnerNumber winnerNumber = new WinnerNumber(inputLottoSix);
        Rank rank = Rank.SIX;
        LottoRank lottoRank = new LottoRank(rank, createLottoMachine(), winnerNumber);

        //when


        //then
        assertThat(lottoRank.getWinnerCount()).isEqualTo(1);
    }
}
