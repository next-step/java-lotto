package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoWinning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private List<LottoNumber> lottoNumberList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(10));
    }

    @Test
    void 로또_번호_찾기_findLottoNumber() {
        Lotto lotto = new Lotto(lottoNumberList);
        IntStream.range(0, lotto.getLotto().size()).forEach(i -> {
            assertThat(lotto.findLottoNumber(i)).isEqualTo(lottoNumberList.get(i).getNumber());
        });
    }

    @Test
    void 로또번호_매칭_갯수() {
        LottoWinning winning = new LottoWinning("1, 2, 3, 4, 5, 10", 11);
        Lotto lotto = new Lotto(lottoNumberList);

        assertThat(lotto.calculateMatchingCnt(winning)).isEqualTo(6);

        winning = new LottoWinning("41, 42, 30, 44, 6", 10);

        assertThat(lotto.calculateMatchingCnt(winning)).isEqualTo(0);

    }

    @Test
    void 로또_2등_보너스_여부() {

        LottoWinning winning = new LottoWinning("1, 2, 3, 4, 5, 45", 10);
        Lotto lotto = new Lotto(lottoNumberList);;

        assertThat(lotto.isTwoBonusWin(5, winning)).isTrue();


        winning = new LottoWinning("1, 2, 3, 4, 7, 45", 10);
        Lotto notMatchingCntLotto = new Lotto(lottoNumberList);;

        assertThat(notMatchingCntLotto.isTwoBonusWin(4, winning)).isFalse();

        winning = new LottoWinning("1, 2, 3, 4, 7, 45", 44);
        Lotto noBonustNumberLotto = new Lotto(lottoNumberList);;

        assertThat(noBonustNumberLotto.isTwoBonusWin(5, winning)).isFalse();

    }
}
