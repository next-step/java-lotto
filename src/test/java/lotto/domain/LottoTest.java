package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void createTest() {
        List<Integer> test = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = Lotto.from(test);

        assertThat(lotto).isEqualTo(Lotto.from(test));
    }

    @Test
    @DisplayName("1~45 랜덤 함수 생성 기능")
    void randomCreateTest() {
        Lotto autoLotto = new Lotto();
        List<Integer> lottoRandomNumbers = autoLotto.getNumbers();

        assertThat(lottoRandomNumbers).size().isEqualTo(6);
        assertThat(lottoRandomNumbers).doesNotContain(46);
        assertThat(lottoRandomNumbers).doesNotContain(0);
        assertThat(lottoRandomNumbers.stream().distinct().collect(toList())).size().isEqualTo(6);;
    }

    @Test
    @DisplayName("예외 검증")
    void exceptionTest() {
        assertThatThrownBy(() -> Lotto.from(Arrays.asList(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.from(Arrays.asList(1,2,3)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.from(Arrays.asList(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.from(Arrays.asList(0,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
