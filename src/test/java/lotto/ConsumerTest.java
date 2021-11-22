package lotto;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsumerTest {

    @Test
    @DisplayName("통합 테스트")
    void integrationTest() {
        int purchaseAmount = 1000;

        List<LottoNumber> numbers = new ArrayList<>();
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(10));
        numbers.add(new LottoNumber(15));
        numbers.add(new LottoNumber(20));
        numbers.add(new LottoNumber(30));
        numbers.add(new LottoNumber(40));

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoWinner lottoWinner = new LottoWinner("10, 20, 30, 40, 5, 15");

        LottoStore.match(lotto, lottoWinner);

        LottoStats lottoStats = new LottoStats(lotto, purchaseAmount);

        assertThat(lottoStats.getRateOfRevenue()).isEqualTo(2000000.0f);
    }
}