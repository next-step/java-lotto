package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {

    @ParameterizedTest
    @ValueSource(ints = {999, 0, -122})
    void 정수_1000이하_1000_단위_유효성_검사(int amount){
        LottoFactory lottoFactory = new AutoLottoFactory();
        LottoGame lottoGame = new LottoGame(lottoFactory);

        assertThatIllegalArgumentException().isThrownBy(
                ()->lottoGame.numberOfLottoPurchases(amount)
        ).withMessageContaining("로또 개당 가격은 1,000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {5020, 1200, 99999})
    void 로또_구매_가능_횟수_테스트(int amount){
        LottoFactory lottoFactory = new AutoLottoFactory();
        LottoGame lottoGame = new LottoGame(lottoFactory);
        int count = lottoGame.numberOfLottoPurchases(amount);

        assertThat(count).isEqualTo(amount/1000);
    }
}
