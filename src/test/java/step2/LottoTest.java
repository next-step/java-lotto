package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("생성자 리스트의 길이가 6이 아닌경우 예외발생 테스트")
    void lottoNumbersTest() {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(()-> numbers)).isInstanceOf(IllegalArgumentException.class);

        List<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5, 6, 7).collect(Collectors.toList());

        assertThatThrownBy(() -> new Lotto(() -> numbers2)).isInstanceOf(IllegalArgumentException.class);
    }
}
