package lotto.domain;

import lotto.vo.Money;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    public void 입력값_만큼_자동_로또_가져오기() {
        // given
        int numberOfLottos = 5;

        // when
        LottoBundle lottoBundle = LottoMachine.getAutoLottoBundle(5);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(numberOfLottos);
    }

    @Test
    public void 로또를_구매할_수_있는_금액이_아닌_경우_IllegalArgumentException() {
        // given
        Money money = new Money(500);

        //when
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> LottoMachine.buyLottos(money));
    }

    @Test
    public void 금액_만큼_로또를_구매하기_잔액없는경우() {
        // given
        Money money = new Money(10_000);

        // when
        LottoBundle lottoBundle = LottoMachine.buyLottos(money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(10);
    }

    @Test
    public void 금액_만큼_로또를_구매하기_잔액있는경우() {
        // given
        Money money = new Money(10_500);

        // when
        LottoBundle lottoBundle = LottoMachine.buyLottos(money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(10);
    }

    @Test
    public void 수동_입력_포함_로또_구매하기_로또_수_확인() {
        // given
        Money money = new Money(10_000);
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6");

        // when
        LottoBundle lottoBundle = LottoMachine.buyLottos(manualLottos, money);

        // then
        assertThat(lottoBundle.getLottos()).hasSize(10);
    }

    @Test
    public void 수동_입력_포함_로또_구매하기_수동_로또_포함_확인() {
        // given
        Money money = new Money(10_000);
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6");

        // when
        LottoBundle lottoBundle = LottoMachine.buyLottos(manualLottos, money);

        // then
        Lotto manualLotto = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        long shouldBeOne = lottoBundle.getLottos().stream()
                .filter(manualLotto::isEqualTo)
                .count();

        assertThat(shouldBeOne).isEqualTo(1);
    }

    @Test
    public void 수동_입력한_로또가_구매_가능_금액을_초과할_경우_IllegalArgumentException() {
        // given
        Money money = new Money(1_000);
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 15, 16");

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> LottoMachine.buyLottos(manualLottos, money));
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}
