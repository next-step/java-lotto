package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private static final int inputMoneyAmount = 1000;
    private static final LottoNumber BONUS_NUMBER = new LottoNumber(11);

    private LottoTickets lottoTickets;
    private List<LottoNumber> lastWinningNumberList;

    @BeforeEach
    void setUp(){
        this.lottoTickets = new LottoTickets(inputMoneyAmount);

        int[] lastWinningNumbers = {1,2,3,7,8,9};

        int[] numberHasPrize = {1,2,3,4,5,6};
        int[] numberFailPrize = {11,12,13,14,15,16};

        List<List<LottoNumber>> manualTickets = new ArrayList<>();
        manualTickets.add(Arrays.stream(numberHasPrize).mapToObj(LottoNumber::new).collect(Collectors.toList()));
        manualTickets.add(Arrays.stream(numberFailPrize).mapToObj(LottoNumber::new).collect(Collectors.toList()));

        lottoTickets.issueLottoTicket(manualTickets);

        this.lastWinningNumberList = new ArrayList<>();
        IntStream.of(lastWinningNumbers).forEach(number -> lastWinningNumberList.add(new LottoNumber(number)));
    }


    @DisplayName("LottoTickets 생성 테스트")
    @Test
    void lottoGameTicketsCreateTest(){
        //given
        int inputMoney = 14000;

        // when
        LottoTickets lottoTickets = new LottoTickets(inputMoney);
        lottoTickets.issueLottoTicket(new ArrayList<>());

        // then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(14);
    }

    @DisplayName("로또 갯수만큼 당첨결과를 생성하는지 테스트")
    @Test
    void scoreWinningResultTest(){

        List<PrizeUnit> prizeUnitList = lottoTickets.scoreWinningResult(lastWinningNumberList, BONUS_NUMBER);

        assertThat(prizeUnitList.size()).isEqualTo(lottoTickets.getLottoTickets().size());

    }

}
