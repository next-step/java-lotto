import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void match(){
        Lotto lotto_1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto_2 = new Lotto(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8)));

        assertThat(lotto_1.match(lotto_2)).isEqualTo(new MatchCount(4));
        assertThat(lotto_2.match(lotto_1)).isEqualTo(new MatchCount(4));
    }

    @Test
    void invalid(){
        assertThatThrownBy(
                () -> new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 47)))
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> new Lotto(new ArrayList<>(Arrays.asList(-1, -2, -3, -4, -5, -6)))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}