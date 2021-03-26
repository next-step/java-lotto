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

    @DisplayName("LottoGenerateCount 인스턴스가 다음 시점으로 넘어갈 수 있는지 테스트")
    @Test
    void 다음() {
        // given
        int testMoney = 1000;

        // when
        LottoGenerateCount lottoGenerateCount = LottoGenerateCount.newInstance(testMoney);
        boolean actual = lottoGenerateCount.hasNext();

        // then
        assertThat(actual).isTrue();
    }
}