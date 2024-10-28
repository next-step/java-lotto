package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.random.LottoGenerator;
import lotto.testrandom.DefaultLottoList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    public static final List<Integer> TEST_WINNING_NUMBER_LIST = List.of(1, 2, 3, 4, 5, 6);
    public static final List<Integer> EXPECTED_RANK_LIST = List.of(1);

    @Test
    public void 로또번호_생성_테스트() {
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        Lotto testLotto = new Lotto(List.of(new LottoNumbers(lottoGenerator.executeStrategy())));
        Lotto lotto = Lotto.initAllRoundLottoNumbers(lottoGenerator, tryCount);
        assertThat(lotto).isEqualTo(testLotto);
    }

    @Test
    public void 로또당첨리스트_테스트() {
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        LottoNumbers winningLottoNumbers = new LottoNumbers(TEST_WINNING_NUMBER_LIST);
        Lotto lotto = Lotto.initAllRoundLottoNumbers(lottoGenerator, tryCount);

        assertThat( lotto.lottoRankList(winningLottoNumbers))
                .isEqualTo(EXPECTED_RANK_LIST);
    }
}