package lotto.domain.lotto;

import lotto.common.LottoStub;
import lotto.domain.matcher.LottoRank;
import lotto.domain.matcher.WinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @DisplayName("Lottery는 최소 1개, 최대 5개의 LottoLine을 가질 수 있는 Lotto의 컬렉션이다")
    @Test
    public void lotteryBuildTest() {
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbers(6, 7, 8, 9, 10, 11)
        );

        Lottery lottery = Lottery.of(lottoNumbers);

        assertThat(lottery.getSize()).isEqualTo(6);
        assertThat(lottery.getLottery().get(0).getMaxSize()).isEqualTo(5);
        assertThat(lottery.getLottery().get(1).getMaxSize()).isEqualTo(1);

        Lotto expected = new Lotto(Arrays.asList(new LottoLine(LottoStub.getLottoNumbers(6, 7, 8, 9, 10, 11))));
        assertThat(lottery.getLottery().get(1))
                .isEqualTo(expected);
    }

    @DisplayName("Lotto 의 당첨 결과 리스트를 취합하여 하나의 결과 리스트를 생성한다")
    @Test
    public void lottoRankListTest() {

        LottoNumbers lottoNumbers1 = LottoStub.getLottoNumbers(6, 7, 8, 9, 10, 11);
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                lottoNumbers1
        );

        Lottery lottery = Lottery.of(lottoNumbers);

        List<LottoRank> rank = lottery.getRank(new WinningTicket(lottoNumbers1, 12));

        assertThat(rank).hasSize(6);
        assertThat(rank).containsExactly(LottoRank.ONE, LottoRank.ONE, LottoRank.ONE,
                LottoRank.ONE, LottoRank.ONE, LottoRank.SIX);
    }

    @Test
    public void test() {
        LottoNumbers lottoNumbers1 = LottoStub.getLottoNumbers(6, 7, 8, 9, 10, 11);
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                LottoStub.getLottoNumbersOneToSix(),
                lottoNumbers1
        );

        Lottery lottery = Lottery.of(lottoNumbers);

        String collect = lottery.getLotterySources().stream().map(String::valueOf).collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

}
