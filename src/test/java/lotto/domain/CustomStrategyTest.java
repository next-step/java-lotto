package lotto.domain;

import lotto.exception.InvalidLottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomStrategyTest {
    LottoNumberFactory factory;
    @BeforeEach
    public void setUp() {
        factory = new LottoNumberFactoryImpl();
    }
    @ParameterizedTest
    @DisplayName("정해진 숫자를 제대로 generate하는지 테스트")
    @MethodSource("provideCustomNumbers")
    public void generRateNumberTest(List<Integer> customNumbers) {
        factory.setGenerateStrategy(new CustomStrategy(customNumbers));
        Lotto factoryLotto = new Lotto(factory);
        Lotto customLotto = new Lotto(customNumbers);

        assertThat(factoryLotto.matchCount(customLotto)).isEqualTo(Rank.sixNumbersMatch);
    }

    @DisplayName("6개보다 작은 갯수가 들어오면 에러발생")
    @Test
    public void generateNumberLessThan6() {
        factory.setGenerateStrategy(new CustomStrategy(Arrays.asList(1,2,3,4,5)));
        assertThatThrownBy(()->new Lotto(factory))
                .isInstanceOf(InvalidLottoNumber.class)
                .hasMessage(new InvalidLottoNumber(Arrays.asList(1,2,3,4,5).toString()).getMessage());
    }


    private static Stream<Arguments> provideCustomNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6)),
                Arguments.of(Arrays.asList(31,32,33,34,35,36))
        );
    }

}
