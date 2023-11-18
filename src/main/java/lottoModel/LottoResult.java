package lottoModel;

public class LottoResult {

    private final int tree;
    private final int four;
    private final int five;
    private final int six;
    private final double rateOfReturn;

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

}
