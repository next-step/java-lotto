package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    public LottoTickets generateRandomLottoTickets(int price, RandomLottoMachine randomLottoMachine) {
        return randomLottoMachine.generate(price);
    }

    public LottoTickets generateFixedLottoTickets(List<String> manualPurchaseLottoNumbers, FixedLottoMachine fixedLottoMachine) {
        return fixedLottoMachine.generate(manualPurchaseLottoNumbers);
    }

    public LottoTickets generateMixedLottoTickets(LottoTickets fixedLottoTickets, LottoTickets randomLottoTickets) {
        return fixedLottoTickets.union(randomLottoTickets);
    }

    public WinningNumber generateWinningNumber(String inputNumber, RandomLottoMachine randomLottoMachine) {
        return randomLottoMachine.winningNumber(inputNumber);
    }

    public LottoNumber generateBonusBall(int inputNumber, RandomLottoMachine randomLottoMachine, WinningNumber winningNumber) {
        return randomLottoMachine.CreateBonusBall(inputNumber, winningNumber);
    }

    public LottoResult result(LottoTickets lottoTickets, WinningNumber winningNumber, LottoNumber bonusBall) {
        return new LottoResult(lottoTickets.getLottoTickets(), winningNumber, bonusBall);
    }

    public int calculateRemainingMoney(int price, int manualPurchaseLottoCount) {
        return price - (manualPurchaseLottoCount * 1000);
    }
}
