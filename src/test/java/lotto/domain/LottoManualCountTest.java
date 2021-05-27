package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * LottoManualCount 클래스의 생성 및 기능 테스트
 */
public class LottoManualCountTest {

    @Test
    @DisplayName("잘못된 구매 수량 입력 예외 처리")
    void minus_count_throw() {
        assertThatThrownBy(() -> new LottoManualCount(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 20})
    @DisplayName("로또 수동 구매 개수 객체 생성")
    void create(int lottoCount) {
        LottoManualCount lottoManualCount = new LottoManualCount(lottoCount);
        assertThat(lottoManualCount.manualCount()).isEqualTo(lottoCount);
    }
}
