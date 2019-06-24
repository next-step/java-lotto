package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoRetailer {

    public static List<PickNumbers> buyAutoPick(Order order) {

        List<PickNumbers> list = new ArrayList<>();
        for (int i = 0; i < order.getAvailableNumberToBuy(); i++) {
            list.add(new PickNumbers(NumbersGenerator.autoGenerate()));
        }
        return list;
    }

    public static WinningNumbers anounceWinningNumbers() {
        return new WinningNumbers(NumbersGenerator.autoGenerate());
    }
}
