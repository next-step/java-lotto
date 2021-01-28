package lotto;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public int matchPriceAndPayment(int input) {
        return input / 1000;
    }

    public void winningNumberEqual() {

    }

    public void bonusEqual() {

    }

    public void checkEqualWinningNumber() {

    }

    public void winningStatisticalCheck() {

    }

    public void winningRevenueCheck() {

    }

    public List<List<Integer>> buyLotto(int input) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<List<Integer>> lottos = new ArrayList<>();
        int lottoCnt = matchPriceAndPayment(input);
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }

        return lottos;
    }

    public List<Integer> getAnswer(String input) {
        List<Integer> answerLotto = new ArrayList<>();

        String[] inputs = input.split(", ");
        for (String s : inputs) {
            Integer num = Integer.parseInt(s);
            answerLotto.add(num);
        }

        return answerLotto;
    }

    public Integer getBouns(String input) {
        return Integer.parseInt(input);
    }
}
