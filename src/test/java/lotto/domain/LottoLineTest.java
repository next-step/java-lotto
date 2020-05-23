package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoLineTest {

    @DisplayName("로또의 순위를 조회할수있다..")
    @ParameterizedTest(name = "{0}")
    @MethodSource("source")
    void getRank(String desc, List<Integer> winNums, List<Integer> nums, Integer bonusNum,  Rank rank){
        LottoLine lottoLine = new LottoLine(LottoNums.of(nums));
        assertThat(lottoLine.getRank(LottoNums.of(winNums), new LottoNum(bonusNum))).isEqualTo(rank);
    }


    static Stream<Arguments> source() {
        return Stream.of(
            arguments("6개 전부 일치하면 일등이다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), 10,Rank.FIRST),
            arguments("5개와 보너스일치하면 이등이다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,7), 7,Rank.SECOND),
            arguments("5개 일치하면 삼등이다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,45), 10,Rank.THIRD),
            arguments("4개 일차하면 사등이다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,8,45), 10,Rank.FOURTH),
            arguments("3개 일치하면 오들이다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,7,8,45), 10,Rank.FIFTH),
            arguments("2개 일치하면 순위에 없다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,20,7,8,45), 10,Rank.MISS),
            arguments("1개 일치하면 순위에 없다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,20,21,7,8,45), 10,Rank.MISS),
            arguments("0개 일치하면 순위에 없다.",Arrays.asList(1,2,3,4,5,6), Arrays.asList(19,20,21,7,8,45), 10,Rank.MISS)
        );
    }



}
