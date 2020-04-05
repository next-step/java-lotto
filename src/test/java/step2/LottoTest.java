package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.*;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    Lotto lotto;
    LottoGameInfo lottoGameInfo;
    LottoWinningInfomation lottoWinningInfomation;
    LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        lottoWinningNumber = new LottoWinningNumber("1,2,3,4,5,6");
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
        System.out.println(lottoWinningInfomation.matchCountInformation(3).getPrice());
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoGameInfo(999);
        });
    }



}
