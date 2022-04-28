package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.enums.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

  @Test
  @DisplayName("당첨 번호와 몇개가 맞는지 테스트한다")
  void coincide() {
    Product product = new Product(
        List.of(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5),
            new LottoNo(6)));

    assertThat(product.coincideLotto(Grade.THREE, List.of
        (
            new Product
                (
                    List.of(new LottoNo(1),
                        new LottoNo(2),
                        new LottoNo(3),
                        new LottoNo(7),
                        new LottoNo(8),
                        new LottoNo(9)
                    )
                ),
            new Product
                (
                    List.of(new LottoNo(7),
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
}