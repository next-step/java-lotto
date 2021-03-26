package lotto.step2;

import lotto.step2.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @ParameterizedTest(name = "creationTest")
    @MethodSource("arrayProvider")
    public void creationTest(Rank inputRank, int inputAmount) {
        assertThat(inputRank.amount()).isEqualTo(inputAmount);
    }

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of((Object)Rank.from(3),5_000),
                Arguments.of((Object)Rank.from(4),50_000),
                Arguments.of((Object)Rank.from(5),1_500_000),
                Arguments.of((Object)Rank.from(6),2_000_000_000),
                Arguments.of((Object)Rank.from(7),0)
        );
    }

}
