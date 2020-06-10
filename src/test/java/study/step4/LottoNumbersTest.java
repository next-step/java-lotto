package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import study.step4.domain.LottoNumbers;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @RepeatedTest(20)
    @DisplayName("로또 티켓은 6개의 번호로 되어 있는지 테스트")
    public void lottoNumberCountTest(){
        assertThat(LottoNumbers.getLottoNumbers())
                .hasSize(6);
    }
}
