package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LottoVendingMachineTest {

  @Test
  public void test_purchaseLotto_by_inputMoney() {

    // Given
    int purchaseAmount = 14000;

    // When
    List<Lotto> lottoList = LottoVendingMachine.purchaseLotto(purchaseAmount);

    // Then
    assertThat(lottoList.size()).isEqualTo(14);
  }

  @Test
  public void test_generateLottoNumbers_sixNumber() {

    // When
    List<Number> generateNumber = LottoVendingMachine.generateLottoNumbers();

    // Then
    assertThat(generateNumber.size()).isEqualTo(6);
  }

  @Test
  public void test_winLotto_threeNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;

    Lotto lotto = new Lotto(Arrays.asList(
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(thirdMatchNumber),
        new Number(2),
        new Number(19),
        new Number(15)
    ));
    List<Number> winNumbers = Arrays.asList(
        new Number(5),
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(42),
        new Number(thirdMatchNumber),
        new Number(31)
    );

    // When
    int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(3);
  }

  @Test
  public void test_winLotto_fourNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;

    Lotto lotto = new Lotto(Arrays.asList(
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(thirdMatchNumber),
        new Number(fourthMatchNumber),
        new Number(19),
        new Number(15)
    ));
    List<Number> winNumbers = Arrays.asList(
        new Number(5),
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(fourthMatchNumber),
        new Number(thirdMatchNumber),
        new Number(31)
    );

    // When
      int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(4);
  }

  @Test
  public void test_winLotto_fiveNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;

    Lotto lotto = new Lotto(Arrays.asList(
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(thirdMatchNumber),
        new Number(fourthMatchNumber),
        new Number(fifthMatchNumber),
        new Number(15)
    ));
    List<Number> winNumbers = Arrays.asList(
        new Number(fifthMatchNumber),
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(fourthMatchNumber),
        new Number(thirdMatchNumber),
        new Number(31)
    );

    // When
    int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(5);
  }

  @Test
  public void test_winLotto_sixNumber() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;
    int sixthMatchNumber = 19;

    Lotto lotto = new Lotto(Arrays.asList(
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(thirdMatchNumber),
        new Number(fourthMatchNumber),
        new Number(fifthMatchNumber),
        new Number(sixthMatchNumber)
    ));
    List<Number> winNumbers = Arrays.asList(
        new Number(fifthMatchNumber),
        new Number(firstMatchNumber),
        new Number(secondMatchNumber),
        new Number(fourthMatchNumber),
        new Number(thirdMatchNumber),
        new Number(sixthMatchNumber)
    );

    // When
    int matchingCount = lotto.winMatch(winNumbers);

    // Then
    assertThat(matchingCount).isEqualTo(6);
  }

  @Test
  public void test_yield() {

    // Given
    Money purchaseMoney = new Money(14000);
    Money winMoney = new Money(5000);

    // When
    String yield = LottoVendingMachine.yield(purchaseMoney, winMoney);

    // Then
    assertThat(yield).isEqualTo("0.36");
  }
}
