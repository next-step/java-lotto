package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @Test
    void 로또숫자들은_1부터45까지의_중복되지_않은_6개의_수들이다() {
        List<Integer> lottoNumbers = lotto.generateRandoms();
        long given = lottoNumbers.stream().distinct().count();
        assertThat(given).isEqualTo(lottoNumbers.size());
    }
}