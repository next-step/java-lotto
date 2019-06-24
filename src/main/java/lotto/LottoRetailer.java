package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRetailer {

    public static List<LottoNumbers> buyAutoPick(int quantity) {

        List<LottoNumbers> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            list.add(new LottoNumbers(NumberGenerator.autoGenerate()));
        }
        return list;
    }
}
