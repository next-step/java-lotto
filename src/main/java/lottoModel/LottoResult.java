package lottoModel;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final int tree;
    private final int four;
    private final int five;
    private final int six;
    private final double rateOfReturn;
    public static final int TREE_MATCH = 3;
    public static final int FOUR_MATCH = 4;
    public static final int FIVE_MATCH = 5;
    public static final int SIX_MATCH = 6;
    public static final double RATE_OF_RETURN = 0.0;

    public LottoResult(int tree, int four, int five, int six, double rateOfReturn) {
        this.tree = tree;
        this.four = four;
        this.five = five;
        this.six = six;
        this.rateOfReturn = rateOfReturn;
    }

    public int getTree() {
        return tree;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getSix() {
        return six;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public static LottoResult result(int money, List<Lotto> lottos, List<Integer> lastLotto) {
        List<Integer> lottoMatchResults = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoMatchResults.add(lotto.matchCount(lastLotto));
        }

        int tree = getCount(lottoMatchResults, TREE_MATCH);
        int four = getCount(lottoMatchResults, FOUR_MATCH);
        int five = getCount(lottoMatchResults, FIVE_MATCH);
        int six = getCount(lottoMatchResults, SIX_MATCH);

        double rateOfReturn = rate(tree, four, five, six, money);
        LottoResult lottoResult = new LottoResult(tree, four, five, six, rateOfReturn);

        return lottoResult;
    }

    private static int getCount(List<Integer> lottoMatchResults, int matchNum) {
        return (int) lottoMatchResults.stream().filter(number -> number == matchNum).count();
    }

    private static double rate(int tree, int four, int five, int six, int money) {
        LottoOperator calc = new LottoOperator();
        double rate = RATE_OF_RETURN;

        rate += calc.calculate(tree, 5_000, LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(four, 50_000, LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(five, 1_500_000, LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(six, 2_000_000_000, LottoOperator.Operator.MULTIPLY);
        rate = calc.calculate(rate, money, LottoOperator.Operator.MINUS);
        rate = calc.calculate(rate, money, LottoOperator.Operator.DIVIDE);

        return rate;
    }
}
