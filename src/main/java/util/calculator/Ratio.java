package util.calculator;

public class Ratio {
    private Ratio() {
    }

    /**
     * base를 기준으로 target이 상대적으로 몇 배인지를 계산합니다.
     *
     * @param target
     * @param base
     *
     * @return target / base
     */
    public static double ratio(int target, int base) {
        return (double) target / (double) base;
    }
}
