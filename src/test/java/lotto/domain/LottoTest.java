package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    public void 로또_일치_여부() {
        List<LottoNumbers> lottoNumbersList = List.of(
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 7)),
                new LottoNumbers(List.of(1, 2, 3, 4, 7, 8)),
                new LottoNumbers(List.of(1, 2, 3, 7, 8, 9)),
                new LottoNumbers(List.of(1, 2, 7, 8, 9, 10))
        );

        LottoPrice price = new LottoPrice(1000);
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(new Lotto(price, lottoNumbersList).matches(3, winningNumbers)).isEqualTo(1);
    }
}
