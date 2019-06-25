package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {

  @Test
  @DisplayName("로또가 가지고 있는 번호 확인")
  void lottoHasNumbers() {
    NumberGenerator numberGenerator = new MockNumberGenerator();
    List<Integer> lottoNumbers = numberGenerator.generate(6);

    Lotto lotto = new Lotto(lottoNumbers);
    assertThat(lotto.toString()).contains("1", "2", "3", "4", "5", "6");
  }

  @Test
  @DisplayName("당첨번호 중 몇개 당첨되었는지 확인")
  void contains_how_many_winning_numbers() {
    List<Integer> winningNumbers = Arrays.asList(1, 2, 4, 14, 16);
    List<Integer> lottoNumbers = new MockNumberGenerator().generate(6);

    List<Lotto> myLottos = Arrays.asList(new Lotto(lottoNumbers));

    List<Integer> matchingCount = myLottos.stream()
            .mapToInt(lotto -> lotto.hasHowMany(winningNumbers))
            .boxed()
            .collect(Collectors.toList());

    assertThat(matchingCount.size()).isEqualTo(1);
    assertThat(matchingCount).contains(3);
  }
}
