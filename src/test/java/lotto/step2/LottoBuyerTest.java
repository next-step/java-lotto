package lotto.step2;

import lotto.step2.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoBuyerTest {

    LottoBuyer lottoResult;
    List<LottoNumber> winningNumber;

    @BeforeEach
    void init() {
        winningNumber = new ArrayList<>();
        winningNumber.add(new LottoNumber(1));
        winningNumber.add(new LottoNumber(2));
        winningNumber.add(new LottoNumber(3));
        winningNumber.add(new LottoNumber(4));
        winningNumber.add(new LottoNumber(5));
        winningNumber.add(new LottoNumber(6));
        lottoResult = new LottoBuyer(LottoTicket.generateWinningNumber(winningNumber));
    }

    @Test
    @DisplayName("로또 당첨 번호와 2개 번호 일치")
    void matchTwoNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(12));
        lottoNumbers.add(new LottoNumber(14));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FOURTH_PLACE, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 당첨 번호와 3개 번호 일치")
    void matchThreeNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(14));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FOURTH_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 번호와 4개 번호 일치")
    void matchFourNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(15));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.THIRD_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 번호와 5개 번호 일치")
    void matchFiveNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(16));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.SECOND_PLACE, 0)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 당첨 번호와 6개 번호 일치")
    void matchSixNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(6));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(1));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        lottoResult.checkLottoTicket(lottoTicket);
        assertThat(lottoResult.getLottoResult().getOrDefault(WinningRank.FIRST_PLACE, 0)).isEqualTo(1);
    }

}