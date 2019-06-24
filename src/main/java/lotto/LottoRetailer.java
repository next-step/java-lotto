package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoRetailer {

    public static List<LottoNumbers> buyAutoPick(int quantity) {

        List<LottoNumbers> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
            list.add(lottoNumbers);
        }
        return list;
    }
}
