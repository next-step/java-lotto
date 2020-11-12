package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    @Test
    @DisplayName("지난주 당첨번호를 입력합니다.")
    void create() {
        LottoMatcher lottoMatcher = new LottoMatcher("1 ,2 ,3 ,4 ,5 , 6");
        assertThat(lottoMatcher.getLottoNumbers()).hasSize(6);
        assertThat(lottoMatcher.getLottoNumbers()).containsExactly(1,2,3,4,5,6);
    }
}
