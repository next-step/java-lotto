package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 생성() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(new LottoNumber(i));
        }
        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }
}
