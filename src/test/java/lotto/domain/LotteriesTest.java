package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @DisplayName("로또 목록을 갖고올 수 있다.")
    @Test
    void getLottoNumbers() {
        Lotto lotto = new Lotto();
        Lotteries lotteries = lotto.buy(new Price(2000));

        final List<LottoNumbers> lottoNumbers = lotteries.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(2);
    }

}