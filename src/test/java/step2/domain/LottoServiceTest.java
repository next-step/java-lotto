package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setLottoService() {
        this.lottoService = new LottoService(20);
    }

    @Test
    void 지정된_로또_갯수이상일때() {
        assertThatThrownBy(() -> LottoService.createWinningLotto("1,2,3,4,5,6,7,8,9"))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 지정된_로또_카운트가_음수일때() {
        assertThatThrownBy(() -> LottoService.of(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지정된_로또_번호가_이상할때() {
        assertThatThrownBy(() -> LottoService.createWinningLotto("1,2,3,4,5,6,ㄱ"))
                .isInstanceOf(NumberFormatException.class);
    }
}
