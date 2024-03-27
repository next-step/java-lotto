package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottosTest {
    @DisplayName("로또 금액은 1000의배수.")
    @Test
    void price_lotto(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BuyLottos(14500);
        });
    }
    @DisplayName("로또 개수는 금액/1000.")
    @Test
    void count_lotto(){
        BuyLottos buyLottos = new BuyLottos(14000);
        assertThat(buyLottos.getCountOfLotto()).isEqualTo(14);
    }

    @DisplayName("지정한 수동 개수만큼 수동 로또 생성")
    @Test
    void manual_lotto(){
        List<String> manualLotto=Arrays.asList("1,2,3,4,5,6","1,2,3,45,5,7");
        BuyLottos buyLottos = new BuyLottos(14000,manualLotto);
        assertThat(buyLottos.getLottos().size()).isEqualTo(2);
    }

    @DisplayName("수동 로또도 6개 원소 입력 필요")
    @Test
    void manual_element_lotto(){
        List<String> manualLotto=Arrays.asList("1,2,3,4,5","1,2,3,45,5,7");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BuyLottos(14000,manualLotto);
        });
    }

    @DisplayName("수동 로또도 원소는 1~45 사이")
    @Test
    void manual_element_boundary_lotto(){
        List<String> manualLotto=Arrays.asList("1,2,3,4,5,50","1,2,3,45,5,7");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BuyLottos(14000,manualLotto);
        });
    }

}
