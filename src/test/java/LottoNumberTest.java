import Lotto.LotterNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 넘버는 6자리가 초과하면 예외를발생한다.")

    public void lottoNumbersSixOverException() {
        assertThatThrownBy(() ->
                LotterNumbers.of(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    @DisplayName("로또 넘버는 6자리가 되면 통과된다..")

    public void lottoNumbersSixPass() {
        LotterNumbers lottoNumbers = LotterNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.getLottoNumberCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 넘버는 1~45사이가 되어야된다")

    public void lottoNumberVerify() {
        assertThatThrownBy(() ->
                LotterNumbers.of(List.of(0, 46, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
    }
}
