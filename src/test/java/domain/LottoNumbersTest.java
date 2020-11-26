package domain;
import org.junit.jupiter.api.Test;

import exception.InvalidLottoNumbersException;
import exception.NumberNotInRangeException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    void initTest() {
        assertThatThrownBy( () -> {
            new LottoNumbers(Arrays.asList(-1,2,3,4,5,6));
        }).isExactlyInstanceOf(NumberNotInRangeException.class);

        assertThatThrownBy( () -> {
            new LottoNumbers(Arrays.asList(1,2,3,4,5,5));
        }).isExactlyInstanceOf(InvalidLottoNumbersException.class);

        assertThatThrownBy( () -> {
            new LottoNumbers(Arrays.asList(1,2,3,4));
        }).isExactlyInstanceOf(InvalidLottoNumbersException.class);
    }
}
