package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLotto;
import lotto.random.LottoGenerator;
import lotto.testrandom.DefaultLottoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName(value = "수동로또까지 개수 반영되었는지 테스트")
    public void initLottoSizeTest() {
        int tryCount = 1;
        LottoGenerator lottoGenerator = new DefaultLottoList();
        final List<LottoNumber> TEST_MANUAL_NUMBER_LIST = IntStream.range(1, 7)
                .mapToObj(LottoNumber::new).collect(Collectors.toList());
        LottoNumbers testAutoLottoNumbers = new LottoNumbers(lottoGenerator.executeStrategy());
        LottoNumbers manualLottoNumbers = new LottoNumbers(TEST_MANUAL_NUMBER_LIST);
        Lotto manaulLotto = new Lotto(List.of(manualLottoNumbers));
        Lotto testLotto = new Lotto(List.of(manualLottoNumbers, testAutoLottoNumbers));

        Lotto lotto = Lotto.initAllRoundLottoNumbers(manaulLotto, lottoGenerator, tryCount);
        assertThat(lotto).isEqualTo(testLotto);
    }

    @Test
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
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusBall);
        assertThat(lotto.winningRanks(winningLotto))
                .isEqualTo(EXPECTED_RANK_LIST);
    }

}