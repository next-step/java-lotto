package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static lotto.Lotto.IS_NOT_LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 발행시 6자리 숫자가 아닌 경우 에러")
    @Test
    void 로또_발행시_6자리_아닐시_에러(){
        Set<Integer> lottoNumbers = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
        assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(IS_NOT_LOTTO_SIZE);
    }
}
