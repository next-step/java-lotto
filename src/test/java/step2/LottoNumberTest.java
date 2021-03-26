package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void make_lotto(){
        LottoNumber number = new LottoNumber(5);
        assertThat(number).isEqualTo(new LottoNumber(5));
    }

    @Test
    @DisplayName("로또 번호 정상번호인지 테스트 - 비정상이면 IllegalArgumentException 발생")
    void is_normal_lotto_number_passive(){
        assertThatThrownBy(()->{
            LottoNumber number = new LottoNumber(-3);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
