package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    void 로또번호_객체를_생성한다() {
        //Given
        int randomNumber = 39;
        LottoNumber lottoNumber = LottoNumber.from(randomNumber);

        //When
        //Then
        assertThat(lottoNumber.getNumber()).isEqualTo(39);
    }
}
