package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.random.LottoGenerator;
import lotto.testrandom.DefaultLottoList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    public void 로또번호_생성_테스트() {
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        Lotto testLotto = new Lotto(List.of(new LottoNumbers(lottoGenerator.executeStrategy())));
        Lotto lotto = Lotto.initAllRoundLottoNumbers(lottoGenerator, tryCount);
        assertThat(lotto).isEqualTo(testLotto);
    }

  /*  @Test
    public void 로또당첨리스트_테스트() {
        final List<LottoRank> EXPECTED_RANK_LIST = List.of(LottoRank.FIRST);
        final List<LottoNumber> TEST_WINNING_NUMBER_LIST = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new).collect(Collectors.toList());
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        LottoNumbers winningLottoNumbers = new LottoNumbers(TEST_WINNING_NUMBER_LIST);
        Lotto lotto = Lotto.initAllRoundLottoNumbers(lottoGenerator, tryCount);
        int bonusNumber = 7;
        LottoNumber bonusBall = new LottoNumber(bonusNumber);
        assertThat( lotto.lottoRankList(winningLottoNumbers, bonusBall))
                .isEqualTo(EXPECTED_RANK_LIST);
    }*/

}