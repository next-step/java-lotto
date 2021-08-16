import domain.Lotto;
import domain.LottoPrizeType;
import domain.Lottos;
import domain.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottosTest {

    private Lotto lotto;

    @Test
    @BeforeEach
    public void 로또만들기() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);

        lotto = new Lotto(() -> lottoNumbers);
    }

    @Test
    public void 당첨로또와동일한경우_1등당첨_테스트() {
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        WinningStatistics winningStatistics = new WinningStatistics();

        assertThat(lottos.findWinningLottoResult(lotto, winningStatistics).getWinningStatistic().get(LottoPrizeType.FIRST_PRIZE)).isEqualTo(1);
    }

}
