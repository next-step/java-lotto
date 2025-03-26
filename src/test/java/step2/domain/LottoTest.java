package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.Lotto;

public class LottoTest {

    @Test
    void 로또번호는_중복되지않는다() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
            new Lotto(numbers);
        }).hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void 로또번호는_항상_6개이다() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5);
            new Lotto(numbers);
        }).hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    void 로또번호는_1에서_45사이의_숫자이다() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
            new Lotto(numbers);
        }).hasMessage("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
    }

    @Test
    void 지난주_로또_번호는_쉼표를_구분지어_입력한다() {
        String lastWeekLottoResult = "1, 2, 3, 4, 5, 6";
        Lotto lotto = new Lotto(lastWeekLottoResult);
        assertThat(lotto.lottoNumbers()).asList().containsExactly(1, 2, 3, 4, 5, 6);
    }

}
