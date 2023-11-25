package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ManualCountTest {
    @Test
    @DisplayName("수동 구매 갯수는 음수일 수 없다.")
    void test1(){
        int number = -1;
        assertThatThrownBy(() -> new ManualCount(number))
                .hasMessageContaining("수동으로 구매할 로또는 음수일 수 없습니다.");
    }
}
