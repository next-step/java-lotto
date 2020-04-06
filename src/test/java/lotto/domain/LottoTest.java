package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void createOneLotto() {
        Lotto lotto = new Lotto();
        Set<Integer> numbers = lotto.getLottoNumbers();
        assertThat(numbers).hasSize(6);
    }
}
