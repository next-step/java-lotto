package rankingtwolotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rankingtwolotto.domain.Lotto;
import rankingtwolotto.domain.LottoNumber;
import rankingtwolotto.rankingexception.RankingValueException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class LottoTest {

    @DisplayName("로또 숫자범위 확인")
    @Test
    void lottoRangeTest() {
        assertThatExceptionOfType(RankingValueException.class).isThrownBy(() -> new LottoNumber(46));
    }

    @DisplayName("중복 로또 확인")
    @Test
    void duplicationLottoTest() {
        List<LottoNumber> testLotto = new ArrayList<>();
        testLotto.add(new LottoNumber(1));
        testLotto.add(new LottoNumber(2));
        testLotto.add(new LottoNumber(3));
        testLotto.add(new LottoNumber(3));
        testLotto.add(new LottoNumber(5));
        testLotto.add(new LottoNumber(6));
        assertThatExceptionOfType(RankingValueException.class).isThrownBy(() -> new Lotto(testLotto));
    }

    @DisplayName("로또 갯수 확인_빈값")
    @Test
    void lottoCountTest1() {
        List<LottoNumber> testLotto = new ArrayList<>();
        assertThatExceptionOfType(RankingValueException.class).isThrownBy(() -> new Lotto(testLotto));
    }

    @DisplayName("로또 갯수 확인_6개미만")
    @Test
    void lottoCountTest2() {
        List<LottoNumber> testLotto = new ArrayList<>();
        testLotto.add(new LottoNumber(1));
        testLotto.add(new LottoNumber(2));
        testLotto.add(new LottoNumber(3));
        testLotto.add(new LottoNumber(4));
        testLotto.add(new LottoNumber(5));
        assertThatExceptionOfType(RankingValueException.class).isThrownBy(() -> new Lotto(testLotto));
    }

    @DisplayName("로또 갯수 확인_6개초과")
    @Test
    void lottoCountTest3() {
        List<LottoNumber> testLotto = new ArrayList<>();
        testLotto.add(new LottoNumber(1));
        testLotto.add(new LottoNumber(2));
        testLotto.add(new LottoNumber(3));
        testLotto.add(new LottoNumber(4));
        testLotto.add(new LottoNumber(5));
        testLotto.add(new LottoNumber(6));
        testLotto.add(new LottoNumber(7));
        assertThatExceptionOfType(RankingValueException.class).isThrownBy(() -> new Lotto(testLotto));
    }
}
