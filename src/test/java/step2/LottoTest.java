package step2;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Lotto should")
class LottoTest {
    private final List<Integer> lottoNumbers = Arrays.asList(8, 21, 23, 41, 42, 43);

    @Test
    @DisplayName("be equal to other one when it's number are same")
    void lottoIsEqualsToWhenLottoNumberIsSame() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }
}