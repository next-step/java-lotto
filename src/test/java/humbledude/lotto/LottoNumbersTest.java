package humbledude.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    public void validNumbers() {
        assertThat(LottoNumbers.of(1, 2, 3 ,4 ,5, 6))
                .isInstanceOf(LottoNumbers.class);
    }

    @Test
    public void duplicatedNumbers() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoTicket(LottoNumbers.of(1, 2, 3 ,4 ,6, 6)));
    }

    @Test
    public void outOfBoundNumbers() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoTicket(LottoNumbers.of(0, 2, 3 ,4 ,5, 6)));

        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoTicket(LottoNumbers.of(1, 2, 3 ,4 ,5, 46)));
    }
}
