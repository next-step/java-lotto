package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.Grade;
import lotto.exception.LottoSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

  @Test
  @DisplayName("당첨 번호와 상품으로 만들어진 로또의 번호가 일치하는지 확인한다.")
  void winningProduct() {
    assertThat(new Product(Set.of(
        new LottoNo(1),
        new LottoNo(2),
        new LottoNo(3),
        new LottoNo(4),
        new LottoNo(5),
        new LottoNo(6)))).isEqualTo(Product.from(Set.of(
        new LottoNo(1),
        new LottoNo(2),
        new LottoNo(3),
        new LottoNo(4),
        new LottoNo(5),
        new LottoNo(6))));
  }

  @Test
  @DisplayName("당첨 번호와 몇개가 맞는지 테스트한다")
  void coincide() {
    Product product = new Product(
        Set.of(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5),
            new LottoNo(6)));

    assertThat(product.coincideLotto(Grade.THREE, List.of
        (
            new Product
                (
                    Set.of(new LottoNo(1),
                        new LottoNo(2),
                        new LottoNo(3),
                        new LottoNo(7),
                        new LottoNo(8),
                        new LottoNo(9)
                    )
                ),
            new Product
                (
                    Set.of(new LottoNo(7),
                        new LottoNo(8),
                        new LottoNo(9),
                        new LottoNo(5),
                        new LottoNo(6),
                        new LottoNo(1)
                    )
                )
        )
    )).isEqualTo(2);
  }

  @Test
  @DisplayName("로또 사이즈는 6자리입니다.")
  void lottoSizeException() {
    assertThrows(LottoSizeException.class, () -> {
      List<LottoNo> lottoNos = List.of(new LottoNo(7),
          new LottoNo(8),
          new LottoNo(8),
          new LottoNo(9),
          new LottoNo(5),
          new LottoNo(6));
      new Product(new HashSet<>(lottoNos));

      new Product(
          Set.of(new LottoNo(7),
              new LottoNo(8),
              new LottoNo(9),
              new LottoNo(5),
              new LottoNo(6),
              new LottoNo(10),
              new LottoNo(17)
          ));

    }).printStackTrace();
  }
}