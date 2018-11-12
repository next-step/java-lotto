package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.utils.GenerateLottoMachine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottosTest {

    @Test
    public void 로또번호가_한개만_맞은_경우() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLottoMachine());
        lotto1.createLotto("11,22,33,14,34,29");
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLottoMachine());
        lotto2.createLotto("11,2,23,14,25,26");
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLottoMachine());
        lotto3.createLotto("1,12,3,14,5,16");
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLottoMachine());
        lotto4.createLotto("11,28,13,4,9,6");
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLottoMachine());
        lotto5.createLotto("29,2,31,34,5,16");
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLottoMachine());
        lotto6.createLotto("31,32,3,34,5,36");
        lottos.add(lotto6);

        assertThat(Lottos.filter(sourceLottoNumber, lottos, 1)).hasSize(1);
    }

    @Test
    public void 로또번호를_전부_맞춘_경우() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLottoMachine());
        lotto1.createLotto("11,30,33,32,34,29");
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLottoMachine());
        lotto2.createLotto("29,30,31,32,33,26");
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLottoMachine());
        lotto3.createLotto("1,12,3,14,5,16");
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLottoMachine());
        lotto4.createLotto("11,28,13,4,9,6");
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLottoMachine());
        lotto5.createLotto("29,30,31,32,33,34");
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLottoMachine());
        lotto6.createLotto("34,33,32,31,30,29");
        lottos.add(lotto6);

        assertThat(Lottos.filter(sourceLottoNumber, lottos, 6)).hasSize(2);
    }

    @Test
    public void 로또번호_3개가_맞았을떄_수익률_계산() {

        final LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto = new Lotto(new GenerateLottoMachine());
        lotto.createLotto("1,2,3,30,31,32");
        lottos.add(lotto);

        assertThat(Lottos.getRate(lottoNumber, lottos, 100000)).isEqualTo(0.05);
    }

    @Test
    public void 로또번호_6개가_맞았을떄_수익률_계산() {

        final LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto = new Lotto(new GenerateLottoMachine());
        lotto.createLotto("1,2,3,4,5,6");
        lottos.add(lotto);

        assertThat(Lottos.getRate(lottoNumber, lottos, 100000)).isEqualTo(20000);
    }

}