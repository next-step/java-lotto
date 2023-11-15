package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    Lotto lottoFixture(Integer... numbers){
        return new Lotto(Stream.of(numbers)
                    .map(LottoNumber::of)
                    .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("당첨번호를 입력으로 넣으면 당첨금 2_000_000_000원이다.")
    void winningLottoTest() {
        // given
        Lotto winningNumbersLotto = lottoFixture(1, 2, 3, 4, 5, 6);

        Lottos lottos = new Lottos();
        lottos.addLotto(winningNumbersLotto);
        WinningInfos winningInfos = new WinningLotto(winningNumbersLotto).winningInfos(lottos);

        assertThat(winningInfos.earningMoney()).isEqualTo(2_000_000_000);
    }
}
