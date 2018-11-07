package raffle.lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또입력확인(){
        List<Integer> number = Arrays.asList(1, 6 , 5 , 44 , 22 , 15);
        Lotto lotto = new Lotto(number);

        assertThat(lotto.getLottoNumber().size()).isEqualTo(6);
    }
}