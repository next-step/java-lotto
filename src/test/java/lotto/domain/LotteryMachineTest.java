package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {
    private Lotto lotto;

    @BeforeEach
    void setUp_1부터_6까지_번호_로또_생성() {
        lotto = new Lotto(new LottoNumbers().numbers()
                .stream()
                .limit(6)
                .collect(Collectors.toList()));
    }

//    @ParameterizedTest
//    @CsvSource(value = {"1,2,3,4,5,6:6", "6,7,8,9,10,11:1", "12,13,14,15,16,17:0"}, delimiter = ':')
//    void 일치하는_로또번호_개수(String input, int result) {
//        WinningLotto winningLotto = new WinningLotto(input, "45");
//
//        assertThat(new LotteryMachine(winningLotto, new Amount(5000))
//                .correctCount(lotto))
//                .isEqualTo(result);
//    }
}