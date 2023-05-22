package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto.Lotto;
import step2.domain.Lotto.LottoNum;
import step2.domain.Lotto.LottoNums;
import step2.domain.Lotto.WinningLotto;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("")
    void lotto_winningsCheck() {
        String lottoNums = "15, 17, 18, 13, 44, 2";
        LottoNums.Builder lottoNumBuilder = new LottoNums.Builder();
        Arrays.stream(lottoNums.split(","))
                .sorted()
                .forEach(num -> lottoNumBuilder.lottoNum(new LottoNum(num.trim())));
        Lotto lotto = new Lotto(new LottoNums(lottoNumBuilder));
        WinningLotto winningLotto = new WinningLotto(lottoNums);
        assertThat(lotto.getRank(winningLotto.getWinningLottoNums())).isEqualTo(new Rank(6));
    }
}
