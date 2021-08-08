package lotto.domain;

import lotto.dto.WinStats;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    private static LottoNumbers lottoNumbers;

    @BeforeAll
    static void setUp() {
        List<Integer> customNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoNumbers = () -> customNumbers;
    }

    @DisplayName("로또 티켓 구매 성공")
    @Test
    void new_success() {
        assertThat(new LottoTickets(new Money(1000), lottoNumbers));
    }

    @DisplayName("로또 티켓 구입 개수 확인")
    @Test
    void size() {
        assertThat(new LottoTickets(new Money(10000), lottoNumbers).size()).isEqualTo(10);
    }

    @DisplayName("당첨 통계")
    @Test
    void getWinStats_fix() {
        List<Integer> customNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        LottoNumbers winNumbers = () -> customNumbers;

        WinStats result = new LottoTickets(new Money(3000), lottoNumbers).getWinStats(winNumbers, 5);
        System.out.println(result.toString());
        assertThat(result.getYield()).isEqualTo(0.002f);
    }

}