package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("생성자 리스트의 길이가 6이 아닌경우 예외발생 테스트")
    void lottoNumbersTest() {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);

        List<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5, 6, 7).collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(numbers2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일한 숫자가 몇개인지 세는 로직 테스트")
    void getMatchTest() {
        List<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        List<Integer> numbers2 = Stream.of(7, 8, 9, 10, 11, 12).collect(Collectors.toList());

        Lotto lotto1 = new Lotto(numbers1);
        Lotto lotto2 = new Lotto(numbers2);

        assertThat(lotto1.countMatch(lotto2)).isEqualTo(0);

        List<Integer> numbers3 = Stream.of(5, 6, 7, 8, 9, 10).collect(Collectors.toList());

        Lotto lotto3 = new Lotto(numbers3);

        assertThat(lotto1.countMatch(lotto3)).isEqualTo(2);
    }
}
