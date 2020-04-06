package lotto.controller;

import lotto.domain.Money;
import lotto.domain.lotto.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.MatchedLottoDto;
import lotto.view.ResultView;
import lotto.view.StatisticsLottoDto;
import util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        String inputMoney = InputView.receiveBuyAmount();
        Money money = lottoService.createMoney(inputMoney);

        String inputBuyCount = InputView.receiveBuyPassivityCount();
        int buyCount = lottoService.validateAvailableQuantity(inputBuyCount, money);
        List<String> buyPassivityCount = InputView.receiveBuyPassivityLottoNumber(buyCount);

        int availableBuyCount = lottoService.getAvailableBuyCount(money);
        ResultView.printLottoBuyCount(buyCount, (availableBuyCount - buyCount));

        MatchedLottoDto passivityDto = lottoService.playManuallyLotto(buyPassivityCount);
        MatchedLottoDto autoDto = lottoService.playMatchedLotto(availableBuyCount - buyCount);
        ResultView.printLoots(passivityDto);
        ResultView.printLoots(autoDto);

        String winNumberInput = InputView.receiveWinNumber();
        List<Integer> winNumber = StringUtil.splitStringToIntegers(winNumberInput);
        Collections.sort(winNumber);

        int bonus = StringUtil.parseStringToInt(InputView.receiveBonusWinNumber());
        WinLottoTicket winLottoTicket = new WinLottoTicket(
                LottoNumbers.of(winNumber), new LottoNumber(bonus));

        List<LottoTicket> ticketTmp = new ArrayList<>();
        ticketTmp.addAll(passivityDto.getTickets().getTickets());
        ticketTmp.addAll(autoDto.getTickets().getTickets());
        LottoTickets tickets = new LottoTickets(ticketTmp);

        StatisticsLottoDto winGame = lottoService.findWinGame(tickets, winLottoTicket);
        ResultView.printResult(winGame);

        StatisticsLottoDto earningRate = lottoService.getEarningRate(tickets, winLottoTicket);
        ResultView.printEarningResult(earningRate);
    }
}
