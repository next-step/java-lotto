package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoFactoryTest {
    @DisplayName("로또 금액에 맞는 로또 리스트 개수가 나와야 한다.")
    @ParameterizedTest
    @ValueSource(ints={1_000, 5_000, 14_000, 30_000})
    public void testLottosSize(int lottoAmounts) {
        LottoFactory lottoFactory = new LottoFactory(lottoAmounts);
        List<Lotto> lottos = lottoFactory.createLottos();

        int lottoCounts = lottoAmounts / LottoFactory.SINGLE_LOTTO_AMOUNT;
        assertThat(lottos).hasSize(lottoCounts);
        assertThat(lottoFactory.getLottoCounts()).isEqualTo(lottoCounts);
    }
}
