package com.lotto.controller;

import com.lotto.game.Game;
import com.lotto.model.LottoResult;
import com.lotto.model.Lottos;
import com.lotto.model.WinningNumbers;
import com.lotto.util.InputParser;
import com.lotto.view.LottoDrawer;

import java.util.List;
import java.util.Scanner;

public class LottoController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LottoDrawer.drawMoneyInputMessage();
        int money = InputParser.convert(scanner.nextLine());

        if (money < Game.LOTTO_PRICE) {
            LottoDrawer.drawWhenUnderMiminumMoney();
            return;
        }

        Lottos lottos = Game.purchase(money);
        LottoDrawer.drawBuyResult(lottos);

        LottoDrawer.drawWinningNumbers();
        List<Integer> numbers = InputParser.parseNumbers(scanner.nextLine());
        WinningNumbers winningNumbers = Game.makeWinningNumbers(numbers);

        LottoResult result = Game.check(winningNumbers, lottos);
        float benefit = Game.calculateBenefit(money, result);
        LottoDrawer.drawResult(result, benefit);
    }
}
