package lotto;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class StringMethodTest {
    @Test
    void toStringTest() throws Exception {
        List<Integer> numbers = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));
        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto);
    }
}
