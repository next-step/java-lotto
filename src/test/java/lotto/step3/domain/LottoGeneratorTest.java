package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    @DisplayName("랜덤 로또번호 생성 - 6자리, 중복값 x")
    void createLottoNumber() {
        List<LottoNumber> numbers = LottoGenerator.createAutoLotto();
        assertThat(numbers).size().isEqualTo(6);
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력된 당첨번호 6자리, 1~45, 중복값 x,  만족 못하면 -> IllegalArgumentException")
    void CreateWinningNumbers() {
        assertThatThrownBy(() -> LottoGenerator.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoGenerator.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoGenerator.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoGenerator.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        //정상입력
        assertThatCode(() -> LottoGenerator.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

}