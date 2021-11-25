package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningTest {

    private LottoTicket initTicket;

    @BeforeEach
    @DisplayName("테스트용 로또 티켓 생성")
    void setUp() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 41, 15, 16);
        List<Integer> lottoNumbers2 = Arrays.asList(10, 21, 31, 41, 12, 23);
        List<Integer> lottoNumbers3 = Arrays.asList(12, 13, 14, 15, 17, 19);

        initTicket = LottoTicket.from(Arrays.asList(Lotto.winningFrom(lottoNumbers1),
                Lotto.winningFrom(lottoNumbers2), Lotto.winningFrom(lottoNumbers3)));
    }

    @Test
    @DisplayName("생성 테스트")
    void createTest() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        LottoWinning lottoWinning = LottoWinning.from(winningNumbers);

        assertThat(lottoWinning).isEqualTo(LottoWinning.from(winningNumbers));
    }

    @Test
    @DisplayName("예외 검증")
    void exceptionTest() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6,7);
        assertThatThrownBy(() ->
                LottoWinning.from(winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수익률 계산 검증")
    void profitTest() {
        LottoWinning lottoWinning = LottoWinning.from(Arrays.asList(1,2,3,4,5,6));

        double profit = lottoWinning.calculateRateOfProfit(initTicket, 3000);
        assertThat(profit).isEqualTo(1.66);
    }
}
