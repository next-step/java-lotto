import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {46,0})
    @DisplayName("로또 번호 발급 제한")
    public void between_1_to_45(int target) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(target));
    }

    @Test
    @DisplayName("로또 한장 발급 기능")
    public void lotto_print_only_one()  {
        // given
        Lotto lotto = LottoFactory.makeOne();
        // then
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 6개 생성")
    public void writingMethodName() throws Exception {
        // given

        // when

        // then
    }
}
