package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoNumbersTest {

    @DisplayName("정적 생성자는 null을 입력하면 예외 발생")
    @Test
    void createExceptionThrown() {
        assertThatThrownBy(() -> ManualLottoNumbers.create(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 번호를 입력하지 않으면 수동 개수는 0을 반환")
    @Test
    void empty() {
        ManualLottoNumbers manualLottoNumbers = ManualLottoNumbers.empty();
        assertThat(manualLottoNumbers.getManualCount()).isEqualTo(0);
    }

    @DisplayName("로또 번호를 로또객체를 리스트로 반환")
    @Test
    void toLottos() {
        ManualLottoNumbers manualLottoNumbers = LottoData.createManualLottoNumbers(10);
        manualLottoNumbers.toLottos()
                .forEach(lotto -> assertThat(lotto).isInstanceOf(Lotto.class));
    }
}
