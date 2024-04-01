package lottery.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void lottoNumberTest(){
        final LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));

        assertThatThrownBy(() -> {
            new LottoNumber(LottoNumber.MAX_NUMBER + 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 " + LottoNumber.MIN_NUMBER + "부터 " + LottoNumber.MAX_NUMBER + "사이여야 합니다.");
    }
}
