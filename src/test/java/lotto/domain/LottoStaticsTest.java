package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStaticsTest {

    LottoNumberFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new LottoNumberFactoryImpl();
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbersWithRankCount")
    public void 로또통계(List<List<Integer>> lottoNumbers, List<String> matchingCounts) {
        WinLotto winLotto = new WinLotto(new Lotto(1,2,3,4,5,6),10);
        Lottos lottos = new Lottos(lottoNumbers);
        LottoStatics statics = lottos.calculateStatics(winLotto);
        for( String matchingCount : matchingCounts) {
            int rank = Integer.parseInt(matchingCount.split(",")[0]);
            int rankCount = Integer.parseInt(matchingCount.split(",")[1]);
            assertThat(statics.getRankCount(rank)).isEqualTo(rankCount);
        }
    }

    private static Stream<Arguments> provideLottoNumbersWithRankCount() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        Arrays.asList(8, 21, 23, 41, 42, 43),
                        Arrays.asList(3, 5, 11, 16, 32, 38),
                        Arrays.asList(7, 11, 16, 35, 36, 44),
                        Arrays.asList(1, 8, 11, 31, 41, 42),
                        Arrays.asList(13, 14, 16, 38, 42, 45),
                        Arrays.asList(7, 11, 30, 40, 42, 43),
                        Arrays.asList(2, 13, 22, 32, 38, 45),
                        Arrays.asList(23, 25, 33, 36, 39, 41),
                        Arrays.asList(1, 3, 5, 14, 22, 45),
                        Arrays.asList(5, 9, 38, 41, 43, 44),
                        Arrays.asList(2, 8, 9, 18, 19, 21),
                        Arrays.asList(13, 14, 18, 21, 23, 35),
                        Arrays.asList(17, 21, 29, 37, 42, 45),
                        Arrays.asList(3, 8, 27, 30, 35, 44)
                ), Arrays.asList("3,1","4,0","5,0","6,0")),
                Arguments.of(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 41, 42, 43),
                        Arrays.asList(41, 42, 43, 1, 2, 3),
                        Arrays.asList(41, 42, 43, 4, 5, 6),
                        Arrays.asList(1,2,3,4,12,13),
                        Arrays.asList(12,13,3,4,5,6),
                        Arrays.asList(11,12,13,14,15,16),
                        Arrays.asList(1,11,12,13,14,15),
                        Arrays.asList(11,12,13,14,15,6),
                        Arrays.asList(11,2,3,14,15,16)
                ),Arrays.asList("3,3","4,2","5,0","6,1"))
        );
    }


    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    public void 수익률(List<List<Integer>> numbers, double profitRate) {
        WinLotto winLotto = new WinLotto(new Lotto(1,2,3,4,5,6),10);
        Lottos lottos = new Lottos(numbers);
        LottoStatics statics = lottos.calculateStatics(winLotto);
        assertThat(statics.getProfit()).isEqualTo(profitRate);
    }

    private static Stream<Arguments> provideLottoNumbers() {

        return Stream.of(
                Arguments.of(Arrays.asList(
                        Arrays.asList(8, 21, 23, 41, 42, 43),
                        Arrays.asList(3, 5, 11, 16, 32, 38),
                        Arrays.asList(7, 11, 16, 35, 36, 44),
                        Arrays.asList(1, 8, 11, 31, 41, 42),
                        Arrays.asList(13, 14, 16, 38, 42, 45),
                        Arrays.asList(7, 11, 30, 40, 42, 43),
                        Arrays.asList(2, 13, 22, 32, 38, 45),
                        Arrays.asList(23, 25, 33, 36, 39, 41),
                        Arrays.asList(1, 3, 5, 14, 22, 45),
                        Arrays.asList(5, 9, 38, 41, 43, 44),
                        Arrays.asList(2, 8, 9, 18, 19, 21),
                        Arrays.asList(13, 14, 18, 21, 23, 35),
                        Arrays.asList(17, 21, 29, 37, 42, 45),
                        Arrays.asList(3, 8, 27, 30, 35, 44)
                ), 0.35),
                Arguments.of(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 41, 42, 43),
                        Arrays.asList(41, 42, 43, 1, 2, 3),
                        Arrays.asList(41, 42, 43, 4, 5, 6),
                        Arrays.asList(1,2,3,4,12,13),
                        Arrays.asList(12,13,3,4,5,6),
                        Arrays.asList(11,12,13,14,15,16),
                        Arrays.asList(1,11,12,13,14,15),
                        Arrays.asList(11,12,13,14,15,6),
                        Arrays.asList(11,2,3,14,15,16)
                ),200011.5)
        );
    }

}
