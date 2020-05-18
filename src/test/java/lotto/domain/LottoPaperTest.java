package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPaperTest {

    @DisplayName("로또들의 당첨을 조회할수있다.")
    @ParameterizedTest
    @MethodSource("source")
    void lotto_result(List<Integer> winNums, List<Integer> nums, LottoMatch lottoMatch) {

        LottoNums lottoNums = lottoNums(nums);
        LottoLine lottoLine = new LottoLine(lottoNums);
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList(lottoLine));

        LottoMatchResult lottoMatchResult = lottoPaper.getResult(lottoNums(winNums), 1000);
        assertThat(lottoMatchResult.get(lottoMatch)).isEqualTo(1L);
    }

    @DisplayName("로또들의 수익률을 계산할수있다.")
    @ParameterizedTest
    @MethodSource("source")
    void profit_rate(List<Integer> winNums, List<Integer> nums, LottoMatch lottoMatch) {
        LottoNums lottoNums = lottoNums(nums);
        LottoLine lottoLine = new LottoLine(lottoNums);
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList(lottoLine));


        LottoMatchResult lottoMatchResult = lottoPaper.getResult(lottoNums(winNums), 1000);
        assertThat(lottoMatchResult.computeProfitRate()).isEqualTo(lottoMatch.getAmount()/1000);
    }

    static Stream<Arguments> source() {
        return Stream.of(
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), LottoMatch.SIX),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,7), LottoMatch.FIVE),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,7,8), LottoMatch.FOUR),
            arguments(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,7,8,9), LottoMatch.THREE)
        );
    }

    private LottoNums lottoNums(List<Integer> nums){
        List<LottoNum> lottoNums = nums.stream().map(integer -> new LottoNum(integer)).collect(Collectors.toList());
        return new LottoNums(lottoNums);
    }

    private List<LottoNum> getLottoNums(int max) {
        return IntStream.range(1, max).mapToObj(value -> new LottoNum(value)).collect(
            Collectors.toList());
    }

}
