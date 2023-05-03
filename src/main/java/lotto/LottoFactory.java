package lotto;
import java.util.*;

public class LottoFactory {

    public static final int LOTTO_SIZE = 6;

    public static List<LottoNumber> create(){
        List<LottoNumber> result = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            result.add(new LottoNumber());
        }
        return result;
    }

}
