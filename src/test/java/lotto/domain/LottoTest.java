package lotto.domain;

import lotto.LottoMachine;
import lotto.view.LottoResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 21:43
 */
public class LottoTest {
    @Test
    void create_lotto_test() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    void create_lotto_number_test() {
        LottoNumberStrategy lottoNumberStrategy = new LottoNumberStrategy();
        List<Integer> lottoNumbers = lottoNumberStrategy.randomNumbers();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(value -> value >= 1 && value <= 45);
    }

    @Test
    void lotto_shuffle_test() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    void create_lotto_machine_test() {
        LottoMachine lottoMachine = new LottoMachine(14);
        assertThat(lottoMachine).isEqualTo(new LottoMachine(14));
    }

    @Test
    void create_amount_test() {
        LottoAmount amount = new LottoAmount(14000);
        assertThat(amount).isEqualTo(new LottoAmount(14000));
    }

    @Test
    void get_purchased_lotto_count() {
        LottoAmount amount = new LottoAmount(14000);
        assertThat(amount.getPurchasedLottoCount()).isEqualTo(14);
    }

    @Test
    void 로또_적은_금액으로_사보기() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoAmount amount = new LottoAmount(500);
        }).withMessageMatching("건네주신 금액으로는 로또를 살 수 없습니다.");
    }

    @Test
    void 로또_당첨_매치() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int[] matchNumber = {1,2,3,4,5,6};
        assertThat(lotto.matchLottoNumberCount(matchNumber)).isEqualTo(6);
    }
}

