import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto= new Lotto();
    }


    @ParameterizedTest
    @MethodSource("lottoValues")
    void emptyOrNull(int number, String string, int bonusNumber) {
        lotto.lotto(number, string ,bonusNumber );
    }

    static Stream<Arguments> lottoValues() {
        return Stream.of(
                Arguments.arguments(20000 , "1,2,3,4,5,6", 7)
        );
    }

}
