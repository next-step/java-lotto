package lotto.domain.number;

import lotto.domain.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("LottoNumbers 클래스 테스트")
public class LottoNumbersTest {

    @DisplayName("NumberGenerator 타입을 주입 받아 LottoNumbers 객체를 생성할 수 있다.")
    @Test
    void createLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGenerator());

        assertThat(lottoNumbers.getNumbers()).hasSize(6);
    }
}
