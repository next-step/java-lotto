package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class WinStatsTest {


  @Test
  public void test_totalWinMoney() {

    // Given
    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;
    int sixthMatchNumber = 19;

    List<Lotto> lottos = Arrays.asList(
        new Lotto(new HashSet<>(Arrays.asList(
            5,
            firstMatchNumber,
            secondMatchNumber,
            42,
            thirdMatchNumber,
            31))),
        new Lotto(new HashSet<>(Arrays.asList(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            1,
            14))),
        new Lotto(new HashSet<>(Arrays.asList(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            45))),
        new Lotto(new HashSet<>(Arrays.asList(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            sixthMatchNumber)))
    );
    MyLottos myLottos = new MyLottos(new Money(4000), lottos);

    Set<Integer> winNumbers = new TestNumberGenerator(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber).generate();

    // When
    WinStats winStats = new WinStats(myLottos, winNumbers);
    Money winMoney = winStats.getTotalWinMoney();

    // Then
    assertThat(winMoney).isEqualTo(new Money(5000 + 50000 + 1500000 + 2000000000));
  }

  @Test
  public void test_yield() {

    // Given
    Money purchaseMoney = new Money(14000);

    int firstMatchNumber = 3;
    int secondMatchNumber = 12;
    int thirdMatchNumber = 25;
    int fourthMatchNumber = 36;
    int fifthMatchNumber = 40;
    int sixthMatchNumber = 19;

    List<Lotto> lottoList = Arrays.asList(
        new Lotto(new HashSet<>(Arrays.asList(
            5,
            firstMatchNumber,
            secondMatchNumber,
            42,
            thirdMatchNumber,
            31))),
        new Lotto(new HashSet<>(Arrays.asList(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            1,
            14))),
        new Lotto(new HashSet<>(Arrays.asList(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            45))),
        new Lotto(new HashSet<>(Arrays.asList(
            firstMatchNumber,
            secondMatchNumber,
            thirdMatchNumber,
            fourthMatchNumber,
            fifthMatchNumber,
            sixthMatchNumber)))
    );
    MyLottos myLottos = new MyLottos(purchaseMoney, lottoList);

    Set<Integer> winNumbers = new TestNumberGenerator(
        fifthMatchNumber,
        firstMatchNumber,
        secondMatchNumber,
        fourthMatchNumber,
        thirdMatchNumber,
        sixthMatchNumber).generate();

    // When
    WinStats winStats = new WinStats(myLottos, winNumbers);
    String yield = winStats.yield();

    // Then
    assertThat(yield).isEqualTo("142968.20");
  }
}