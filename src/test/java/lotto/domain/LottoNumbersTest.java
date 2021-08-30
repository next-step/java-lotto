package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    int[] numbers = { 1, 2, 3, 4, 5, 6};

    //when
    LottoNumbers lottoNumbers = new LottoNumbers(numbers);

    //then
    assertThat(lottoNumbers.sortedNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("잘못된 생성 테스트(6개 아닐때)")
  void invalidCreateTest() {
    //given
    int[] numbersLessThan6 = {1, 2, 3, 4, 5};
    int[] numbersMoreThan6 = {1, 2, 3, 4, 5, 6, 7};

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumbers(numbersLessThan6);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumbers(numbersMoreThan6);
    });
  }

  @Test
  @DisplayName("일치하는 개수 반환 테스트")
  void matchedNumberCntTest() {
    //given
    LottoNumbers lottoNumbers1 = new LottoNumbers(new int[]{1, 2, 3, 4, 5, 6});
    LottoNumbers lottoNumbers2 = new LottoNumbers(new int[]{10, 20, 30, 40, 5, 6});

    //when
    int matchedNumberCnt = lottoNumbers1.matchedNumberCnt(lottoNumbers2);

    //then
    assertThat(matchedNumberCnt).isEqualTo(2);
  }

  @Test
  @DisplayName("정렬된 숫자들 반환 테스트")
  void sortedNumbers() {
    //given
    LottoNumbers lottoNumbers = new LottoNumbers(new int[]{3, 2, 4, 1, 6, 5});

    //when
    List<Integer> sortedNumbers = lottoNumbers.sortedNumbers();

    //then
    assertThat(sortedNumbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("특정로또 번호 포함여부 테스트")
  void containsTest() {
    //given
    LottoNumbers lottoNumbers = new LottoNumbers(new int[] {1, 2, 3, 4, 5, 6});

    //then
    assertThat(lottoNumbers.contains(new LottoNumber(1))).isTrue();
    assertThat(lottoNumbers.contains(LottoNumber.valueOf(1))).isTrue();
    assertThat(lottoNumbers.contains(new LottoNumber(7))).isFalse();
    assertThat(lottoNumbers.contains(LottoNumber.valueOf(7))).isFalse();
  }
}
