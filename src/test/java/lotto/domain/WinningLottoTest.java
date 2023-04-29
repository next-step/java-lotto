package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

@DisplayName("당첨 로또 테스트")
class WinningLottoTest {

    @DisplayName("승리 로또와 일치하는 번호의 카운트를 확인할수 있다")
    @Test
    void winningLotto_create_success() {
        String winningNumbersString = "1,2,3,4,5,6";
        WinningLotto winningLotto = WinningLottoFactory.create(winningNumbersString);

        LottoTicket lottoTicket = new LottoTicket(new TreeSet<>(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(7)
        )));

        int countOfMatch = winningLotto.countOfMatch(lottoTicket);

        Assertions.assertThat(countOfMatch).isEqualTo(5);
    }

}