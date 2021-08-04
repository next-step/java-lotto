package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.TestGenerateLottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteTest {

  @DisplayName("1~45 로또번호 리스트 생성 테스트.")
  @Test
  void 로또번호리스트생성() {

    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(1,46);

    List<LottoNumber> numberPull = generateLottoNumber.createNumberPull();

    assertThat(numberPull.size()).isEqualTo(45);

    assertThat(numberPull
        .stream()
        .map(LottoNumber::getNumber)
        .findFirst()
        .get()).isEqualTo(1);

    assertThat(numberPull
        .stream()
        .skip(numberPull.size()-1)
        .map(LottoNumber::getNumber)
        .findFirst()
        .get()).isEqualTo(45);
  }

  @DisplayName("중복없는 숫자 6개를 가져와 로또 하나 생성 테스트.")
  @Test
  void 로또한장생성() {
    Lotto lotte = new Lotto();
    List<Integer> testLotto = new ArrayList<>();
    testLotto.add(1);
    testLotto.add(2);
    testLotto.add(3);
    testLotto.add(4);
    testLotto.add(5);
    testLotto.add(6);

    GenerateLottoNumber generateLottoNumber = new TestGenerateLottoNumber(0,6,testLotto);
    lotte.creatLotte(generateLottoNumber);

    assertThat(lotte.getLotto().size()).isEqualTo(6);

    Set<Integer> checkValues = lotte.getLotto()
        .stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toSet());

    assertThat(checkValues.size()).isEqualTo(6);
  }

}