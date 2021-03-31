package study.step4;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step4.domain.Lotto;
import study.step4.domain.LottoMoney;
import study.step4.domain.LottoFactory;
import study.step4.domain.LottoNumber;
import study.step4.domain.LottoTicketCount;
import study.step4.domain.Lottos;

public class LottoFactoryTest {

    @Test
    @DisplayName("자동 구매 테스트")
    public void buyAutoLotto() {
        // given
        Lottos lottos = LottoFactory.buyAutoLotto(new LottoTicketCount(2));
        // when & then
        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 구매 테스트")
    public void buyManualLotto() {
        String[] input = {"1,2,3,4,5,6", "10,11,12,13,14,15"};
        List<String> test = Arrays.stream(input).collect(toList());
        // given
        Lottos lottos = LottoFactory.buyManualLotto(test);
        // when & then
        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 구매 테스트 - 객체 비교")
    public  void buyManyalLotto2() {
        // given
        String[] input = {"1,2,3,4,5,6"};
        List<String> manualLotto = Arrays.stream(input).collect(toList());
        // when
        Lottos lottos = LottoFactory.buyManualLotto(manualLotto);
        // then
        assertThat(lottos.getLottos()).containsExactly(new Lotto(Arrays.asList(LottoNumber.of(1),
            LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))));
    }

    @ParameterizedTest(name = "구매 테스트")
    @CsvSource(value = {"2000:2", "3000:3", "12000:12"}, delimiter = ':')
    public void buy(int input, int expected) {
        // given
        LottoMoney lottoMoney = new LottoMoney(input);
        int buyableCount = lottoMoney.buyableCount(new LottoTicketCount(2));
        LottoTicketCount autoCount = new LottoTicketCount(buyableCount);
        String[] inputString = {"1,2,3,4,5,6", "10,11,12,13,14,15"};
        List<String> test = Arrays.stream(inputString).collect(toList());
        // when
        Lottos lottos = LottoFactory.buy(autoCount, test);
        // then
        assertThat(lottos.getLottos().size()).isEqualTo(expected);
    }

}


