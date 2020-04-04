package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoGameInfo;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    Lotto lotto;
    LottoGameInfo lottoGameInfo;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("로또번호 갯수체크")
    @Test
    public void 로또번호_갯수체크() {
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또구매 갯수체크")
    @Test
    public void 로또구매_갯수체크() {
        assertThat(lottoGameInfo.ticketCount(14000)).isEqualTo(14);
    }

    @DisplayName("로또 가격 정합성 체크")
    @Test
    public void 로또가격체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoGameInfo(999);
        });
    }

}
