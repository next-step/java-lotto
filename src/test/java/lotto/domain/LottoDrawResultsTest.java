package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoDrawResultsTest {

  @ParameterizedTest
  @DisplayName("로또 추첨 결과들이 잘 생성되는지 확인")
  @CsvSource(value = {"1|100|true", "5|5|false", "4|400|true", "0|0|false"}, delimiter = '|')
  void generate(int matchCount, int reword, boolean bonusMatch) {
    LottoDrawResults lottoDrawResults = new LottoDrawResults(Arrays.asList(
        new LottoDrawResult[]{new LottoDrawResult(matchCount, reword, bonusMatch),
            new LottoDrawResult(matchCount, reword, bonusMatch)}));
    LottoDrawResults exptected = new LottoDrawResults(Arrays.asList(
        new LottoDrawResult[]{new LottoDrawResult(matchCount, reword, bonusMatch),
            new LottoDrawResult(matchCount, reword, bonusMatch)}));

    assertThat(lottoDrawResults).usingRecursiveComparison().isEqualTo(exptected);

  }

  @RepeatedTest(100)
  @DisplayName("추첨 결과의 총 상금을 잘 계산하는지 확인")
  void rewordAll() {
    Random random = new Random();
    List<LottoDrawResult> lottoDrawResults = new ArrayList<>();
    int rewordAll = 0;
    int drawCount = 100;

    for (int i = 0; i < drawCount; i++) {
      int reword = random.nextInt(10000);
      lottoDrawResults.add(new LottoDrawResult(random.nextInt(10), reword, false));
      rewordAll += reword;
    }

    assertThat(new LottoDrawResults(lottoDrawResults).getRewordAll()).isEqualTo(rewordAll);

  }

  @RepeatedTest(100)
  @DisplayName("로또 보너스 추첨 결과가 잘 필터링되는지 확인")
  void filterBonus() {
    Random random = new Random();
    List<LottoDrawResult> lottoDrawResults = new ArrayList<>();
    int filteredSizeExpect = 0;
    int loopCount = random.nextInt(100);

    for (int i = 0; i < loopCount; i++) {
      int randomNumber = random.nextInt(2);
      filteredSizeExpect += randomNumber;
      lottoDrawResults.add(new LottoDrawResult(10, 1000, randomNumber == 1));
    }
    LottoDrawResults bonusResult = new LottoDrawResults(lottoDrawResults).filterBonusBall(true);
    LottoDrawResults notBonusResult = new LottoDrawResults(lottoDrawResults).filterBonusBall(false);

    assertThat(bonusResult.getValues()).hasSize(filteredSizeExpect);
    assertThat(notBonusResult.getValues()).hasSize(loopCount - filteredSizeExpect);

  }

  @RepeatedTest(100)
  @DisplayName("로또 번호 맞은 개수별 상금을 잘 가져오는지 확인")
  void profitRate() {
    Random random = new Random();
    List<LottoDrawResult> lottoDrawResults = new ArrayList<>();
    HashMap<Integer, Integer> rewordByMatchCount = new HashMap<>();

    for (int i = 0; i < 100; i++) {
      int reword = random.nextInt(10000);
      int matchCount = random.nextInt(6);
      lottoDrawResults.add(new LottoDrawResult(matchCount, reword, false));
      rewordByMatchCount.putIfAbsent(matchCount, 0);
      rewordByMatchCount.put(matchCount, rewordByMatchCount.get(matchCount) + reword);
    }

    for (Entry<Integer, Integer> rewordEntry : rewordByMatchCount.entrySet()) {
      int matchCount = rewordEntry.getKey();
      int reword = rewordEntry.getValue();
      LottoDrawResults drawResults = new LottoDrawResults(
          lottoDrawResults).getDrawResultsByMatchCount(matchCount);
      assertThat(reword).isEqualTo(drawResults.getRewordAll());
    }

  }
}