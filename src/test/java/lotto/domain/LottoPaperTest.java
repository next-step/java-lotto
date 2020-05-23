package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPaperTest {

    @DisplayName("로또들의 당첨을 결과를 조회할수있다.")
    @ParameterizedTest
    @MethodSource("source")
    void lotto_result(List<Integer> winNums, List<Integer> nums, Integer bonusNum,  Rank rank) {
        LottoPaper lottoPaper = getLottoPaper(nums);

        LottoMatchResult lottoMatchResult = lottoPaper.getResult(LottoNums.of(winNums), new LottoNum(bonusNum), 1000);
        assertThat(lottoMatchResult.get(rank)).isEqualTo(1L);
    }

    @DisplayName("로또들의 수익률을 계산할수있다.")
    @ParameterizedTest
    @MethodSource("source")
    void profit_rate(List<Integer> winNums, List<Integer> nums, Integer bonusNum, Rank rank) {
        LottoPaper lottoPaper = getLottoPaper(nums);

        LottoMatchResult lottoMatchResult = lottoPaper.getResult(LottoNums.of(winNums), new LottoNum(bonusNum), 1000);
        assertThat(lottoMatchResult.computeProfitRate()).isEqualTo(rank.getWinningMoney()/1000);
    }

    private LottoPaper getLottoPaper(List<Integer> nums) {
        LottoNums lottoNums = LottoNums.of(nums);
        LottoLine lottoLine = new LottoLine(lottoNums);
        return new LottoPaper(Arrays.asList(lottoLine));
    }

    static Stream<Arguments> source() {
        return Stream.of(
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), 10,Rank.FIRST),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,7), 7,Rank.SECOND),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,45), 10,Rank.THIRD),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,8,45), 10,Rank.FOURTH),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,7,8,45), 10,Rank.FIFTH),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,7,8,9,45), 10,Rank.MISS)
        );
    }


}
