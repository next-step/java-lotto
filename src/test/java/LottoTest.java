import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void match(){
        Lotto lotto_1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto_2 = new Lotto(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8)));

        assertThat(lotto_1.match(lotto_2)).isEqualTo(4);
        assertThat(lotto_2.match(lotto_1)).isEqualTo(4);
    }
}
