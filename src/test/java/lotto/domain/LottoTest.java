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
    assertThat(lotto.numbers()).isEqualTo(numberList);
    assertThat(lotto.numbers()).isSorted();
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
    List<Integer> lottoNumbers = lotto.numbers();

    //then
    assertThat(lottoNumbers).allMatch(i -> i >= LottoNumber.MIN && i <= LottoNumber.MAX);
    assertThat(lottoNumbers.size()).isEqualTo(Lotto.NUMBER_SIZE);
    assertThat(lottoNumbers.stream().distinct().count() == lottoNumbers.size()).isTrue();
    assertThat(lottoNumbers).isSorted();
  }

  @Test
  @DisplayName("로또와 당첨로또 일치하는 개수 구하기 테스트")
  void getMatchingNumberCntTest() {
    //given
    Lotto winningLotto = Lotto.issueByManual(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto lotto0 = Lotto.issueByManual(Arrays.asList(7, 8, 9, 10, 11, 12));
    Lotto lotto1 = Lotto.issueByManual(Arrays.asList(6, 7, 8, 9, 10, 11));
    Lotto lotto2 = Lotto.issueByManual(Arrays.asList(5, 6, 7, 8, 9, 10));

    //when
    int result0 = lotto0.matchedNumberCnt(winningLotto);
    int result1 = lotto1.matchedNumberCnt(winningLotto);
    int result2 = lotto2.matchedNumberCnt(winningLotto);
    int winningResult = winningLotto.matchedNumberCnt(winningLotto);

    //then
    assertThat(result0).isEqualTo(0);
    assertThat(result1).isEqualTo(1);
    assertThat(result2).isEqualTo(2);
    assertThat(winningResult).isEqualTo(6);
  }
}
