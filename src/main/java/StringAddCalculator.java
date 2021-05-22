import domain.Digits;
import utils.SplitStrategy;

public class StringAddCalculator {
    public static int splitAndSum(String text, SplitStrategy splitStrategy) {
        if(text == null || text.isEmpty()){
            return 0;
        }
        String[] tokens = splitStrategy.split(text);
        Digits digits = new Digits(tokens);
        return digits.sum();
    }
}
