package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("구매하려는 줄 수 만큼 발급이 되는지")
    @ParameterizedTest(name = "[{index}] lineCount: {0}")
    @ValueSource(ints = {1, 7})
    void publish(int lineCount) {
        //given
        LottoTicket lottoTicket = LottoTicket.publish(new Dollars(lineCount * 1000), Collections::shuffle);

        //when
        List<LottoNumbers> lottoLines = lottoTicket.getLottoLines();

        //then
        assertThat(lottoLines.size()).isEqualTo(lineCount);
    }
    
    
    @DisplayName("통계가 잘구해지는지")
    @Test
    void rank() {
        //given
        LottoNumbers winningNumbers = new LottoNumbers(asList(num(1), num(2), num(3), num(4), num(5), num(6)));

        LottoNumbers sixMatched = new LottoNumbers(asList(num(1), num(2), num(3), num(4), num(5), num(6)));
        LottoNumbers fiveMatched = new LottoNumbers(asList(num(1), num(2), num(3), num(4), num(5), num(7)));
        LottoNumbers fiveMatched2 = new LottoNumbers(asList(num(1), num(2), num(3), num(4), num(5), num(10)));
        LottoNumbers threeMatched = new LottoNumbers(asList(num(1), num(2), num(3), num(9), num(8), num(7)));
        LottoNumbers twoMatched = new LottoNumbers(asList(num(1), num(2), num(10), num(9), num(8), num(7)));

        LottoTicket lottoTicket = new LottoTicket(asList(sixMatched, fiveMatched, fiveMatched2, threeMatched, twoMatched));

        //when
        Statistics statistics = lottoTicket.rank(winningNumbers);

        //then
        Map<Grade, Long> expectedGrades = new HashMap<>();
        expectedGrades.put(Grade.FIRST, 1L);
        expectedGrades.put(Grade.SECOND, 2L);
        expectedGrades.put(Grade.FOURTH, 1L);

        assertThat(statistics).isEqualTo(new Statistics(expectedGrades, new Dollars(5000)));
    }

    private static LottoNumber num(int num) {
        return LottoNumber.from(num);
    }

}
