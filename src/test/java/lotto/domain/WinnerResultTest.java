package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerResultTest {
    @DisplayName("1등 1개, 4등 1개")
    @Test
    void getResult() {
        // given
        LottoNumbers winningNumbers = createWinningNumbers();
        List<LottoNumbers> pickedLottoNumbers = new ArrayList<>(createPickedNumbers());
        WinnerResult winnerResult = new WinnerResult(winningNumbers, pickedLottoNumbers);

        // when
        EnumMap<Rank, Integer> result = winnerResult.getResult();

        // then
        assertThat(result.getOrDefault(Rank.FIRST, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.FOURTH, 0)).isEqualTo(1);
    }

    private LottoNumbers createWinningNumbers() {
        List<LottoNumber> lottoNumbersList = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
        return new LottoNumbers(lottoNumbersList);
    }

    private List<LottoNumbers> createPickedNumbers() {
        List<LottoNumber> lottoNumberList = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
        List<LottoNumber> lottoNumberList2 = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(44),
                new LottoNumber(45)
        );
        List<LottoNumber> lottoNumberList3 = Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(8),
                new LottoNumber(27),
                new LottoNumber(30),
                new LottoNumber(35),
                new LottoNumber(44)
        );
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        LottoNumbers lottoNumbers2 = new LottoNumbers(lottoNumberList2);
        LottoNumbers lottoNumbers3 = new LottoNumbers(lottoNumberList3);
        return Arrays.asList(
                lottoNumbers, lottoNumbers2, lottoNumbers3
        );
    }
}