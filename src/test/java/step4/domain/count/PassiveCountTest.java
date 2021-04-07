package step4.domain.count;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PassiveCountTest {

    @DisplayName("PassiveCount 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int count = 0;

        // when
        PassiveCount passiveCount = PassiveCount.valueOf(count);

        // then
        assertThat(passiveCount).isNotNull();
    }
}