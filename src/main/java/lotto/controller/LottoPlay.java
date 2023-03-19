package lotto.controller;

import lotto.service.BuyLotto;
import lotto.domain.EqualNumbers;
import lotto.domain.Lotto;
import lotto.domain.WinOfLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.*;

public class LottoPlay {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();
        BuyLotto buyLotto = lottoInput.getBuyAmt();

        for (int i = 0; i < buyLotto.getCount(); i++) {
            Set<Integer> generateNumbers = generateLottoNumbers();
            buyLotto.putLottos(new Lotto(generateNumbers));
        }

        lottoOutput.displayBuyLottoNumbers(buyLotto);

        WinOfLotto winOfLotto = lottoInput.getWinOfLottoNumbers();

        EqualNumbers equalNumbers = new EqualNumbers(buyLotto, winOfLotto);

        System.out.println(equalNumbers.getEqual3());

        lottoOutput.displayWinOfResult(equalNumbers);
        lottoOutput.displayPriceEarningsRatio(equalNumbers, buyLotto);
    }

    private static Set<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);

        return new HashSet<>(numbers);
    }
}
