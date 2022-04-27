package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Grade;
import lotto.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @Test
  @DisplayName("로또 번호가 맞는지 테스트")
  void awardCount() {
    List<Product> allLotto = Arrays.asList(new Product(List.of(1, 2, 3, 4, 5, 6)),
        new Product(List.of(6, 7, 8, 9, 11, 30)));
    List<Integer> winNumbers = Arrays.asList(9, 8, 6, 29, 30, 45);
  }
}