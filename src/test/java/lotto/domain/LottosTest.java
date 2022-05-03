package lotto.domain;

import lotto.constant.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("3개의 복권 중 2개가 MatchResult.Three 경우 10000을 반환한다.")
    void calculateTotalWinPrice() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)}))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)}))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber[]{new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)}))));

        LottoNumbers winningLottoNumbers = LottoNumbers.winningLottoNumbers(new String[]{"1", "2", "3", "20", "21", "22"});

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(winningLottoNumbers);

        assertThat(lottos.calculateTotalWinPrice()).isEqualTo(10000);
    }

    @Test
    @DisplayName("3개의 복권 중 2개가 MatchResult.Three 일때 MatchResult.Three 개수를 구하면 2개를 반환한다.")
    void countMatchResult() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)}))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber[]{new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)}))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber[]{new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)}))));

        LottoNumbers winningLottoNumbers = LottoNumbers.winningLottoNumbers(new String[]{"1", "2", "3", "20", "21", "22"});

        Lottos lottos = new Lottos(lottoList);
        lottos.confirmAll(winningLottoNumbers);

        assertThat(lottos.countMatchResult(MatchResult.THREE)).isEqualTo(2);
    }
}