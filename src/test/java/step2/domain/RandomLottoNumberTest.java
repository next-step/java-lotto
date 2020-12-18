package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoNumberTest {
    @DisplayName("로또 티켓 번호가 6개 생성 여부")
    @RepeatedTest(10)
    public void validateSixLottoNumbers(){
        assertThat(new RandomLottoNumber().getLottoNumbers()).hasSize(6);
    }
}