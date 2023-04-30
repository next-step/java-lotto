package study.lotto.step2.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.step2.domain.Lotto;
import study.lotto.step2.domain.LottoResult;
import study.lotto.step2.domain.LottoResults;
import study.lotto.step2.domain.SoldLottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoReaderTest {
    @Test
    @DisplayName("로또 결과 확인")
    void LottoResults_from_SoldLottos() {
        // given
        LottoReader lottoReader = new LottoReader(List.of(1, 2, 3, 4, 5, 6));
        Lotto notMatchLotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto oneMatchLotto = new Lotto(List.of(1, 12, 13, 14, 15, 16));

        SoldLottos soldLottos = new SoldLottos(List.of(notMatchLotto, oneMatchLotto));

        // when
        LottoResults lottoResults = lottoReader.resultOf(soldLottos);

        // then
        LottoResults expectedLottoResults = new LottoResults(
                List.of(LottoResult.NOT_MATCH, LottoResult.MATCH_ONE_NUMBER)
        );
        assertThat(lottoResults).isEqualTo(expectedLottoResults);
    }

    @Test
    @DisplayName("로또 당첨 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_numbers_of_winning_then_throw_IllegalArgumentException() {
        // given
        List<Integer> illegalNumbersOfWinning = IntStream.rangeClosed(1, 7)
                .boxed()
                .collect(Collectors.toList());

        // when, then
        assertThatThrownBy(() -> new LottoReader(illegalNumbersOfWinning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 갯수는 6개입니다: " + illegalNumbersOfWinning.size());
    }

    @Test
    @DisplayName("당첨 번호가 범위(1 이상 45 이하의 정수)를 넘어서는 경우, IllegalArgumentException 예외 발생")
    void out_of_range_winning_number_then_throw_IllegalArgumentException() {
        // given
        int outOfRangeNumber = 46;
        List<Integer> numbersOfWinning = List.of(1, 2, 3, 4, 5, outOfRangeNumber);

        // when, then
        assertThatThrownBy(() -> new LottoReader(numbersOfWinning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 당첨 번호는 1 이상 45 이하의 정수입니다: " + outOfRangeNumber);
    }
}