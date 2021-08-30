package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  @DisplayName("수동생성 테스트")
  void issueByManualTest() {
    //given
    List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);

    //when
    Lotto lotto = Lotto.issueByManual(numberList);

    //then
    assertThat(lotto.sortedNumbers()).isEqualTo(numberList);
    assertThat(lotto.sortedNumbers()).isSorted();
  }

  @Test
  @DisplayName("잘못된 수동생성 테스트")
  void invalidIssueLottoByManualTest() {
    //given
    List<Integer> emptyNumbers = Collections.emptyList();
    List<Integer> smallNumbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> largeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    List<Integer> duplicatedNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Lotto.issueByManual(emptyNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Lotto.issueByManual(smallNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Lotto.issueByManual(largeNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Lotto.issueByManual(duplicatedNumbers);
    });
  }

  @Test
  @DisplayName("자동생성 테스트")
  void issueByAuto() {
    //when
    Lotto lotto = Lotto.issueByAuto();
    List<Integer> lottoNumbers = lotto.sortedNumbers();

    //then
    assertThat(lottoNumbers).allMatch(i -> i >= LottoNumber.MIN && i <= LottoNumber.MAX);
    assertThat(lottoNumbers.size()).isEqualTo(LottoNumbers.SIZE);
    assertThat(lottoNumbers.stream().distinct().count() == lottoNumbers.size()).isTrue();
    assertThat(lottoNumbers).isSorted();
  }
}
