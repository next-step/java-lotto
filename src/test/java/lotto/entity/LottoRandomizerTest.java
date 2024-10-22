package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRandomizerTest {

    @Test
    void 로또_번호_size_검증() {
        LottoRandomizer lottoRandomizer = new LottoRandomizer();
        List<Integer> numbers = lottoRandomizer.lottoShuffle();

        assertThat(numbers).hasSize(45);
    }

}
