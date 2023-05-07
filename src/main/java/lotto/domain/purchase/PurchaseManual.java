package lotto.domain.purchase;

import java.util.ArrayList;
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
        return manualLotto(parsedNumbers(scanNumbers()));
    }

    private Lotto manualLotto(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private List<LottoNumber> parsedNumbers(String[] inputs) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(lottoNumber(parseInt(trim(input))));
        }
        return numbers;
    }

    private LottoNumber lottoNumber(int input) {
        return new LottoNumber(input);
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private String trim(String input) {
        return input.trim();
    }

    private String[] scanNumbers() {
        return new Scanner(System.in).nextLine().split(",");
    }

}
