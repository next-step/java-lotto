package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    @Test
    @DisplayName("예산에따라 로또의 갯수를 구하는 테스트")
    void getLottoQuantityByBudgetTest() {
        assertThat(LottoService.getLottoQuantityByBudget(14000)).isEqualTo(14);

        assertThat(LottoService.getLottoQuantityByBudget(900)).isEqualTo(0);
    }
}
