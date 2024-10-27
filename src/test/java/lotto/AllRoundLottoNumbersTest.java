package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.AllRoundLottoNumbers;
import lotto.domain.LottoNumbers;
import lotto.random.LottoGenerator;
import lotto.testrandom.DefaultLottoList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AllRoundLottoNumbersTest {
    public static final List<Integer> TEST_WINNING_NUMBER_LIST = List.of(1, 2, 3, 4, 5, 6);
    public static final List<Integer> EXPECTED_RANK_LIST = List.of(1);

    @Test
    public void 로또번호_생성_테스트() {
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        AllRoundLottoNumbers testAllRoundLottoNumbers = new AllRoundLottoNumbers(List.of(new LottoNumbers(lottoGenerator.executeStrategy())));
        AllRoundLottoNumbers allRoundLottoNumbers = AllRoundLottoNumbers.initAllRoundLottoNumbers(lottoGenerator, tryCount);
        assertThat(allRoundLottoNumbers).isEqualTo(testAllRoundLottoNumbers);
    }

    @Test
    public void 로또당첨리스트_테스트() {
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        LottoNumbers winningLottoNumbers = new LottoNumbers(TEST_WINNING_NUMBER_LIST);
        AllRoundLottoNumbers allRoundLottoNumbers = AllRoundLottoNumbers.initAllRoundLottoNumbers(lottoGenerator, tryCount);

        assertThat( allRoundLottoNumbers.lottoRankList(winningLottoNumbers))
                .isEqualTo(EXPECTED_RANK_LIST);
    }
}