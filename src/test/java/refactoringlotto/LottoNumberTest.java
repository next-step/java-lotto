package refactoringlotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    public void 숫자범위1_45이외_테스트(int testLottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(testLottoNumber);
        });

    }
}
