package lotto;

import lotto.model.Lotto;
import lotto.model.constants.Dividend;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringMethodTest {
    @Test
    void toStringTest() throws Exception {
        assertThat(Dividend.valueOf(3, false)).isEqualTo(Dividend.FIFTH);
    }
}
