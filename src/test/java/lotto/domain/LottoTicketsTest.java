package lotto.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    List<LottoNumber> firstLottoNumbers;
    List<LottoNumber> secondLottoNumbers;
    List<LottoNumber> winningLottoNumbers;

    @BeforeEach
    public void init() {
        this.firstLottoNumbers = Arrays.asList(new LottoNumber(5), new LottoNumber(6),
            new LottoNumber(7),
            new LottoNumber(8), new LottoNumber(9), new LottoNumber(10));
        this.secondLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        this.winningLottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }

    @Test
    void 로또_장당_당첨번호_개수_일치여부_테스트() {
        TestLottoGenerator testLottoGenerator = new TestLottoGenerator();
        LottoTickets lottoTickets = new LottoTickets(1000,testLottoGenerator);
        List<WinningResult> winningResults = lottoTickets.calculateWinningResult(
            new LottoMachine(firstLottoNumbers, 8));
        Assertions.assertThat(winningResults.get(0).getMatchCount()).isEqualTo(2);
    }

    @Test
    void 로또_장당_보너스_개수_일치여부_테스트() {
        TestLottoGenerator testLottoGenerator = new TestLottoGenerator();
        LottoTickets lottoTickets = new LottoTickets(1000,testLottoGenerator);
        testLottoGenerator.getLottoGeneratorNumbers();
        List<WinningResult> winningResults = lottoTickets.calculateWinningResult(
            new LottoMachine(secondLottoNumbers, 6));
         Assertions.assertThat(winningResults.get(0).getHasBonus()).isEqualTo(1);
    }

}
