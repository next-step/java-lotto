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
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)))).isEqualTo(Product.from(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6))));
  }

  @Test
  @DisplayName("당첨 번호와 몇개가 맞는지 테스트한다")
  void coincide() {
    Product product = new Product(
        Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
            new LottoNumber(6)));

    assertThat(product.coincideLotto(Grade.FOURTH, List.of
        (
            new Product
                (
                    Set.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9)
                    )
                ),
            new Product
                (
                    Set.of(new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9),
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(1)
                    )
                )
        )
    )).isEqualTo(2);
  }

  @Test
  @DisplayName("로또 사이즈는 6자리입니다.")
  void lottoSizeException() {
    assertThrows(LottoSizeException.class, () -> {
      List<LottoNumber> lottoNumbers = List.of(new LottoNumber(7),
          new LottoNumber(8),
          new LottoNumber(8),
          new LottoNumber(9),
          new LottoNumber(5),
          new LottoNumber(6));
      new Product(new HashSet<>(lottoNumbers));

      new Product(
          Set.of(new LottoNumber(7),
              new LottoNumber(8),
              new LottoNumber(9),
              new LottoNumber(5),
              new LottoNumber(6),
              new LottoNumber(10),
              new LottoNumber(17)
          ));

    });
  }
}