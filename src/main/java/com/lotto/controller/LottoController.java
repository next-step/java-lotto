package com.lotto.controller;

import com.lotto.game.Game;
import com.lotto.model.*;
import com.lotto.util.InputParser;
import com.lotto.view.LottoDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LottoDrawer.drawMoneyInputMessage();
        LottoMoney lottoMoney = new LottoMoney(InputParser.convert(scanner.nextLine()));

        LottoDrawer.drawManualLottoCount();
        int manualCount = InputParser.convert(scanner.nextLine());
        LottoTicketInfo lottoTicketInfo = new LottoTicketInfo(lottoMoney.getMoney(), manualCount);


        Lottos lottos = proceedLottoPurchasePhase(scanner, lottoTicketInfo);
        LottoDrawer.drawBuyResult(manualCount, lottos);
        WinningNumbers winningNumbers = proceedMakeWiningNumberPhase(scanner);
        proceedResultPhase(lottoMoney.getMoney(), winningNumbers, lottos);
    }

    private static void proceedResultPhase(int money, WinningNumbers winningNumbers, Lottos lottos) {
        LottoResult result = Game.check(winningNumbers, lottos);
        float benefit = result.calculateBenefit(money);
        LottoDrawer.drawResult(result, benefit);
    }

    private static WinningNumbers proceedMakeWiningNumberPhase(Scanner scanner) {
        LottoDrawer.drawWinningNumbers();
        List<Integer> numbers = InputParser.parseNumbers(scanner.nextLine());

        LottoDrawer.drawBonusNumber();
        int bonusNumber = InputParser.convert(scanner.nextLine());
        return Game.makeWinningNumbers(numbers, bonusNumber);
    }

    private static Lottos proceedLottoPurchasePhase(Scanner scanner, LottoTicketInfo lottoTicketInfo) {
        LottoDrawer.drawManualLottoNumberInput();
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(proceedManualPhase(scanner, lottoTicketInfo.getManualCount()));
        lottoList.addAll(proceedAutoPhase(lottoTicketInfo.getAutoCount()));
        return new Lottos(lottoList);
    }

    private static List<Lotto> proceedManualPhase(Scanner scanner, int manualCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < manualCount; index++) {
            List<Integer> manualNumbers = InputParser.parseNumbers(scanner.nextLine());
            lottoList.add(Game.purchaseManual(manualNumbers));
        }

        return lottoList;
    }

    private static List<Lotto> proceedAutoPhase(int autoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < autoCount; index++) {
            lottoList.add(Game.purchaseAuto());
        }

        return lottoList;
    }
}
