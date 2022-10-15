package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3", "1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("입력한 숫자가 6개가 아닌 경우 Lotto 객체를 생성할 수 없다.")
    void create_withNot6Numbers(String input) {
        assertThatThrownBy(() -> new Lotto(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("6개의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("getNumber 메소드는 오름차순으로 정렬된 LottoNumber 리스트를 반환한다.")
    void getNumber() {
        Lotto lotto = new Lotto("3, 6, 1, 22, 19, 35");

        assertThat(lotto.getNumbers()).containsExactly(
            new LottoNumber(1), new LottoNumber(3), new LottoNumber(6), new LottoNumber(19),
            new LottoNumber(22), new LottoNumber(35));
    }

    @Test
    @DisplayName("countSameNumbers 메소드는 주어진 로또와 일치하는 숫자의 개수를 반환한다.")
    void countSameNumbers() {
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("1, 2, 3, 7, 8, 9");

        assertThat(lotto1.countSameNumbers(lotto2)).isEqualTo(3);
    }
}
