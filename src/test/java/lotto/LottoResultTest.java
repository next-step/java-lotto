package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private List<LottoTicket> tickets;
    private WinningNumbers winningNumbers;
    List<Integer> winningNumbersInput;

    @BeforeEach
    void setUp() {
        //Given
        List<LottoNumber> numbers = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        tickets = new ArrayList<>();
        tickets.add(new LottoTicket(numbers));
        winningNumbersInput = Arrays.asList(1, 2, 3, 4, 5, 18);
    }

    @DisplayName("보너스볼이 틀린 경우, 3등에 해당")
    @Test
    void check_result_count_updated() {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 7);
        LottoResult lottoResult = new LottoResult(5000, winningNumbers, tickets);

        //Then
        assertThat(lottoResult.getResultCount(Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("보너스볼이 일치하는 경우, 2등에 해당")
    @Test
    void check_result_count_updated_with_bonus() {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 6);
        LottoResult lottoResult = new LottoResult(5000, winningNumbers, tickets);

        //Then
        assertThat(lottoResult.getResultCount(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("구매금액에 따라 수익률이 계산되는지 확인 : 보너스볼이 틀린 경우")
    @ParameterizedTest(name = "{displayName} ==> input : {0} / result : {1}")
    @CsvSource({"1000,1500.00", "5000,300.00", "1500000,1.00"})
    void check_profit_ratio(int purchaseAmount, float profitRatio) {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 7);
        LottoResult lottoResult = new LottoResult(purchaseAmount, winningNumbers, tickets);

        //Then
        assertThat(lottoResult.calculateProfitRatio()).isEqualTo(profitRatio);
    }

    @DisplayName("구매금액에 따라 수익률이 계산되는지 확인 : 보너스볼이 맞는 경우")
    @ParameterizedTest(name = "{displayName} ==> input : {0} / result : {1}")
    @CsvSource({"1000,30000.00", "5000,6000.00", "1500000,20.00"})
    void check_profit_ratio_with_bonus(int purchaseAmount, float profitRatio) {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 6);
        LottoResult lottoResult = new LottoResult(purchaseAmount, winningNumbers, tickets);

        //Then
        assertThat(lottoResult.calculateProfitRatio()).isEqualTo(profitRatio);
    }
}
