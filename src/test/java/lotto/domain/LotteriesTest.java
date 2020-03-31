package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    private LottoNumber bonusBall;

    @BeforeEach
    void setUp() {
        bonusBall = LottoNumber.valueOf(12);
    }

    @DisplayName("로또 복권은 6개의 로또 번호를 가지도록 객체 생성을 할 수 있다.")
    @Test
    void create() {
        Lotteries expect = new Lotteries(createLottoNumbers());

        Lotteries actual = new Lotteries(createLottoNumbers());

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("로또 목록을 갖고올 수 있다.")
    @Test
    void getLottoNumbers() {
        Lotteries lotteries = LottoStore.sell(new Price(2000), new ArrayList<>());

        final List<LottoNumbers> lottoNumbers = lotteries.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(2);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 일치하지 않는다.")
    @Test
    void analyzeWin_NotMatch() {
        Lotteries lotteries = new Lotteries(createLottoNumbers());
        LottoNumbers winningLottoNumber = new LottoNumbers("7, 8, 9, 10, 11, 12");
        int expect = 1;

        LottoResult actual = lotteries.analyzeWin(winningLottoNumber, bonusBall);

        assertThat(actual.wihCount(LottoRank.BLANK)).isEqualTo(expect);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 3개 일치한다. (4등)")
    @Test
    void analyzeWin_Fourth() {
        Lotteries lotteries = new Lotteries(createLottoNumbers());
        LottoNumbers winningLottoNumber = new LottoNumbers("1, 2, 3, 10, 11, 12");
        int expect = 1;

        LottoResult actual = lotteries.analyzeWin(winningLottoNumber, bonusBall);

        assertThat(actual.wihCount(LottoRank.FOURTH)).isEqualTo(expect);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 4개 일치한다. (3등)")
    @Test
    void analyzeWin_Third() {
        Lotteries lotteries = new Lotteries(createLottoNumbers());
        LottoNumbers winningLottoNumber = new LottoNumbers("1, 2, 3, 4, 11, 12");
        int expect = 1;

        LottoResult actual = lotteries.analyzeWin(winningLottoNumber, bonusBall);

        assertThat(actual.wihCount(LottoRank.THIRD)).isEqualTo(expect);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 5개 일치한다. (2등)")
    @Test
    void analyzeWin_Second() {
        Lotteries lotteries = new Lotteries(createLottoNumbers());
        LottoNumbers winningLottoNumber = new LottoNumbers("1, 2, 3, 4, 5, 12");
        int expect = 1;

        LottoResult actual = lotteries.analyzeWin(winningLottoNumber, bonusBall);

        assertThat(actual.wihCount(LottoRank.SECOND)).isEqualTo(expect);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 6개 일치한다. (1등)")
    @Test
    void analyzeWin_First() {
        Lotteries lotteries = new Lotteries(createLottoNumbers());
        LottoNumbers winningLottoNumber = new LottoNumbers("1, 2, 3, 4, 5, 6");
        int expect = 1;

        LottoResult actual = lotteries.analyzeWin(winningLottoNumber, bonusBall);

        assertThat(actual.wihCount(LottoRank.FIRST)).isEqualTo(expect);
    }

    @DisplayName("보너스볼을 갖고 있다.")
    @Test
    void hasBonusBall_True() {
        LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 12");

        boolean hasBonusBall = lottoNumbers.hasBonusBall(bonusBall);

        assertThat(hasBonusBall).isTrue();
    }

    @DisplayName("보너스볼을 갖고 있지 않다.")
    @Test
    void hasBonusBall_False() {
        LottoNumbers lottoNumbers = new LottoNumbers("2, 3, 4, 5, 6, 7");

        boolean hasBonusBall = lottoNumbers.hasBonusBall(bonusBall);

        assertThat(hasBonusBall).isFalse();
    }

    private List<LottoNumbers> createLottoNumbers() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
            lottoNumbers.add(new LottoNumbers(
                    Arrays.asList(
                            LottoNumber.valueOf(1)
                            , LottoNumber.valueOf(2)
                            , LottoNumber.valueOf(3)
                            , LottoNumber.valueOf(4)
                            , LottoNumber.valueOf(5)
                            , LottoNumber.valueOf(6)
                    )
            )
        );
        return lottoNumbers;
    }
}