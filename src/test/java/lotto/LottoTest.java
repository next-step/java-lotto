package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @DisplayName("로또 구입금액을 입력하면 금액만큼의 로또를 발급 해준다")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "3000:3", "4000:4"}, delimiterString = ":")
    void buyLotto(int money, int expected){
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.issue(money);

        assertThat(lottos).hasSize(expected);
    }

}
