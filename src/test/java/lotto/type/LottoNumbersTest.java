package lotto.type;

import lotto.strategy.LottoCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

  private List<LottoNumber> createValidLottoNumbers() {
    return IntStream.rangeClosed(1, 6)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());
  }

  private List<LottoNumber> createCase1InvalidLottoNumbers() {
    return IntStream.rangeClosed(1, 7)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());
  }

  private List<LottoNumber> createCase2InvalidLottoNumbers() {
    List<LottoNumber> res = IntStream.rangeClosed(1, 5)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList());

    res.add(new LottoNumber(46));
    return res;
  }


  @DisplayName("생성자 테스트1")
  @Test
  public void constructorTest1() {
    assertAll(
        () -> assertDoesNotThrow(() -> new LottoNumbers(createValidLottoNumbers())),
        () -> assertThrows(RuntimeException.class, () -> new LottoNumbers(createCase1InvalidLottoNumbers())),
        () -> assertThrows(RuntimeException.class, () -> new LottoNumbers(createCase2InvalidLottoNumbers()))
    );
  }

  @DisplayName("생성자 테스트2")
  @Test
  public void constructorTest2() {
    assertAll(
        () -> assertDoesNotThrow(() -> new LottoNumbers("1, 2, 3, 4, 5, 6")),
        () -> assertThrows(RuntimeException.class, () -> new LottoNumbers("1, 2, 3, 4, 5")),
        () -> assertThrows(RuntimeException.class, () -> new LottoNumbers("1, 2, 3, 4, 5, 46")),
        () -> assertThrows(RuntimeException.class, () -> new LottoNumbers("-1, 2, 3, 4, 5, 45"))
    );
  }

  @DisplayName("로또 번호 생성")
  @Test
  public void testGenerate() {
    LottoCreateStrategy lottoCreateStrategyStub = new LottoCreateStrategy() {
      private final Iterator<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6).iterator();

      @Override
      public int pick(int min, int max) {
        if (!numbers.hasNext()) {
          throw new NoSuchElementException("더 이상 숫자가 없습니다.");
        }
        return numbers.next();
      }

      @Override
      public List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
        return lottoNumbers;
      }
    };

    LottoNumbers lottoNumbers = LottoNumbers.generate(lottoCreateStrategyStub);
    LottoNumbers expectedNumbers = new LottoNumbers(Arrays.asList(
        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    ));

    assertThat(lottoNumbers).isEqualTo(expectedNumbers);
  }
}
