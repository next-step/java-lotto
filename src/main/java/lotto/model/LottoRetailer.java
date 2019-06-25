package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoRetailer {

    public static Lottos buyAutoPick(Order order) {

        List<PickNumbers> buyPickNumbers = new ArrayList<>();
        for (int i = 0; i < order.getAvailableNumberToBuy(); i++) {
            buyPickNumbers.add(new PickNumbers(NumbersGenerator.autoGenerate()));
        }
        return new Lottos(buyPickNumbers);
    }
}
