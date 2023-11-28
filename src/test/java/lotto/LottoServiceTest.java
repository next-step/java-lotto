package lotto;

import lotto.domain.Lotto;
import lotto.domain.MatchPoint;
import lotto.domain.MatchPointRank;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @DisplayName("로또리스트 생성 비교")
    @Test
    void 로또리스트생성() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));

        LottoService lottoService = new LottoService(lottoList, new MatchPointRank());

        assertThat(lottoService.getLottoList()).hasSize(5);
    }

    @DisplayName("당첨수 테스트")
    @Test
    void playLotto_테스트() {
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LottoService lottoService = new LottoService(lottoList, new MatchPointRank());

        lottoService.playLotto(List.of(new String[]{"1", "2", "3", "4", "7", "10"}), 22);

        assertThat(lottoService.getMatchPointMap().getMatchPoint(MatchPoint.FOURTH)).isEqualTo(1);
    }

}
