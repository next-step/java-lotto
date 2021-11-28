package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("빈 생성자 호출시 빈 생성자로 생성한 Numbers를 멤버 변수로 가지는 Lotto를 생성한다.")
    @Test
    void create() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers()).isInstanceOf(Numbers.class);
    }

}
