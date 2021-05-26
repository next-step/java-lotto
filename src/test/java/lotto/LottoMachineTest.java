package lotto;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicketCount;

public class LottoMachineTest {

    List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void init() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.range(1, 7).forEach(i -> {
            lottoNumbers.add(LottoNumber.of(i));
        });
        lottos.add(new Lotto(lottoNumbers));
    }

    @ParameterizedTest(name = "결과 테스트")
    @CsvSource(value = {"1,2,3,10,11,12:5000", "1,2,3,4,11,12,3:50000", "1,2,3,4,5,11:1500000", "1,2,3,4,5,6:2000000000"}, delimiter = ':')
    public void result(String inputs, long expcted) {
        // given
        Lotto winLotto = new Lotto(inputs.split(","));

        // when
        LottoMachine lottoMachine = LottoMachine.of(lottos);
        long sum = lottoMachine.result(winLotto).sum();

        // then
        assertThat(sum).isEqualTo(expcted);
    }


    @Test
    @DisplayName("보너스 결과 테스트")
    public void resultWithBonus() {
        // given
        Lotto winLotto = new Lotto("1,2,3,4,5,7".split(","));

        // when
        LottoMachine lottoMachine = LottoMachine.of(lottos);
        long sum = lottoMachine.result(winLotto, LottoNumber.of(6)).sum();

        // then
        assertThat(sum).isEqualTo(30000000);
    }


    @Test
    @DisplayName("자동 구매 테스트")
    public void buyAutoLotto() {
        // given
        List<Lotto> lottos = LottoMachine.generateAutoLottos(new LottoTicketCount(2));
        // when & then
        assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동 구매 테스트")
    public void buyManualLotto() {
        String[] input = {"1,2,3,4,5,6", "10,11,12,13,14,15"};
        List<String> test = Arrays.stream(input).collect(toList());
        // given
        List<Lotto> lottos = LottoMachine.generateManualLottos(test);
        // when & then
        assertThat(lottos.size()).isEqualTo(2);
    }

}
