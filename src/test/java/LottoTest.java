import lotto.Lotto;

import lotto.LottoTicket;
import lotto.LottoType;
import lotto.ManyTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import view.LottoOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }


    @Test
        // 자동  구입 로또 리스트
    void purChaseTest() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoOutput lottoOutput = new LottoOutput();
        ManyTickets manyTickets = lotto.purChase(lottoTickets, 5);
        lottoOutput.printTickets(manyTickets);
    }

    @Test
        // 당첨 통계 결과 map으로 추출
    void winningStatisticsTest() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoOutput lottoOutput = new LottoOutput();
        ManyTickets manyTickets = lotto.purChase(lottoTickets, 5);

        List<Integer> winningNumbers = new ArrayList<>(); // 당첨번호
        winningNumbers.add(10);
        winningNumbers.add(15);
        winningNumbers.add(20);
        winningNumbers.add(25);
        winningNumbers.add(30);
        winningNumbers.add(35);
        Map<LottoType, Long> results = lotto.winningStatistics(manyTickets, winningNumbers, 3);// 당첨 통계 메소드

        lottoOutput.printWinningList(results);
    }

    @Test
        // 수익률 구하는  메소드 테스트
    void rateResultTest() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoOutput lottoOutput = new LottoOutput();
        ManyTickets manyTickets = lotto.purChase(lottoTickets, 5);

        List<Integer> winningNumbers = new ArrayList<>(); // 당첨번호
        winningNumbers.add(10);
        winningNumbers.add(15);
        winningNumbers.add(20);
        winningNumbers.add(25);
        winningNumbers.add(30);
        winningNumbers.add(35);
        Map<LottoType, Long> results = lotto.winningStatistics(manyTickets, winningNumbers, 3);// 당첨 통계 메소드

        BigDecimal rate = lotto.rateResult(results, 1000);

        lottoOutput.printRate(rate);
    }

}