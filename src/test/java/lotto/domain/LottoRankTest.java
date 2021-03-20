package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 당첨 정보")
public class LottoRankTest {

    private LottoNumbers winnerNumber;
    private LottoNumber bounsNumber;
    private LottoWinners winners;

    public List<LottoNumber> createLottoNumber() {
        return IntStream.range(1, 7)
                .mapToObj(i -> new LottoNumber(i))
                .collect(Collectors.toList());
    }

    @BeforeEach
    public void setUp() {
        winnerNumber = new LottoNumbers(createLottoNumber());
        bounsNumber = new LottoNumber(45);
        winners = new LottoWinners(winnerNumber, bounsNumber);
    }

    @Test
    @DisplayName("로또 꽝 생성 확인")
    public void lottoRankMissTest() throws Exception {
        //given
        String inputLottoThree = "1,2,42,43,44,45";
        LottoTicket ticket = new LottoTicket(inputLottoThree);

        //when

        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("로또 당첨 5등 생성 확인")
    public void lottoRankFiveTest() throws Exception {
        //given
        String inputLottoThree = "1,2,3,43,44,45";
        LottoTicket ticket = new LottoTicket(inputLottoThree);

        //when

        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("로또 당첨 4등 생성 확인")
    public void lottoRankFourTest() throws Exception {
        //given
        String inputLottoFour = "1,2,3,4,44,45";
        LottoTicket ticket = new LottoTicket(inputLottoFour);

        //when


        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또 당첨 3등 생성 확인")
    public void lottoRankThirdTest() throws Exception {
        //given
        String inputLottoFive = "1,2,3,4,5,44";
        LottoTicket ticket = new LottoTicket(inputLottoFive);

        //when


        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.THIRD);
    }


    @Test
    @DisplayName("로또 당첨 2등(보너스볼) 생성 확인")
    public void lottoRankTwoTest() throws Exception {
        //given
        String inputLottoFive = "1,2,3,4,5,45";
        LottoTicket ticket = new LottoTicket(inputLottoFive);

        //when


        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 당첨 1등 생성 확인")
    public void lottoRankOneTest() throws Exception {
        //given
        String inputLottoSix = "1,2,3,4,5,6";
        LottoTicket ticket = new LottoTicket(inputLottoSix);

        //when

        //then
        assertThat(LottoRank.valueOf(ticket, winners)).isEqualTo(LottoRank.FIRST);
    }
}
