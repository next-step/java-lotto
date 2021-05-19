package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoVendingMachine {

    private static final LottoVendingMachine instance = new LottoVendingMachine();

    private LottoVendingMachine() { }

    public static LottoVendingMachine getInstance() {
        return instance;
    }

    public List<Lotto> buyLottos(int money) {

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해주세요.");
        }

        int size = money / 1000;

        return Stream.generate(LottoCreator::create)
                     .limit(size)
                     .collect(toList());
    }
}
