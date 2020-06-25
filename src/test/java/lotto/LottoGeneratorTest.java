package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또가 생성시에 몇개 생성됐는지 체크")
    public void generateAuto() {
        //When
        Lotto lotto = LottoGenerator.generateAuto();

        //Then
        assertThat(lotto.size()).isEqualTo(6);
    }
}