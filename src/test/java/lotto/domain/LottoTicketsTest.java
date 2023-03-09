package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    public void setUp() {
        List<LottoTicket> tickets = new ArrayList<LottoTicket>();
        tickets.add(new LottoTicket(List.of(8, 21, 23, 41, 42, 43)));
        tickets.add(new LottoTicket(List.of(3, 5, 11, 16, 32, 38)));
        tickets.add(new LottoTicket(List.of(7, 11, 16, 35, 36, 44)));
        tickets.add(new LottoTicket(List.of(1, 8, 11, 31, 41, 42)));
        tickets.add(new LottoTicket(List.of(13, 14, 16, 38, 42, 45)));
        tickets.add(new LottoTicket(List.of(7, 11, 30, 40, 42, 43)));
        tickets.add(new LottoTicket(List.of(2, 13, 22, 32, 38, 45)));
        tickets.add(new LottoTicket(List.of(23, 25, 33, 36, 39, 41)));
        tickets.add(new LottoTicket(List.of(1, 3, 5, 14, 22, 45)));
        tickets.add(new LottoTicket(List.of(5, 9, 38, 41, 43, 44)));
        tickets.add(new LottoTicket(List.of(2, 8, 9, 18, 19, 21)));
        tickets.add(new LottoTicket(List.of(13, 14, 18, 21, 23, 35)));
        tickets.add(new LottoTicket(List.of(17, 21, 29, 37, 42, 45)));
        tickets.add(new LottoTicket(List.of(3, 8, 27, 30, 35, 44)));
        tickets.add(new LottoTicket(List.of(1, 2, 3, 4, 5, 33)));
        lottoTickets = new LottoTickets(tickets);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,7,33"})
    void 지난주_당첨번호와_보너스_번호를_입력받는다(String numbers) {

        //given
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] numberArrays = numbers.split(",");

        //when
        for (String number : numberArrays) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        //then
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 7,33);
        assertThat(lottoNumbers).hasSize(6);
     }

    @Test
    void 당첨통계를_구한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 37);
        int bonusNumber = 37;

        // when
        LottoResult result = lottoTickets.createLottoResult(numbers, bonusNumber);

        result.printWinningStatistics();

        //then
        assertThat(result.findHitCount(LottoRank.THREE_HIT)).isEqualTo(1);
        assertThat(result.findHitCount(LottoRank.FIVE_HIT)).isEqualTo(1);
        assertThat(result.findHitCount(LottoRank.FIVE_HIT_WITH_BONUS)).isEqualTo(0);
    }
}
