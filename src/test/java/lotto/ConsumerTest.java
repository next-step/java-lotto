package lotto;

import lotto.factory.LottoFactory;
import lotto.factory.LottoNumberFactory;
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
        numbers.add(LottoNumberFactory.manualCreateNumber(5));
        numbers.add(LottoNumberFactory.manualCreateNumber(10));
        numbers.add(LottoNumberFactory.manualCreateNumber(15));
        numbers.add(LottoNumberFactory.manualCreateNumber(20));
        numbers.add(LottoNumberFactory.manualCreateNumber(30));
        numbers.add(LottoNumberFactory.manualCreateNumber(40));

        LottoNumbers lottoNumbers = LottoNumberFactory.manualCreateNumbers(numbers);
        Lotto lotto = LottoFactory.manualCreateSingleLotto(lottoNumbers);
        LottoWinner lottoWinner = new LottoWinner("10, 20, 30, 40, 5, 15");

        LottoStore.match(lotto, lottoWinner);

        LottoStats lottoStats = new LottoStats(lotto, purchaseAmount);

        assertThat(lottoStats.getRateOfRevenue()).isEqualTo(2000000.0f);
    }
}