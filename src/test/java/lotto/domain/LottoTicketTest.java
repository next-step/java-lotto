package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @DisplayName("내가 구매한 복권이 1등인지 확인할 수 있다.")
    @Test
    void matchFirstTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumbers));
        LottoTicket lottoTicket = new LottoTicket(lottos);

        String lastWinningNumber = "1,2,3,4,5,7";
        int lastBonusNumber = 10;

        Lotto lastWinningLotto = new Lotto(lastWinningNumber, lastBonusNumber);
        LottoRank second = LottoRank.FIRST;
        int expected = 1;

        LottoResult lottoResult = lottoTicket.matchWinning(lastWinningLotto);
        int actual = lottoResult.getMatchCount(second);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("내가 구매한 복권이 2등인지 확인할 수 있다.")
    @Test
    void matchSecondTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumbers));
        LottoTicket lottoTicket = new LottoTicket(lottos);

        String lastWinningNumber = "1,2,3,4,5,6";
        int lastBonusNumber = 7;

        Lotto lastWinningLotto = new Lotto(lastWinningNumber, lastBonusNumber);
        LottoRank second = LottoRank.SECOND;
        int expected = 1;

        LottoResult lottoResult = lottoTicket.matchWinning(lastWinningLotto);
        int actual = lottoResult.getMatchCount(second);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("내가 구매한 복권이 3등인지 확인할 수 있다.")
    @Test
    void matchThirdTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumbers));
        LottoTicket lottoTicket = new LottoTicket(lottos);

        String lastWinningNumber = "1,2,3,4,5,6";
        int lastBonusNumber = 10;

        Lotto lastWinningLotto = new Lotto(lastWinningNumber, lastBonusNumber);
        LottoRank second = LottoRank.THIRD;
        int expected = 1;

        LottoResult lottoResult = lottoTicket.matchWinning(lastWinningLotto);
        int actual = lottoResult.getMatchCount(second);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("내가 구매한 복권이 4등인지 확인할 수 있다.")
    @Test
    void matchFourthTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumbers));
        LottoTicket lottoTicket = new LottoTicket(lottos);

        String lastWinningNumber = "1,2,3,4,11,22";
        int lastBonusNumber = 10;

        Lotto lastWinningLotto = new Lotto(lastWinningNumber, lastBonusNumber);
        LottoRank second = LottoRank.FOURTH;
        int expected = 1;

        LottoResult lottoResult = lottoTicket.matchWinning(lastWinningLotto);
        int actual = lottoResult.getMatchCount(second);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("내가 구매한 복권이 5등인지 확인할 수 있다.")
    @Test
    void matchFifthTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(7));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumbers));
        LottoTicket lottoTicket = new LottoTicket(lottos);

        String lastWinningNumber = "1,2,3,11,22,33";
        int lastBonusNumber = 10;

        Lotto lastWinningLotto = new Lotto(lastWinningNumber, lastBonusNumber);
        LottoRank second = LottoRank.FIFTH;
        int expected = 1;

        LottoResult lottoResult = lottoTicket.matchWinning(lastWinningLotto);
        int actual = lottoResult.getMatchCount(second);

        assertThat(actual).isEqualTo(expected);
    }
}
