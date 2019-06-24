package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRetailer {

    public static List<LottoNumbers> buyAutoPick(Order order) {

        List<LottoNumbers> list = new ArrayList<>();
        for (int i = 0; i < order.getAvailableNumberToBuy(); i++) {
            list.add(new LottoNumbers(NumberGenerator.autoGenerate()));
        }
        return list;
    }
}
