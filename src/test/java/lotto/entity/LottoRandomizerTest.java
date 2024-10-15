package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRandomizerTest {

    @Test
    void 로또_번호_size_검증() {

        List<Integer> numbers = LottoRandomizer.create();

        assertThat(numbers).hasSize(6);
    }

}
