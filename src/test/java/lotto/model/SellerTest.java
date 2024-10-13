package lotto.model;

import lotto.model.dto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SellerTest {
    @Test
    void 당첨로또를_판매자에_저장한다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Seller actual = Seller.of(Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        });
    }

    @Test
    void 당첨로또번호목록을_출력한다() {
        List<LottoNumber> actual = Seller.of(Lotto.of(() -> List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))).winningLotto().numbers();
        List<LottoNumber> expected = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
