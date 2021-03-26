package step2.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGenerateCountTest {

    @DisplayName("LottoGenerateCount 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int testMoney = 1000;

        // when
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.newInstance(testMoney);

        // then
        assertThat(lottoGenerateCount).isNotNull();
    }
}