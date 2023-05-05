package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("Lotto_Number_Cache_테스트")
    public void Lotto_Number_Cache_테스트(){
        Assertions.assertThat(LottoNumber.of(3)).isEqualTo(LottoNumber.of(3));
    }
}
