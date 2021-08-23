package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    int[] numbers = {1, 2, 3, 4, 5, 6};
    List<Integer> numberList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

    //when
    Lotto lotto = new Lotto(numbers);

    //then
    assertThat(lotto.getLottoNumbers()).isEqualTo(numberList);
  }

  @Test
  @DisplayName("잘못된 생성 테스트")
  void invalidCreateTest() {
    //given
    int[] emptyNumbers = {};
    int[] smallNumbers = {1, 2, 3, 4, 5};
    int[] largeNumbers = {1, 2, 3, 4, 5, 6, 7};
    int[] duplicatedNumbers = {1, 1, 2, 3, 4, 5};

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(emptyNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(smallNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(largeNumbers);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Lotto(duplicatedNumbers);
    });
  }

  @Test
  @DisplayName("로또와 당첨로또 일치하는 개수 구하기 테스트")
  void getMatchingNumberCntTest() {
    //given
    Lotto winningLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
    Lotto lotto0 = new Lotto(new int[]{7, 8, 9, 10, 11, 12});
    Lotto lotto1 = new Lotto(new int[]{6, 7, 8, 9, 10, 11});
    Lotto lotto2 = new Lotto(new int[]{5, 6, 7, 8, 9, 10});

    //when
    int result0 = lotto0.getMatchingNumberCnt(winningLotto);
    int result1 = lotto1.getMatchingNumberCnt(winningLotto);
    int result2 = lotto2.getMatchingNumberCnt(winningLotto);
    int winningResult = winningLotto.getMatchingNumberCnt(winningLotto);

    //then
    assertThat(result0).isEqualTo(0);
    assertThat(result1).isEqualTo(1);
    assertThat(result2).isEqualTo(2);
    assertThat(winningResult).isEqualTo(6);
  }
}
