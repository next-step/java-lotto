package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList());

    //when
    LottoNumbers lottoNumbers = new LottoNumbers(numbers);

    //then
    assertThat(lottoNumbers.sortedNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("잘못된 생성 테스트(6개 아닐때)")
  void invalidCreateTest() {
    //given
    List<LottoNumber> numbersLessThan6 = Stream.of(1, 2, 3, 4, 5)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList());
    List<LottoNumber> numbersMoreThan6 = Stream.of(1, 2, 3, 4, 5, 6, 7)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList());

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
    LottoNumbers lottoNumbers1 = new LottoNumbers(
        Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );
    LottoNumbers lottoNumbers2 = new LottoNumbers(
        Stream.of(10, 20, 30, 40, 5, 6)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );

    //when
    int matchedNumberCnt = lottoNumbers1.matchedNumberCnt(lottoNumbers2);

    //then
    assertThat(matchedNumberCnt).isEqualTo(2);
  }

  @Test
  @DisplayName("정렬된 숫자들 반환 테스트")
  void sortedNumbers() {
    //given
    LottoNumbers lottoNumbers = new LottoNumbers(
        Stream.of(3, 2, 4, 1, 6, 5)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );

    //when
    List<Integer> sortedNumbers = lottoNumbers.sortedNumbers();

    //then
    assertThat(sortedNumbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("특정로또 번호 포함여부 테스트")
  void containsTest() {
    //given
    LottoNumbers lottoNumbers = new LottoNumbers(
        Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );
    LottoNumber containedNumber1 = new LottoNumber(1);
    LottoNumber containedNumber2 = LottoNumber.valueOf(1);
    LottoNumber unContainedNumber1 = new LottoNumber(7);
    LottoNumber unContainedNumber2 = LottoNumber.valueOf(7);

    //then
    assertThat(lottoNumbers.contains(containedNumber1)).isTrue();
    assertThat(lottoNumbers.contains(containedNumber2)).isTrue();
    assertThat(lottoNumbers.contains(unContainedNumber1)).isFalse();
    assertThat(lottoNumbers.contains(unContainedNumber2)).isFalse();
  }
}
