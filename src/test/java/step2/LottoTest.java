package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 수동 생성 테스트")
    void make_lotto(){
        LottoNumber number = new LottoNumber(5);
        assertThat(number).isEqualTo(new LottoNumber(5));
    }

    @Test
    @DisplayName("로또 번호 자동 생성 테스트")
    void make_automatically_lotto(){
        LottoNumber number = new LottoNumber(() -> 5);
        assertThat(number).isEqualTo(new LottoNumber(5));
    }

    @Test
    @DisplayName("로또 번호 정상번호인지 테스트 - 비정상이면 IllegalArgumentException 발생")
    void is_normal_lotto_number(){
        assertThatThrownBy(()->{
            LottoNumber number = new LottoNumber(() -> -1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
