package step2;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void lotto() {
        List<Integer> lottoNumbers = Lotto.create();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
