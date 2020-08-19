package lotto.domain;

import calculator.util.StringUtil;
import lotto.util.StringSpliter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    List<Integer> lottoNumbers = new ArrayList<>();
    Set<LottoTicket> lottoTickets = new HashSet<>();
    LottoResult lottoResult = new LottoResult();

    @BeforeEach
    void init() {
        lottoNumbers = StringUtil.textToInt("1,2,3,4,5,6".split(","));
    }

    @BeforeEach
    void setLottoTicket() {
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSpliter.splitText("1,2,3,4,5,6"))));
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSpliter.splitText("1,2,3,4,5,45"))));
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSpliter.splitText("1,2,3,4,44,45"))));
        lottoTickets.add(new LottoTicket(LottoMachine.createManualLottoNumbers(StringSpliter.splitText("1,2,3,43,44,45"))));
    }

    @Test
    @DisplayName("수익률 계산")
    void calculatePrizeRate() {
        WinningLotto winningLotto = new WinningLotto(LottoMachine.createManualLottoNumbers(lottoNumbers));
        lottoResult.analyzeLottoRank(lottoTickets, winningLotto);
        assertThat(lottoResult.calculatePrizeRate(4000)).isEqualTo(50038800);
    }
}
