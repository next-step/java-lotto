package step3.model;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 수동 로또를 입력받는다.
- 로또번호의 개수가 6이 아니면 예외가 발생한다.
 */
public class ManualLottoTest extends GlobalTest{

    @DisplayName("수동 로또를 입력받는다.")
    @Test
    void createLottoTest() {
        ManualLotto lotto = new ManualLotto(List.of("1,2,3,4,5,6"));

        assertThat(lotto.getLottoList()).containsExactly(createLotto(1,2,3,4,5,6));
    }

    @DisplayName("로또번호의 개수가 6이 아니면 예외가 발생한다.")
    @Test
    void confirmLottoNumberSizeTest() {
        assertThatThrownBy(() -> new ManualLotto(List.of("1,2,3,4,5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6자리이여만 합니다.");
    }
}
