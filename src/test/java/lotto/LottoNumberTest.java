package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    private LottoNumber lottoNumber;
    @DisplayName("중복되는 로또넘버 숫자를 넣어본다.")
    @Test
    void name(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoNumber = new LottoNumber(new HashSet<>(Arrays.asList(1, 1, 3, 4, 5, 6)));
        });
    }

    @DisplayName("넣은 로또넘버가 같은객체 인지 확인해본다.")
    @Test
    void createLottoNumber() {
        lottoNumber = new LottoNumber(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumber).isEqualTo(new LottoNumber(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }
}
