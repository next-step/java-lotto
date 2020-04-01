package lotto.model.lottonumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @DisplayName("같은 번호를 인자로 받아 생성된 LottoNumber 객체는 같다.")
    @Test
    void createTest() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}
