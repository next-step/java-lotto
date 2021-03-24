package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 수동 생성 테스트")
    void make_lotto(){
        Lotto lotto = new Lotto(5);
        assertThat(lotto).isEqualTo(new Lotto(5));
    }

    @Test
    @DisplayName("로또 번호 자동 생성 테스트")
    void make_automatically_lotto(){
        Lotto lotto = new Lotto(() -> 5);
        assertThat(lotto).isEqualTo(new Lotto(5));
    }
}
