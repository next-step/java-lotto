package step4.iksoo.lottoManual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoesTest {
    private Lottoes customLottoes;

    @BeforeEach
    public void setUp() {
        customLottoes = new Lottoes();
        List<Lotto> lottoCustom = new ArrayList<>();
        lottoCustom.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoCustom.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        lottoCustom.add(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)));
        customLottoes.add(lottoCustom);
    }

    @Test
    void 로또_3000원으로_수동1장_자동2장_구입() {
        Lottoes lottoes = new Lottoes(3000, Arrays.asList("10, 11, 12, 13, 14, 15"));
        assertThat(lottoes.getLottoes().size()).isEqualTo(3);
        assertThat(lottoes.getLottoes().get(0)).isEqualTo(new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)));
    }

    @Test
    public void 로또결과_1등_1명_당첨() {
        assertThat(customLottoes.checkLotteryWin(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)), new LottoNo(5)).get(Rank.FIRST)).isEqualTo(1);
    }
}