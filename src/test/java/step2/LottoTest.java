package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoTest {

    @Test
    void 로또를_만든다() {
        // Given && When
        Integer[] expectedArrays = {1, 2, 3, 4, 5, 6};

        // When
        Lotto lotto = Lotto.create(expectedArrays);

        // Then
        assertThat(lotto.numbers()).containsExactly(expectedArrays);
    }
}
