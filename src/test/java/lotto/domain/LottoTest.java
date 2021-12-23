package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @DisplayName("빈 생성자 호출시 size 6 의 List<LottoNumber> 멤버 변수를 가진 일급 컬렉션 Lotto를 생성한다.")
    @Test
    void create() {
        Lotto numbers = new Lotto();
        assertThat(numbers.getNumbers().stream().findFirst().get()).isInstanceOf(LottoNumber.class);
        assertThat(numbers.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("List<Integer> 를 전달 받아 Lotto를 생성한다.")
    @Test
    void createWithList() {
        Lotto numbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(numbers.getNumbers().stream().findFirst().get()).isInstanceOf(LottoNumber.class);
    }

    @DisplayName("List<Integer> size가 6이 아닌 경우 IllegalArgumentException throw 한다.")
    @Test
    void createExceptionWithSize() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("size는 항상 6");
    }

    @DisplayName("1~45 사이 정수가 아닌 경우 IllegalArgumentException throw 한다.")
    @Test
    void createExceptionWithNumber() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45 사이 값");
    }

    @DisplayName("containBonusNumber 함수는 보너스 번호를 포함하는지 boolean값을 반환한다.")
    @Test
    void containBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containLottoNumber(new LottoNumber(6))).isTrue();
        assertThat(lotto.containLottoNumber(new LottoNumber(7))).isFalse();
    }

}
