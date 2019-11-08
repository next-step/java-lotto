package lottery.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lottery.dto.LottoTries;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTriesTest {

    @Test
    void 총_회수보다_수동_회수가_많을때_예외테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoTries(1, 10);
        }).withMessage("올바른 이용 횟수가 아닙니다.");
    }

    @Test
    void 유효하지않은_수동회수_입력시_예외테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoTries(1, -1);
        }).withMessage("올바른 이용 횟수가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "1:1", "100:50"}, delimiter = ':')
    void 정상회수_입력시_예외테스트(int totalTries, int manualTries) {
        LottoTries lottoTries = new LottoTries(totalTries, manualTries);
        assertThat(lottoTries.getManualTries()).isEqualTo(manualTries);
        assertThat(lottoTries.getRandomTries()).isEqualTo(totalTries - manualTries);
    }
}