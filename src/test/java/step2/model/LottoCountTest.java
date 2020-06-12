package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @DisplayName("정적 생성자는 LottoCount 인스턴스를 반환")
    @ValueSource(ints = {1000, 2000, 3000})
    @ParameterizedTest
    void valueOf(int count) {
        LottoCount lottoCount = LottoCount.valueOf(count);

        assertThat(lottoCount).isInstanceOf(LottoCount.class);
        assertThat(lottoCount.getValue()).isEqualTo(count);
    }

    @DisplayName("정적 생성자는 1보다 작은 숫자를 입력하면 예외를 발생")
    @Test
    void valueOfExceptionThrown() {
        assertThatThrownBy(() -> LottoCount.valueOf(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 개수가 초과하면 True 반환")
    @Test
    void isOverManualCount() {
        LottoCount lottoCount = LottoCount.valueOf(1);
        ManualLottoNumbers manualLottoNumbers = LottoData.createManualLottoNumbers(2);

        assertThat(lottoCount.isOverManualCount(manualLottoNumbers)).isTrue();
    }
}
