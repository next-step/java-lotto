package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRewordsTest {

  @RepeatedTest(100)
  @DisplayName("파라미터에 해당되는 LottoRewords 만 잘 가져오는지 확인")
  void getRewords() {
    Random random = new Random();
    HashMap<LottoReword, Integer> rewordCountMap = new HashMap<>();
    List<LottoReword> lottoRewords = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      int randomLottoRewordIdx = random.nextInt(LottoReword.values().length);
      LottoReword randomPickLottoReword = LottoReword.values()[randomLottoRewordIdx];
      rewordCountMap.merge(randomPickLottoReword, 1, Integer::sum);
      lottoRewords.add(randomPickLottoReword);
    }
    LottoRewords resultRewords = LottoRewords.from(lottoRewords);

    for (LottoReword reword : rewordCountMap.keySet()) {
      assertThat(rewordCountMap.get(reword)).isEqualTo(resultRewords.getRewords(reword).getSize());
    }

  }

  @RepeatedTest(100)
  @DisplayName("해당되는 LottoRewords 의 상금을 잘 합산하는지 확인")
  void getRewordSum() {
    Random random = new Random();
    long rewordSum = 0;
    List<LottoReword> lottoRewords = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      int randomLottoRewordIdx = random.nextInt(LottoReword.values().length);
      LottoReword randomPickLottoReword = LottoReword.values()[randomLottoRewordIdx];
      rewordSum += randomPickLottoReword.getMoney();
      lottoRewords.add(randomPickLottoReword);
    }
    LottoRewords resultRewords = LottoRewords.from(lottoRewords);

    assertThat(resultRewords.getRewordSum()).isEqualTo(rewordSum);
  }
}