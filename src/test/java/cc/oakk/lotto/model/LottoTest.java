package cc.oakk.lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void constructor_ShouldThrow_OnInvalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, LottoNumber.RANGE.getFrom() - 1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, LottoNumber.RANGE.getTo() + 1)));
    }

    @Test
    public void constructor_ShouldThrow_OnDuplicatedNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 3, 5, 6)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 1, 5, 6)));
    }

    @Test
    public void constructor_ShouldThrow_OnInvalidNumberCount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(IntStream.range(1, Lotto.NUMBER_COUNT).boxed().collect(Collectors.toList())));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(IntStream.range(1, Lotto.NUMBER_COUNT + 2).boxed().collect(Collectors.toList())));
    }

    @Test
    public void getMatchingCount() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(5);
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(4);
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(3);
        assertThat(lotto.getMatchingCount(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:true", "5:true", "6:true",
        "7:false", "8:false", "9:false", "10:false", "11:false" }, delimiter = ':')
    public void contains(int number, boolean result) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(LottoNumber.of(number))).isEqualTo(result);
    }
}
