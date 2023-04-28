package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.model.Lotto.Lottos;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ProfitCalculatorServiceTest {

    private ProfitCalculatorService profitCalculatorService;

    @BeforeEach
    void setLottoService() {
        this.profitCalculatorService = ProfitCalculatorService.of(Lottos.from(5), 14000);
    }

    @Test
    void 금액잘못입력시테스트() {
        assertThatThrownBy(() -> ProfitCalculatorService.of(Lottos.from(5), -1))
                .isInstanceOf(IllegalStateException.class);

    }
}
