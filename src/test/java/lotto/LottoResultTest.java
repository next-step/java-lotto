package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("테스트 로또를 구매하여 4등 ( 3개 일치 ) 갯수 조회 테스트")
    @Test
    void countFourth_4등_갯수_조회() {
        LottoBuy lottoBuy = new LottoBuy();
        Lottos lottos = lottoBuy.buyOneRandomLotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoRecord lottoRecord = lottos.compareWinNumber(new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 8, 9, 10))));
        assertThat(lottoRecord.isRecord(LottoRank.FOURTH, 1)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("테스트 로또를 여러장 구매하여 각 등수 갯수 조회 테스트")
    @MethodSource("countLottosCollectNumber")
    void countManyLottoRank_여러장_등수_조회(List<Integer> lottoNumber, List<Integer> winLottoNumber, int fst, int snd, int trd, int frd) {
        Lottos lottos = new Lottos(new ArrayList<Lotto>(Arrays.asList(new Lotto(() -> new LottoNumber(lottoNumber)))));
        Lotto winLottto = new Lotto(() -> new LottoNumber(winLottoNumber));
        LottoRecord lottoRecord = lottos.compareWinNumber(winLottto);
        assertThat(lottoRecord.isRecord(FIRST, fst)).isTrue();
        assertThat(lottoRecord.isRecord(SECOND, snd)).isTrue();
        assertThat(lottoRecord.isRecord(THIRD, trd)).isTrue();
        assertThat(lottoRecord.isRecord(FOURTH, frd)).isTrue();
    }

    static Stream<Arguments> countLottosCollectNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 1, 0, 0, 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Arrays.asList(1, 2, 3, 4, 5, 6), 0, 1, 0, 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), Arrays.asList(1, 2, 3, 4, 5, 6), 0, 0, 1, 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), Arrays.asList(1, 2, 3, 4, 5, 6), 0, 0, 1, 0)
        );
    }

    @DisplayName("수익률 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,14,0.35", "3,15,0.33", "3,50,0.1"})
    void lottoProfit_수익률_테스트(int winLottoNumber, int countBuyLotto, double profit) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.checkRank(winLottoNumber);
        double result = lottoResult.calculateProfit(countBuyLotto);
        assertThat(result).isEqualTo(profit);
    }
}
