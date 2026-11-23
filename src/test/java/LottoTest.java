import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {


    @Test
    void 로또_숫자가_1부터_45사이의_아닐경우_예외가_발생한다() {

        List<Integer> numbers = List.of(1,2,3,4,5,46);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 로또_숫자는_6개가_아닐_경우_예외가_발생한다() {

        List<Integer> numbers = List.of(1,2,3,4,5,6,7);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    void 로또는_6개의_숫자를_가져야_한다() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Assertions.assertThat(numbers).hasSize(6);
    }

}
