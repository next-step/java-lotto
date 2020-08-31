package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerNumberManagerTest {

    @DisplayName("상금 테스트")
    @Test
    void sumOfWinnerPrice(){
        String[] input = "1,2,3,4,5,6".split(",");
        List<Integer > list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(list));

        WinnerNumberManager mag = new WinnerNumberManager(new WinnerNumber(input));
        assertThat(mag.calculateWinnerPrice(lottos)).isEqualTo(2_000_000_000);
    }
}
