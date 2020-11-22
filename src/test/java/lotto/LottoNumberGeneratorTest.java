package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("1~45까지 6개의 번호를 14개 생성한다.")
    void should_return_lotto_numbers() {
        //Given & When
        List<LottoNumbers> numbers = LottoNumberGenerator.create(14);



        //Then
        assertThat(numbers.size()).isEqualTo(14);
    }
}
