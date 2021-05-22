import domain.Digits;
import utils.SplitUtil;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()){
            return 0;
        }
        String[] tokens = SplitUtil.split(text);
        Digits digits = new Digits(tokens);
        return digits.sum();
    }
}
