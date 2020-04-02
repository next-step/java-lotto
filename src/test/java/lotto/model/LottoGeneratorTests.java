package lotto.model;

import lotto.AutomaticLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoTicket.LOTTO_NUMBER_SIZE;

@DisplayName("로또 번호 생성기 테스트")
public class LottoGeneratorTests {

    @DisplayName("자동 로또 번호 생성 테스트")
    @Test
    public void generateAutomaticTest() {
        Assertions.assertThat(AutomaticLottoGenerator.generate())
                .hasSize(LOTTO_NUMBER_SIZE);
    }

}
