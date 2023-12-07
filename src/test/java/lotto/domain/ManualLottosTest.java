package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ManualLottosTest {

    @DisplayName("문자열 로또 번호 리스트를 전달하면 ManualLottos 객체를 생성한다.")
    @Test
    void manualLottosTest() {
        assertThat(new ManualLottos(List.of("1, 2, 3, 4, 5, 6",
                                            "1, 3, 5, 7, 9, 11",
                                            "2, 4, 6, 8, 10, 12")))
                .isInstanceOf(ManualLottos.class);
    }
}
