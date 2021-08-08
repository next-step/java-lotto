package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.service.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

  @DisplayName("로또당첨결과 기본생성 테스트.")
  @Test
  void 로또결과기본값() {

    LottoResult lottoResult = new LottoResult();

    assertThat(lottoResult.getCategoriesRank().get(Rank.MISS).size()).isEqualTo(0);
    assertThat(lottoResult.getCategoriesRank().get(Rank.FIFTH).size()).isEqualTo(0);
    assertThat(lottoResult.getCategoriesRank().get(Rank.FOURTH).size()).isEqualTo(0);
    assertThat(lottoResult.getCategoriesRank().get(Rank.THIRD).size()).isEqualTo(0);
    assertThat(lottoResult.getCategoriesRank().get(Rank.FIFTH).size()).isEqualTo(0);
  }

  @DisplayName("랭크 기준의 현재 로또 당첨갯수를 반환하는 테스트.")
  @Test
  void 해당랭크의로또갯수반환() {
    LottoResult lottoResult = new LottoResult();

    int rankCount = lottoResult.getRankCount(Rank.MISS);
    assertThat(rankCount).isEqualTo(0);

    Map<Rank, List<Lotto>> categoriesRank = lottoResult.getCategoriesRank();
    categoriesRank.get(Rank.FIFTH).add(new Lotto());

    rankCount = lottoResult.getRankCount(Rank.FIFTH);
    assertThat(rankCount).isEqualTo(1);
  }

  @DisplayName("랭크명을 키로하는 값인 리스트를 반환하는 테스트.")
  @Test
  void 랭크에해당하는값리스트를리턴() {
    LottoResult lottoResult = new LottoResult();

    Map<Rank, List<Lotto>> categoriesRank = lottoResult.getCategoriesRank();
    categoriesRank.get(Rank.FIFTH).add(new Lotto());

    assertThat(lottoResult.getMatchLottos(Rank.FIFTH).size()).isEqualTo(1);
    assertThat(lottoResult.getMatchLottos(Rank.FIFTH).get(0)).isEqualTo(new Lotto());
  }
}