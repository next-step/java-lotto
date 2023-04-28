package step2.domain.strategy.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.LottoService;
import step2.domain.model.Lotto.LottoNumbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottoPolicyStrategyTest {
    private LottoPolicyStrategy lottoPolicyStrategy;

    @BeforeEach
    void setLottoService() {
        this.lottoPolicyStrategy = new LottoPolicyStrategy();
    }

    @Test
    void 로또번호갯수테스트() {
        LottoNumbers lottoNumber = lottoPolicyStrategy.createLottoNumbers();
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 당첨번호콤마미입테스트() {
        assertThatThrownBy(() -> lottoPolicyStrategy.createWinningLottoNumber("1234578909"))
                .isInstanceOf(IllegalStateException.class);

    }

    @Test
    void 당첨번호한글입력테스트() {
        assertThatThrownBy(() -> lottoPolicyStrategy.createWinningLottoNumber("ㄱㄴㅇㅁㄹㅎㄷ"))
                .isInstanceOf(NumberFormatException.class);

    }
}
