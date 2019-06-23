package step2;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void lotto() {
        List<Integer> lottoNumbers = Lotto.create();
        assertThat(lottoNumbers.size()).isEqualTo(0);
    }
}
