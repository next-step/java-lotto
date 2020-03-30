package lotto_tests;

import lotto.AutomaticLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoTicket.LOTTO_NUMBER_SIZE;
import static lotto.model.wrapper.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.model.wrapper.LottoNumber.LOTTO_MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기 테스트")
public class LottoGeneratorTests {

    @DisplayName("자동 로또 번호 생성 테스트")
    @Test
    public void generateAutomaticTest() {
        assertThat(AutomaticLottoGenerator.generate())
                .hasSize(LOTTO_NUMBER_SIZE)
                .allMatch(number -> number.toInt() >= LOTTO_MIN_NUMBER && number.toInt() <= LOTTO_MAX_NUMBER);
    }

}
