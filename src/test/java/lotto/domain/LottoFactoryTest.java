package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoFactoryTest {

    @Test
    @DisplayName("개수만큼 자동으로 로또가 생성되는지 확인")
    void buyTickets() {
        List<LottoNumbers> numbers = LottoFactory.buyTickets(3);
        assertEquals(numbers.size(), 3);
    }

    @ParameterizedTest
    @CsvSource({"14000, 14", "1000, 1", "0, 0", "-1000, 0"})
    @DisplayName("개수만큼 수동으로 로또가 생성되는지 확인")
    void buySlips() {
        List<LottoNumbers> numbers = LottoFactory.buyTickets(3, () -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(numbers).containsExactly(
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(1, 2, 3, 4, 5, 6)
        );
    }
}
