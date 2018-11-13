package game.lotto.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRegistryTest {

    private LottoRegistry lottoRegistry;

    @Before
    public void setup() {
        lottoRegistry = new LottoRegistry();
    }

    @Test
    public void 기본생성자() {
        assertThat(lottoRegistry.size()).isEqualTo(0);
    }

    @Test
    public void Collection생성자() {
        final List<Lotto> lottos = createTestLottos(5);
        lottoRegistry = new LottoRegistry(lottos);

        assertThat(lottoRegistry.size()).isEqualTo(lottos.size());
    }

    @Test
    public void 로또추가() {
        final int beforeSize = lottoRegistry.size();

        lottoRegistry.regist(Lotto.auto());

        assertThat(lottoRegistry.size()).isEqualTo(beforeSize + 1);
    }

    @Test
    public void 로또_여러개_추가() {
        final int beforeSize = lottoRegistry.size();
        final List<Lotto> lottos = createTestLottos(5);

        lottoRegistry.regists(lottos);

        assertThat(lottoRegistry.size()).isEqualTo(beforeSize + lottos.size());
        assertThat(lottoRegistry.getLottos()).isEqualTo(lottos);
    }


    private List<Lotto> createTestLottos(int size) {
        return IntStream.range(0, size).mapToObj(i -> Lotto.auto()).collect(Collectors.toList());
    }

    @Test
    public void 수량확인() {
        final List<Lotto> lottos = createTestLottos(5);
        lottos.add(Lotto.manual(LottoNumberFactory.createLottoNumbers("2, 4, 5, 6, 7, 8")));

        lottoRegistry.regists(lottos);

        Amount amount = lottoRegistry.getAmount();

        assertThat(amount.getAutoCount()).isEqualTo(lottos.size() - 1);
        assertThat(amount.getManualCount()).isEqualTo(1);
        assertThat(amount.getTotalAmount()).isEqualTo(lottos.size());
    }

}