package lotto.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoPurchaserTest {
    private Lotto createLotto(int... ints) {
        return new Lotto(Arrays.stream(ints)
            .boxed()
            .map(LottoNumber::new)
            .collect(toList()));
    }

    private List<Lotto> createLottos(Lotto... lottos) {
        return Arrays.stream(lottos)
            .collect(toList());
    }
    @Test
    @DisplayName("로또 금액을 자동으로 사면 이에 해당하는 로또의 개수를 반환한다")
    void 금액만큼_로또_구매() {
        // given
        LottoPurchaser purchaser = new LottoPurchaser(new LottoMoney(14000));
        // when
        purchaser = purchaser.buyAutoTicket(new AutoLottoGenerator());
        // then
        assertThat(purchaser.getPurchasedLottos().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 수동 수와 수동 번호를 입력하면 수동으로 산다")
    void 수동_수_수동_번호_만큼_수동으로_산다() {
        // given
        List<List<Integer>> lottos = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44)
        );
        LottoPurchaser purchaser = new LottoPurchaser(new LottoMoney(14000));
        // when
        purchaser = purchaser.buyFixTicket(new Count(3), lottos);
        // then
        assertThat(purchaser.getCurrentLottoMoney()).isEqualTo(new LottoMoney(11000));
        assertThat(purchaser.getPurchasedLottos()).isEqualTo(createLottos(
            createLotto(8, 21, 23, 41, 42, 43),
            createLotto(3, 5, 11, 16, 32, 38),
            createLotto(7, 11, 16, 35, 36, 44)
        ));
    }


    @Test
    @DisplayName("로또 수동 수와 수동 번호를 입력하면, 남은 돈은 자동 티켓으로 산다")
    void 수동_수_수동_번호_남은돈은_자동(){
        // given
        List<List<Integer>> lottos = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44)
        );
        LottoPurchaser purchaser = new LottoPurchaser(new LottoMoney(14000));
        // when
        purchaser = purchaser.purchaseLotto(new Count(3), lottos);
        // then
        assertThat(purchaser.getCurrentLottoMoney()).isEqualTo(new LottoMoney(0));
        assertThat(purchaser.getPurchasedLottos().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 수동 수와 로또 번호 수가 일치하면, 정상 동작한다.")
    void 수동_수_수동_번호_일치하면_정상_동작(){
        // given
        List<List<Integer>> lottos = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44)
        );
        Count manualCount = new Count(3);
        LottoPurchaser purchaser = new LottoPurchaser(new LottoMoney(14000));
        // when
        assertThatCode(() -> purchaser.buyFixTicket(manualCount, lottos)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 수동 수와 로또 번호 수가 일치하지 않으면, 오류를 반환한다")
    void 수동_수_수동_번호_일치하지_않으면_오류(){
        // given
        List<List<Integer>> lottos = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44)
        );
        Count manualCount = new Count(2);
        LottoPurchaser purchaser = new LottoPurchaser(new LottoMoney(14000));
        // when
        assertThatCode(() -> purchaser.buyFixTicket(manualCount, lottos))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 구입 수와 로또 번호 입력 수가 일치하지 않습니다");
    }

    @Test
    @DisplayName("로또 수동 수가 현재 금액보다 크면 오류를 반환한다")
    void 수동_수가_현재_금액보다_크면_오류(){
        // given
        List<List<Integer>> lottos = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44)
        );
        Count manualCount = new Count(3);
        LottoPurchaser purchaser = new LottoPurchaser(new LottoMoney(1000));
        // when
        assertThatCode(() -> purchaser.buyFixTicket(manualCount, lottos))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동으로 구매할 로또 수가 현재 가지고 있는 돈보다 많습니다.");
    }
}
