package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또를 생성한다")
    @Test
    void create() {
        Set<Number> numbers = mockLotto();
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLotto()).contains(Number.mock(1));
    }

    @DisplayName("랜덤 값을 가져온다")
    @Test
    void get_random() {
        Set<Number> numbers = mockLotto();
        Lotto lotto = new Lotto(numbers);
        Set<Number> random = lotto.getRandom();
        assertThat(random.size()).isEqualTo(6);
    }

    @DisplayName("로또를 구매한다")
    @Test
    void lotto_buy() {
        Lotto lotto = Lotto.buy();
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @DisplayName("당첨 로또를 생성한다")
    @Test
    void lotto_win() {
        Lotto win = Lotto.win(mockLotto());
        assertThat(win.getLotto()).contains(Number.win(1));
    }

    @DisplayName("로또의 숫자가 6자리 인지 체크한다")
    @Test
    void is_required_size() {
        assertThatThrownBy(() -> {
            Set<Number> numbers = mockInvalidLotto();
            Lotto.win(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호와 로또들의 번호를 비교한다")
    @Test
    void compare() {
        Lotto win = Lotto.win(mockLotto());
        Lotto mockFirst = Lotto.mock(mockFirst());
        Lotto mockSecond = Lotto.mock(mockSecond());
        int first = mockFirst.compare(win);
        int second = mockSecond.compare(win);
        assertThat(first).isEqualTo(6);
        assertThat(second).isEqualTo(5);
    }

    private Set<Number> mockInvalidLotto() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.win(1));
        numbers.add(Number.win(2));
        numbers.add(Number.win(3));
        numbers.add(Number.win(4));
        return numbers;
    }

    private Set<Number> mockLotto() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.mock(1));
        numbers.add(Number.mock(2));
        numbers.add(Number.mock(3));
        numbers.add(Number.mock(4));
        numbers.add(Number.mock(5));
        numbers.add(Number.mock(6));
        return numbers;
    }

    private Set<Number> mockFirst() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.mock(1));
        numbers.add(Number.mock(2));
        numbers.add(Number.mock(3));
        numbers.add(Number.mock(4));
        numbers.add(Number.mock(5));
        numbers.add(Number.mock(6));
        return numbers;
    }

    private Set<Number> mockSecond() {
        Set<Number> numbers = new HashSet<>();
        numbers.add(Number.mock(1));
        numbers.add(Number.mock(2));
        numbers.add(Number.mock(3));
        numbers.add(Number.mock(4));
        numbers.add(Number.mock(5));
        numbers.add(Number.mock(7));
        return numbers;
    }


}
