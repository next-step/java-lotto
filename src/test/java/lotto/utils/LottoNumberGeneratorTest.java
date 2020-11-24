package lotto.utils;

import lotto.domain.Lottoes;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("1~45까지 6개의 번호를 14개 생성한다.")
    void should_return_lotto_numbers() {
        //Given & When
        Lottoes lottoes = LottoNumberGenerator.create(new PurchaseAmount(14000));

        //Then
        assertThat(lottoes.getValue().size()).isEqualTo(14);
    }
}
