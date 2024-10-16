package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 중복 번호 체크")
    void 로또_중복_체크() {
        assertThatThrownBy(() -> InputView.getInstance().getLottoNumbers("7,8,9,9,10,11"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
