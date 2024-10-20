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

    private Lotto lotto;
    private List<LottoNumber> lottoNumberList;
    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(10));
    }

    @Test
    void 로또_번호_6개만_남긴다() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lotto.addLottos(lottoNumbers);
        lotto.answerLotto(lottoNumbers);

        assertThat(lottoNumbers).hasSize(6).allMatch(lotto -> lotto.getNumber() >= 1 && lotto.getNumber() <= 45);
    }

    @Test
    void 로또를_생성한다() {
        lotto = lotto.generateLotto();
        assertThat(lotto.getLotto()).hasSize(6).allMatch(lotto -> lotto.getNumber() >= 1 && lotto.getNumber() <= 45);
    }

    @Test
    void 로또_번호_찾기_findLottoNumber() {
        Lotto lotto = new Lotto(lottoNumberList);
        IntStream.range(0, lotto.getLotto().size()).forEach(i -> {
            assertThat(lotto.findLottoNumber(i)).isEqualTo(lottoNumberList.get(i).getNumber());
        });
    }

    @Test
    void 로또번호_매칭_갯수(){
        LottoWinning winning = new LottoWinning("1, 2, 3, 4, 5, 10");
        Lotto lotto = new Lotto(lottoNumberList);
        assertThat(lotto.calculateMatchingCnt(winning)).isEqualTo(6);

        winning = new LottoWinning("1, 2, 3, 4, 5, 45");
        assertThat(lotto.calculateMatchingCnt(winning)).isEqualTo(5);

        winning = new LottoWinning("41, 42, 30, 44, 6");
        assertThat(lotto.calculateMatchingCnt(winning)).isEqualTo(0);

    }
}
