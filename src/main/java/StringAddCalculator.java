import static utils.StringUtils.isNullOrBlank;

public class StringAddCalculator {

    public static final int SUM_OF_NULL_OR_EMPTY = 0;

    public static int splitAndSum(String value) {
        if (isNullOrBlank(value)) {
            return SUM_OF_NULL_OR_EMPTY;
        }
        return 0;
    }
}
