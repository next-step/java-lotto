package lotto;

import lotto.model.lottos.Lotto;
import lotto.model.lottos.LottoNumber;
import lotto.model.Rank;
import lotto.model.winninglotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    private List<LottoNumber> myLottoNumbers = new ArrayList<>();

    @DisplayName("LottoNumber 객체 6개를 주면 정상적으로 Lotto 객체 생성")
    @Test
    void createTest() {
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatCode(() -> new Lotto(lottoNumbers)).doesNotThrowAnyException();
    }

    @DisplayName("LottoNumber 객체가 6개보다 적으면 예외 발생")
    @Test
    void throwExceptionWhenNotSixLottoNumbers() {
        for (int i = 1; i <= 5; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        });
    }

    @DisplayName("LottoNumber 객체가 6개보다 많으면 예외 발생")
    @Test
    void throwExceptionWhenNotSixLottoNumbers_2() {
        for (int i = 1; i <= 7; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        });
    }

    @DisplayName("중복된 숫자가 있으면 예외 발생")
    @Test
    void throwExceptionWhenDuplication() {
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(new LottoNumber(1));
        }

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(lottoNumbers);
        });
    }

    @DisplayName("1등 확인")
    @Test
    void matchTestForFirst() {
        //given
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        Lotto myLotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(myLotto, new LottoNumber(7));

        //when
        Rank rank = myLotto.match(winningLotto);

        //then
        assertThat(rank).isEqualTo(FIRST);
    }

    @DisplayName("2등 확인")
    @Test
    void matchTestForSecond() {
        //given
        WinningLotto winningLotto = new WinningLotto(createLottoFromOneToSix(), new LottoNumber(7));

        for (int i = 2; i <= 7; i++) {
            myLottoNumbers.add(new LottoNumber(i));
        }
        Lotto myLotto = new Lotto(myLottoNumbers);

        //when
        Rank rank = myLotto.match(winningLotto);

        //then
        assertThat(rank).isEqualTo(SECOND);
    }

    @DisplayName("3등 확인")
    @Test
    void matchTestForThird() {
        //given
        WinningLotto winningLotto = new WinningLotto(createLottoFromOneToSix(), new LottoNumber(8));

        for (int i = 2; i <= 7; i++) {
            myLottoNumbers.add(new LottoNumber(i));
        }
        Lotto myLotto = new Lotto(myLottoNumbers);

        //when
        Rank rank = myLotto.match(winningLotto);

        //then
        assertThat(rank).isEqualTo(THIRD);
    }

    @DisplayName("4등 확인")
    @Test
    void matchTestForFourth() {
        //given
        WinningLotto winningLotto = new WinningLotto(createLottoFromOneToSix(), new LottoNumber(9));

        for (int i = 3; i <= 8; i++) {
            myLottoNumbers.add(new LottoNumber(i));
        }
        Lotto myLotto = new Lotto(myLottoNumbers);

        //when
        Rank rank = myLotto.match(winningLotto);

        //then
        assertThat(rank).isEqualTo(FOURTH);
    }

    @DisplayName("5등 확인")
    @Test
    void matchTestForFifth() {
        //given
        WinningLotto winningLotto = new WinningLotto(createLottoFromOneToSix(), new LottoNumber(10));

        for (int i = 4; i <= 9; i++) {
            myLottoNumbers.add(new LottoNumber(i));
        }
        Lotto myLotto = new Lotto(myLottoNumbers);

        //when
        Rank rank = myLotto.match(winningLotto);

        //then
        assertThat(rank).isEqualTo(FIFTH);
    }

    @DisplayName("꽝 확인")
    @Test
    void matchTestForBlank() {
        //given
        WinningLotto winningLotto = new WinningLotto(createLottoFromOneToSix(), new LottoNumber(20));

        for (int i = 5; i <= 10; i++) {
            myLottoNumbers.add(new LottoNumber(i));
        }
        Lotto myLotto = new Lotto(myLottoNumbers);

        //when
        Rank rank = myLotto.match(winningLotto);

        //then
        assertThat(rank).isEqualTo(BLANK);
    }

    Lotto createLottoFromOneToSix(){
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return new Lotto(lottoNumbers);
    }
}