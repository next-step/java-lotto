package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoGameInfo;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    LottoGameInfo lottoGameInfo;
    Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoGameInfo = new LottoGameInfo(14000);
        lotto = new Lotto();
    }

    @DisplayName("로또 구매")
    @Test
    public void 로또구매() {
        assertThat(lottoGameInfo.getCountOfLotto()).isEqualTo(14);
    }

    @DisplayName("로또번호 추출")
    @Test
    public void 로또번호추출() {
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}
