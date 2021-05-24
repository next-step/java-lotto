package lottoAuto;

import lottoAuto.model.LottoAutoService;
import lottoAuto.model.Rank;
import lottoAuto.view.LottoAutoResultView;
import lottoAuto.vo.LottoResultVo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class LottoAutoTest {
    public LottoAutoService lottoAutoService = new LottoAutoService();
    public List<LottoResultVo> expected = new ArrayList<>();
    public LottoAutoResultView lottoAutoResultView = new LottoAutoResultView();

    @Test
    public void winningCountTest() {
        this.expected.add(new LottoResultVo(Rank.findByRank(5, false), 1));
        this.expected.add(new LottoResultVo(Rank.findByRank(3, false), 1));
    }

    @Test
    public void bonusCountTest() {
        this.expected.add(new LottoResultVo(Rank.findByRank(5, true), 1));
        this.expected.add(new LottoResultVo(Rank.findByRank(3, false), 1));
    }

    @Test
    public void distinctCountTest() {
        this.expected.add(new LottoResultVo(Rank.findByRank(3, false), 1));
        this.expected.add(new LottoResultVo(Rank.findByRank(3, false), 1));

    }

    @Test
    public void 당첨번호만_존재할_때() {
        winningCountTest();

        List<Integer> winning_count = Arrays.asList(5, 3);
        List<Boolean> bonus_count = Arrays.asList(false, false);

        List<LottoResultVo> actual = lottoAutoService.setWinningStatistic(winning_count, bonus_count);

        assertThat(actual.get(0).getRank()).isEqualTo(expected.get(0).getRank());
        assertThat(actual.get(1).getRank()).isEqualTo(expected.get(1).getRank());
    }

    @Test
    public void 보너스_숫자가_존재할_때() {
        bonusCountTest();

        List<Integer> winning_count = Arrays.asList(5, 3);
        List<Boolean> bonus_count = Arrays.asList(true, false);

        List<LottoResultVo> actual = lottoAutoService.setWinningStatistic(winning_count, bonus_count);

        assertThat(actual.get(0).getRank()).isEqualTo(expected.get(0).getRank());
        assertThat(actual.get(1).getRank()).isEqualTo(expected.get(1).getRank());
    }

    @Test
    public void winningCount에_동일한_숫자가_있을_때() {
        distinctCountTest();

        System.out.println(expected.stream().distinct().count());
    }

}
