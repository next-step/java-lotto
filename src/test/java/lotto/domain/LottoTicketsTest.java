package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    List<LottoTicket> initialLottoTickets = new ArrayList<>();

    @BeforeEach
    void setUp() {
        initialLottoTickets = Arrays.asList(new LottoTicket(getLottoNumbers(1, 2, 3, 4, 5, 6)),
            new LottoTicket(getLottoNumbers(7, 8, 9, 10, 11, 12)),
            new LottoTicket(getLottoNumbers(1, 2, 3, 4, 5, 7)),
            new LottoTicket(getLottoNumbers(1, 2, 3, 4, 5, 8)));

    }

    @Test
    void create_test() {
        //Given
        LottoTickets lottoTickets = new LottoTickets(initialLottoTickets);

        Assertions.assertThat(lottoTickets.size()).isEqualTo(initialLottoTickets.size());
    }

    @Test
    void checkResult_test() {
        //Given
        LottoTickets lottoTickets = new LottoTickets(initialLottoTickets);
        WinnerLottoTicket winnerLottoTicket = new WinnerLottoTicket("1,2,3,4,5,6", "7");
        Map<LottoPrizeType, Long> lottoPrizeTypeLongMap = lottoTickets.checkResult(winnerLottoTicket);
        System.out.println(lottoPrizeTypeLongMap);
        Assertions.assertThat(1L).isEqualTo(lottoPrizeTypeLongMap.get(LottoPrizeType.ONE_PRIZE));
        Assertions.assertThat(1L).isEqualTo(lottoPrizeTypeLongMap.get(LottoPrizeType.TWO_PRIZE));
        Assertions.assertThat(1L).isEqualTo(lottoPrizeTypeLongMap.get(LottoPrizeType.THREE_PRIZE));
    }

    private List<LottoNumber> getLottoNumbers(int number, int number1, int number2, int number3, int number4,
        int number5) {
        return Arrays.asList(new LottoNumber(number),
            new LottoNumber(number1),
            new LottoNumber(number2),
            new LottoNumber(number3),
            new LottoNumber(number4),
            new LottoNumber(number5)
        );
    }

}
