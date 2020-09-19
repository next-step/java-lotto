package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 리스트 생성")
    public void generateLottoList() {
        assertThat(LottoGenerator.generateLottoList(1).size())
                .isEqualTo(1);
    }

}
