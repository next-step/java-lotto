package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_생성(){
        assertThat(new Lotto(List.of(1,2,3,4,5,6))).isEqualTo(new Lotto(List.of(1,2,3,4,5,6)));
    }

    @Test
    void 로또_문자열파싱(){
        assertThat(new Lotto("1,2,3,4 ,5,6")).isEqualTo(new Lotto(List.of(1,2,3,4,5,6)));
    }

    @Test
    void 로또_번호모자람(){
        assertThatThrownBy(() -> {
            new Lotto(List.of(1,2,3,4,5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 6개입니다.");
    }

    @Test
    void 로또_번호초과(){
        assertThatThrownBy(() -> {
            new Lotto(List.of(1,2,3,4,5,6,7));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 6개입니다.");
    }

    @Test
    void 로또_번호중복(){
        assertThatThrownBy(() -> {
            new Lotto(List.of(1,2,3,4,5, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호 중복 불가!");
    }

}
