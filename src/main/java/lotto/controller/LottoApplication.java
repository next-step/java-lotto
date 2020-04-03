package lotto.controller;

import lotto.domain.Money;
import lotto.domain.item.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.MatchedLottoDto;
import lotto.view.ResultView;
import util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        String inputMoney = InputView.inputBuyAmount();
        Money money = lottoService.createMoney(inputMoney);

        String inputBuyCount = InputView.inputBuyPassivityCount();
        int buyCount = lottoService.validateAvailableQuantity(inputBuyCount, money);
        List<String> buyPassivityCount = InputView.inputBuyPassivityLottoNumber(buyCount);

        int availableBuyCount = lottoService.getAvailableBuyCount(money.minus(10));

        ResultView.printLottoBuyCount(buyCount, (availableBuyCount - buyCount));

        MatchedLottoDto passivityDto = lottoService.passivityPlay(buyPassivityCount);
        MatchedLottoDto autoDto = lottoService.autoPlay(availableBuyCount - buyCount);
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

        MatchedLottoDto winGame = lottoGame.findWinGame(tickets1, winLottoTicket);
        ResultView.printResult(winGame);

        MatchedLottoDto earningRate = lottoGame.getEarningRate(tickets1, winLottoTicket);
        ResultView.printEarningResult(earningRate);
    }
}
