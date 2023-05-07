package lotto.domain.purchase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class PurchaseManual implements PurchaseStrategy {

    private static final PurchaseManual INSTANCE = new PurchaseManual();

    private PurchaseManual() {}

    public static PurchaseManual instance() {
        return INSTANCE;
    }

    @Override
    public Lotto purchase() {
        String[] inputs = new Scanner(System.in).nextLine().split(",");
        List<LottoNumber> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(new LottoNumber(Integer.parseInt(input.trim())));
        }
        Collections.sort(numbers, LottoNumber::compare);
        return new Lotto(numbers);
    }

}
