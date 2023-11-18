package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또_번호_1부터_45사이의_수를_생성한다")
    void 로또_번호_1부터_45사이의_수를_생성한다() {
        Lotto lotto = new Lotto();

        List<Integer> result = lotto.createNumber();

        assertThat(result).size().isBetween(1, 45);
    }

    @Test
    @DisplayName("로또 한장의 번호 갯수는 6개이다")
    void 로또_한장의_번호_갯수는_6개이다() {
        Lotto lotto = new Lotto();

        List<Integer> result = lotto.createNumber();

        assertThat(result.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호를 오름차순으로 정렬한다")
    void 로또_번호를_오름차순으로_정렬한다() {
        Lotto lotto = new Lotto();

        List<Integer> result = lotto.createNumber();
        int firstNumber = result.get(0);
        int lastNumber = result.get(44);

        assertThat(firstNumber).isEqualTo(1);
        assertThat(lastNumber).isEqualTo(45);
    }
}
