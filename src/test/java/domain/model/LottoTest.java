package domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void createTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getLottoNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }
}
