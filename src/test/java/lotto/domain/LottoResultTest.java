package lotto.domain;

import calculator.util.StringUtil;
import lotto.util.StringSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    List<Integer> winningLottoNumbers = new ArrayList<>();
    Set<LottoTicket> lottoTickets = new HashSet<>();

    @BeforeEach
    void init() {
        winningLottoNumbers = StringUtil.textToInt("1,2,3,4,5,6".split(","));
    }

    @BeforeEach
    void setLottoTicket() {
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,5,6"))));
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,5,45"))));
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,5,7"))));
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,4,44,45"))));
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSplitter.splitText("1,2,3,43,44,45"))));
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST", "SECOND", "THIRD", "FORTH", "FIFTH"})
    @DisplayName("맞은 번호 수에 따른 등수 테스트 ")
    void analyze_lotto_rank(WinningPrize rank) {
        WinningLotto winningLotto = new WinningLotto(LottoMachine.createManualLottoNumbers(winningLottoNumbers), 7);
        LottoResult lottoResult = new LottoResult();
        lottoResult.analyzeLottoRank(lottoTickets, winningLotto);
        assertThat(lottoResult.getLottoResult().get(rank)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculate_prize_rate() {
        WinningLotto winningLotto = new WinningLotto(LottoMachine.createManualLottoNumbers(winningLottoNumbers), 7);
        LottoResult lottoResult = new LottoResult();
        lottoResult.analyzeLottoRank(lottoTickets, winningLotto);
        assertThat(lottoResult.calculatePrizeRate(5000)).isEqualTo(40631100);
    }
}
