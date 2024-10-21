package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @Test
    public void validCreation() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    public void duplicateNumbers() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1,1,2,3,4,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
