package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    public static final String DELIMITER = ",";

    @Test
    @DisplayName("로또 중복 번호 체크")
    void 로또_중복_체크() {
        assertThatThrownBy(() -> new Lotto("7,8,9,9,10,11", DELIMITER))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
