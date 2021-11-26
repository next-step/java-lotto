package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static lotto.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private Map<Prize, Integer> dummy;

    @BeforeEach
    void setUp() {
        dummy = new HashMap<>();
        dummy.put(FIRST, 1);
        dummy.put(SECOND, 1);
        dummy.put(THIRD, 1);
        dummy.put(FOURTH, 1);
        dummy.put(FIFTH, 1);
        dummy.put(NONE, 1);
    }

    @Test
    void create() {
        // given
        LottoResult self = new LottoResult(dummy);

        // when
        LottoResult other = new LottoResult(dummy);

        // then
        assertThat(self).isEqualTo(other);
    }
}
