package lotto.domain.lotto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoBundleTest {

    @Test
    public void 번들_초기화() {
        LottoBundle lottoBundle = new LottoBundle();

        assertThat(lottoBundle.getLottos().size()).isEqualTo(0);
    }

    @Test
    public void 로또_한개_추가() {
        LottoBundle lottoBundle = new LottoBundle();
        lottoBundle.add(new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6)));

        assertThat(lottoBundle.getLottos().size()).isEqualTo(1);
    }

    @Test
    public void 로또_여러개_추가() {
        LottoBundle lottoBundle = new LottoBundle();
        lottoBundle.add(new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6)));
        lottoBundle.add(new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6)));
        lottoBundle.add(new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6)));

        assertThat(lottoBundle.getLottos().size()).isEqualTo(3);
    }

    @Test
    public void 로또_여러개_한번에_추가() {
        LottoBundle lottoBundle = new LottoBundle();
        LottoBundle inputBundle = new LottoBundle();
        inputBundle.add(new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6)));
        inputBundle.add(new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6)));
        inputBundle.add(new BasicLotto(new Ticket(1, 2, 3, 4, 5, 6)));

        lottoBundle.addAll(inputBundle);

        assertThat(lottoBundle.getLottos().size()).isEqualTo(3);
    }
}
