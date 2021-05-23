package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또티켓들과 당첨번호를 정확히 비교하는지 테스트")
    @Test
    void check_result_count_updated() {
        //Given
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                                                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(numbers));
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 18});

        //When
        LottoResult lottoResult = new LottoResult(5000, winningNumbers, tickets);

        //Then
        assertThat(lottoResult.getResultCount(MatchStatus.FIVE)).isEqualTo(1);
    }

    @DisplayName("구매금액에 따라 수익률이 계산되는지 확인")
    @ParameterizedTest(name = "{displayName} ==> input : {0} / result : {1}")
    @CsvSource({"1000,1500.00","5000,300.00","1500000,1.00"})
    void check_profit_ratio(int purchaseAmount, float profitRatio) {
        //Given
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(new LottoTicket(numbers));
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 18});

        //When
        LottoResult lottoResult = new LottoResult(purchaseAmount, winningNumbers, tickets);

        //Then
        assertThat(lottoResult.calculateProfitRatio()).isEqualTo(profitRatio);

    }
}
