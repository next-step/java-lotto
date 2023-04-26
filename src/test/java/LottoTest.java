import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {


    @Test
    @DisplayName("Lotto_생성_테스트")
    public void Lotto_생성_테스트(){

        Lotto k_lotto = new Lotto(new KLottoGenerator());

        List<Integer> numbers = k_lotto.getNumbers();
        String name = k_lotto.getName();

        assertThat(name).isEqualTo("K-Lotto");
        assertThat(numbers).containsAnyOf(1,2,3,4,5,6,7,8,9,10);
    }
}
