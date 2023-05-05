package lotto;

import lotto.utile.Deduplicator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeduplicatorTest {
    @Test
    @DisplayName("배열에서 중복값이 있는경우 테스트(중복있는경우 -1 리턴)")
    void checkDuplicationTrue() {
        assertThat(Deduplicator.checkDuplication(new int[]{1, 2, 3, 4, 5, 6}, 4)).isEqualTo(-1);
    }

    @Test
    @DisplayName("배열에서 중복값이 없는경우 테스트(중복있는경우 -1 리턴)")
    void checkDuplicationFalse() {
        assertThat(Deduplicator.checkDuplication(new int[]{1, 2, 3, 4, 5, 6}, 7)).isEqualTo(0);
    }
}
