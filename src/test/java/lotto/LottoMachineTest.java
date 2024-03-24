package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("장당 1000원에 로또를 구매한다")
    public void 로또_구매() {
        Money money = new Money(2000);
        LottoMachine sut = new LottoMachine();

        Lottos lottos = sut.buyLotto(money);

        assertThat(lottos.count()).isEqualTo(2);
    }


    @Test
    public void 로또_결과_1등_2등() {

        LottoMachine sut = new LottoMachine();
        Lottos lottos = 로또_번호_지정_생성(
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 8)));

        LottoSummary summary = sut.summarizeLotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), lottos);
        assertThat(summary.getFirstRankCount()).isEqualTo(1);
        assertThat(summary.getSecondRankCount()).isEqualTo(1);
        assertThat(summary.getThirdRankCount()).isEqualTo(0);
        assertThat(summary.getForthRankCount()).isEqualTo(0);
    }

    public Lottos 로또_번호_지정_생성(LottoNumbers... numbers) {
        return new Lottos(Arrays.stream(numbers)
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }
}