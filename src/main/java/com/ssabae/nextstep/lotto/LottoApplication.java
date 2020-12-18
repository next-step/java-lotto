package com.ssabae.nextstep.lotto;

import com.ssabae.nextstep.lotto.application.LottoResultDto;
import com.ssabae.nextstep.lotto.domain.LottoTicketsAnalyzer;
import com.ssabae.nextstep.lotto.domain.Money;
import com.ssabae.nextstep.lotto.domain.WinningNumber;
import com.ssabae.nextstep.lotto.domain.lotto.AutoLottoTicketGenerator;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicketGenerator;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTicketMachine;
import com.ssabae.nextstep.lotto.domain.lotto.LottoTickets;
import com.ssabae.nextstep.lotto.view.InputView;
import com.ssabae.nextstep.lotto.view.LottoPrinter;
import com.ssabae.nextstep.lotto.view.ResultView;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-17
 */
public class LottoApplication {

    private final LottoTicketMachine lottoTicketMachine;
    private final LottoTicketsAnalyzer analyzer;
    private final ResultView resultView;

    public LottoApplication() {
        LottoTicketGenerator generator = new AutoLottoTicketGenerator();
        this.lottoTicketMachine = new LottoTicketMachine(generator);
        this.analyzer = new LottoTicketsAnalyzer();
        this.resultView = new ResultView();
    }

    public void launch() {
        Money money = InputView.buyMoneyInput();
        LottoTickets lottoTickets = lottoTicketMachine.buy(money);

        LottoPrinter.print(lottoTickets);

        WinningNumber winningNumber = InputView.winningNumberInput();
        LottoResultDto lottoResultDto = analyzer.convertToDto(lottoTickets, winningNumber);

        resultView.report(lottoResultDto);
    }

    public static void main(String[] args) {
        new LottoApplication().launch();
    }
}
