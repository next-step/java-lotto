package lotto;
import java.util.*;

public class LottoFactory {

    public static final int LOTTO_SIZE = 6;

    public static List<Integer> create(){
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            result.add(random.nextInt(45));
        }
        return result;
    }

}
