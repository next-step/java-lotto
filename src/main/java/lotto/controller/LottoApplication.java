package lotto.controller;

import lotto.domain.Money;
import lotto.domain.item.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.LottoDto;
import lotto.view.ResultView;
import util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        String inputMoney = InputView.inputBuyAmount();
        Money money = new Money(StringUtil.parseStringToInt(inputMoney));

        int buyCount = StringUtil.parseStringToInt(InputView.inputBuyPassivityCount());
        List<String> buyPassivityCount = InputView.inputBuyPassivityLottoNumber(buyCount);

        LottoService lottoService = new LottoService();
        int availableBuyCount = lottoService.getAvailableBuyCount(money.minus(10));

        ResultView.printLottoBuyCount(buyCount, (availableBuyCount - buyCount));

        LottoDto passivityDto = lottoService.passivityPlay(buyPassivityCount);
        LottoDto autoDto = lottoService.autoPlay(availableBuyCount - buyCount);
        ResultView.printLoots(passivityDto);
        ResultView.printLoots(autoDto);

        String winNumberInput = InputView.inputWinNumber();
        List<Integer> winNumber = StringUtil.splitStringToIntegers(winNumberInput);
        Collections.sort(winNumber);

        int bonus = StringUtil.parseStringToInt(InputView.inputBonusLuckyNumber());
        WinLottoTicket winLottoTicket = new WinLottoTicket(
                LottoNumbers.createLottoNumbersUseInteger(winNumber), new LottoNumber(bonus));

        LottoGame lottoGame = new LottoGame(money);
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.addAll(passivityDto.getTickets().getTickets());
        tickets.addAll(autoDto.getTickets().getTickets());

        LottoTickets tickets1 = new LottoTickets(tickets);

        LottoDto winGame = lottoGame.findWinGame(tickets1, winLottoTicket);
        ResultView.printResult(winGame);

        LottoDto earningRate = lottoGame.getEarningRate(tickets1, winLottoTicket);
        ResultView.printEarningResult(earningRate);
    }
}
