package lotto;

import lotto.utils.GenerateLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottosTest {

    @Test
    public void 로또번호가_1개_맞은개_1개면_정상() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("11,22,33,14,34,29");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLotto());
        lotto2.createLotto("11,2,23,14,25,26");
        lotto2.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLotto());
        lotto3.createLotto("1,12,3,14,5,16");
        lotto3.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLotto());
        lotto4.createLotto("11,28,13,4,9,6");
        lotto4.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLotto());
        lotto5.createLotto("29,2,31,34,5,16");
        lotto5.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLotto());
        lotto6.createLotto("31,32,3,34,5,36");
        lotto6.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto6);

        assertThat(Lottos.filter(lottos, 1)).hasSize(1);
    }

    @Test
    public void 로또번호가_2개_맞은개_3개면_정상() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("11,22,33,14,34,29");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLotto());
        lotto2.createLotto("11,2,23,14,25,26");
        lotto2.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLotto());
        lotto3.createLotto("1,12,3,14,5,16");
        lotto3.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLotto());
        lotto4.createLotto("11,28,13,4,9,6");
        lotto4.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLotto());
        lotto5.createLotto("29,2,31,34,5,16");
        lotto5.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLotto());
        lotto6.createLotto("31,32,3,34,5,36");
        lotto6.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto6);

        assertThat(Lottos.filter(lottos, 2)).hasSize(3);
    }


    @Test
    public void 로또번호가_3개_맞은개_3개면_정상() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("11,22,33,14,34,29");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLotto());
        lotto2.createLotto("11,2,23,14,25,26");
        lotto2.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLotto());
        lotto3.createLotto("1,12,3,14,5,16");
        lotto3.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLotto());
        lotto4.createLotto("11,28,13,4,9,6");
        lotto4.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLotto());
        lotto5.createLotto("29,2,31,34,5,16");
        lotto5.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLotto());
        lotto6.createLotto("31,32,3,34,5,36");
        lotto6.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto6);

        assertThat(Lottos.filter(lottos, 3)).hasSize(3);
    }

    @Test
    public void 로또번호가_4개_맞은개_1개면_정상() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("11,30,33,14,34,29");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLotto());
        lotto2.createLotto("11,2,23,14,25,26");
        lotto2.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLotto());
        lotto3.createLotto("1,12,3,14,5,16");
        lotto3.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLotto());
        lotto4.createLotto("11,28,13,4,9,6");
        lotto4.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLotto());
        lotto5.createLotto("29,2,31,34,5,16");
        lotto5.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLotto());
        lotto6.createLotto("31,32,3,34,5,36");
        lotto6.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto6);

        assertThat(Lottos.filter(lottos, 4)).hasSize(1);
    }

    @Test
    public void 로또번호가_5개_맞은개_2개면_정상() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("11,30,33,32,34,29");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLotto());
        lotto2.createLotto("29,30,31,32,33,26");
        lotto2.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLotto());
        lotto3.createLotto("1,12,3,14,5,16");
        lotto3.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLotto());
        lotto4.createLotto("11,28,13,4,9,6");
        lotto4.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLotto());
        lotto5.createLotto("29,2,31,34,5,16");
        lotto5.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLotto());
        lotto6.createLotto("31,32,3,34,5,36");
        lotto6.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto6);

        assertThat(Lottos.filter(lottos, 5)).hasSize(2);
    }

    @Test
    public void 로또번호가_6개_맞은개_2개면_정상() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(29, 30, 31, 32, 33, 34)));

        final List<Lotto> lottos = new ArrayList<>();

        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("11,30,33,32,34,29");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        final Lotto lotto2 = new Lotto(new GenerateLotto());
        lotto2.createLotto("29,30,31,32,33,26");
        lotto2.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto2);

        final Lotto lotto3 = new Lotto(new GenerateLotto());
        lotto3.createLotto("1,12,3,14,5,16");
        lotto3.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto3);

        final Lotto lotto4 = new Lotto(new GenerateLotto());
        lotto4.createLotto("11,28,13,4,9,6");
        lotto4.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto4);

        final Lotto lotto5 = new Lotto(new GenerateLotto());
        lotto5.createLotto("29,30,31,32,33,34");
        lotto5.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto5);

        final Lotto lotto6 = new Lotto(new GenerateLotto());
        lotto6.createLotto("34,33,32,31,30,29");
        lotto6.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto6);

        assertThat(Lottos.filter(lottos, 6)).hasSize(2);
    }

    @Test
    public void 로또번호_3개가_맞았을떄_수익률_계산() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        final List<Lotto> lottos = new ArrayList<>();
        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("1,2,3,30,31,32");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        assertThat(Lottos.getRate(lottos, 100000)).isEqualTo(0.05);
    }

    @Test
    public void 로또번호_4개가_맞았을떄_수익률_계산() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        final List<Lotto> lottos = new ArrayList<>();
        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("1,2,3,4,31,32");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        assertThat(Lottos.getRate(lottos, 100000)).isEqualTo(0.5);
    }

    @Test
    public void 로또번호_5개가_맞았을떄_수익률_계산() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        final List<Lotto> lottos = new ArrayList<>();
        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("1,2,3,4,5,32");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        assertThat(Lottos.getRate(lottos, 100000)).isEqualTo(15);
    }

    @Test
    public void 로또번호_6개가_맞았을떄_수익률_계산() {

        final LottoNumber sourceLottoNumber = new LottoNumber(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));

        final List<Lotto> lottos = new ArrayList<>();
        final Lotto lotto1 = new Lotto(new GenerateLotto());
        lotto1.createLotto("1,2,3,4,5,6");
        lotto1.calculatorMatchLottoNumber(sourceLottoNumber);
        lottos.add(lotto1);

        assertThat(Lottos.getRate(lottos, 100000)).isEqualTo(20000);
    }

}