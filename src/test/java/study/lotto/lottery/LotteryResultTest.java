package study.lotto.lottery;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.core.LottoRank;
import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.Lottos;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LotteryResultTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void createLottoNumbers() {
        this.lottoNumbers = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }

    @Test
    void test_LotteryResult() {
        // Given
        Lotto lotto = new Lotto(lottoNumbers);
        WinLottoNumbers winLottoNumbers = new WinLottoNumbers(lottoNumbers);
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        Lottery lottery = new Lottery(winLottoNumbers, lottos);

        // When
        LotteryResult lotteryResult = lottery.checkLotto();

        // Then
        Long numberOfLottoRank = lotteryResult.getNumberOfLottoRank(LottoRank.FIRST);
        double totalReturnRatio = lotteryResult.getTotalReturnRatio();
        assertThat(numberOfLottoRank).isEqualTo(1L);
        assertThat(totalReturnRatio > 1.0).isTrue();
    }

}