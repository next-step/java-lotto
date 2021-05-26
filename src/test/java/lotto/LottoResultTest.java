package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        tickets = new ArrayList<>();
        tickets.add(new LottoTicket(numbers));
        winningNumbersInput = Arrays.asList(1, 2, 3, 4, 5, 18);
    }

    @DisplayName("보너스볼이 틀린 경우, 3등에 해당")
    @Test
    void check_result_count_updated() {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 7);
        LottoResult lottoResult = new LottoResult(winningNumbers, tickets);

        //Then
        assertThat(lottoResult.getResultCount(Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("보너스볼이 일치하는 경우, 2등에 해당")
    @Test
    void check_result_count_updated_with_bonus() {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 6);
        LottoResult lottoResult = new LottoResult(winningNumbers, tickets);

        //Then
        assertThat(lottoResult.getResultCount(Rank.SECOND)).isEqualTo(1);
    }

    @DisplayName("수익률이 계산되는지 확인 : 보너스볼이 틀린 경우")
    @Test
    void check_profit_ratio() {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 7);
        LottoResult lottoResult = new LottoResult(winningNumbers, tickets);

        //Then
        assertThat(lottoResult.calculateProfitRatio()).isEqualTo(1500.0f);
    }

    @DisplayName("수익률이 계산되는지 확인 : 보너스볼이 맞는 경우")
    @Test
    void check_profit_ratio_with_bonus() {
        //When
        winningNumbers = new WinningNumbers(winningNumbersInput, 6);
        LottoResult lottoResult = new LottoResult(winningNumbers, tickets);

        //Then
        assertThat(lottoResult.calculateProfitRatio()).isEqualTo(30000.0f);
    }
}
