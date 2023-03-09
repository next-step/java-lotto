import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto= new Lotto();
    }


    @DisplayName("기본 실행테스트 ")
    @ParameterizedTest
    @MethodSource("lottoValues")
    void test1(int number, String string, int bonusNumber) {
        lotto.lotto(number, string ,bonusNumber );
    }

    @DisplayName("기본 실행테스트2 ")
    @ParameterizedTest
    @MethodSource("lottoValues")
    void test2(int number, String string, int bonusNumber) {
        assertThat(lotto.lotto(number, string ,bonusNumber )).isGreaterThan(BigDecimal.ONE)
                .withFailMessage("1보다 작습니다.");
    }

    @DisplayName("기본 실행테스트3 ")
    @ParameterizedTest
    @MethodSource("lottoValues")
    void test3(int number, String string, int bonusNumber) {
        assertThat(lotto.lotto(number, string ,bonusNumber )).isLessThan(BigDecimal.ONE)
                .withFailMessage("1보다 큽니다.");
    }


    static Stream<Arguments> lottoValues() {
        return Stream.of(
                Arguments.arguments(20000 , "1,2,3,4,5,6", 7)
        );
    }

}
