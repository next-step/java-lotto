package lotto.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {
    @Test
    @DisplayName("(입력 받은 값 / 1000) 장 만큼 자동으로 로또 발급하기.")
    void issueLotto() {
        LotteryMachine lotteryMachine = new LotteryMachine();
        List<List<LottoNumber>> lotteryTickets = lotteryMachine.issueLotto(2, lottoNumbers -> lottoNumbers);
        
        List<List<LottoNumber>> tmpLotteryTickets = new ArrayList<>();
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        tmpLotteryTickets.add(lottoNumbers);
        tmpLotteryTickets.add(lottoNumbers);
        
        assertThat(lotteryTickets).isEqualTo(tmpLotteryTickets);
    }
}
