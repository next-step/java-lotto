package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("랜덤한 로또번호를 생성에 성공한다")
    @Test
    void createLottoSuccess() {
        Lotto lotto = LottoGenerator.generate();
        assertThat(lotto).isNotNull();
    }

    @DisplayName("수동으로 번호를 생성하는데 성공한다")
    @Test
    void generateLotto() {
        List<Number> numbers = LottoTest.ofNumbers(1, 2, 3, 4, 5, 6);

        Lotto result = LottoGenerator.generate(numbers);

        assertThat(result).isEqualTo(ofLotto(1, 2, 3, 4, 5, 6));
    }
}