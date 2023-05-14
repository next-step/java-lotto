package step2;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_LIMIT = 45;

    static List<Integer> lottoNumber = new ArrayList<>();
    static{
        for (int i = 1; i<= LOTTO_LIMIT; i++){
            lottoNumber.add(i);
        }
    }
}
