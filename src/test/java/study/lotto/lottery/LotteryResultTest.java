package study.lotto.lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.core.LottoRank;
import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.Lottos;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryResultTest {

    private List<String> lottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    private static final String bonusLottoNumber = "7";

    @Test
    void test_LotteryResult() {
        // Given
        Lotto lotto = new Lotto(toLottoNumbers(lottoNumbers));
        WinLottoNumbers.WinLottoNumbersBuilder builder = new WinLottoNumbers.WinLottoNumbersBuilder(lottoNumbers);
        builder.bonusLottoNumber(bonusLottoNumber);
        WinLottoNumbers winLottoNumbers = builder.build();
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        Lottery lottery = new Lottery(winLottoNumbers, lottos);

        // When
        LotteryResult lotteryResult = lottery.checkLotto();

        // Then
        Long numberOfLottoRank = lotteryResult.getNumberOfLottoRank(LottoRank.FIRST);
        String totalReturnRatio = lotteryResult.getTotalReturnRatio();
        assertThat(numberOfLottoRank).isEqualTo(1L);
        assertThat(totalReturnRatio).isEqualTo("");
    }

    @Test
    @DisplayName("DecimalFormat 연습")
    void test_decimalFormat() {
        // Given
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double pi = 3.141592;
        double e = 2.7182818284;

        // When & Then
        System.out.println(decimalFormat.format(pi));
        System.out.println(decimalFormat.format(e));
    }

    private Set<LottoNumber> toLottoNumbers(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

}