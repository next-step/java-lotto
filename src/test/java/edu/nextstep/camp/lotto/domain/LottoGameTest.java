package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {

    @ParameterizedTest
    @ValueSource(ints = {999, 1999, -122})
    void 정수_1000이하_1000_단위_유효성_검사(int amount){
        LottoFactory lottoFactory = new AutoLottoFactory();
        LottoGame lottoGame = new LottoGame(lottoFactory);

        assertThatIllegalArgumentException().isThrownBy(
                ()->lottoGame.buyLotto(amount)
        ).withMessageContaining("구매 금액은 1,000 단위로 입력 하세요.");
    }
}
