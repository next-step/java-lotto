package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAgencyTest {
  @Test
  @DisplayName("금액 / 1000이 구매 로또 개수와 일치하는가")
  public void buy() throws Exception {
    LottoAgency agency = new LottoAgency(new Money(14455));

    //when
    agency.purchaseLotto();

    //then
    assertEquals(agency.getPurchaseQuantity(), 14);
  }

  @Test
  @DisplayName("지난 주 로또 번호를 입력 할 수 있는가")
  public void updateWinnerNumber() throws Exception {
    //given
    List<Number> numbers = new ArrayList<>();

    numbers.add(new Number(1));
    numbers.add(new Number(2));
    numbers.add(new Number(3));
    numbers.add(new Number(4));
    numbers.add(new Number(5));
    numbers.add(new Number(6));

    LottoAgency agency = new LottoAgency(new Money(14455));

    //when
    agency.updateWinLottoNumbers(new Lotto(numbers));

    //then
    assertEquals(new Lotto(numbers), agency.getWinLottoNumbers());
  }
}