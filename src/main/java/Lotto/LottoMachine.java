package Lotto;

import View.InputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Lotto.Money.MONEY_DIVIDE_REMAINDER_ZERO;

public class LottoMachine {

    private NumberGenerator numberGenerator;


    public LottoMachine(NumberGenerator numberGenerator) {

        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLotto(Money money) {
        return IntStream.range(MONEY_DIVIDE_REMAINDER_ZERO, money.getUnit())
                .mapToObj(lotto -> Lotto.of(LotterNumbers.of(numberGenerator.generate())))
                .collect(Collectors.toList());
    }

    public List<Lotto> createPassiveLotto(int passiveNumber) {

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(MONEY_DIVIDE_REMAINDER_ZERO, passiveNumber)
                .mapToObj(lotto -> Lotto.of(LotterNumbers.of(WinningNumber.of(InputView.insertPassiveNumber()).getWinningNumbers())))
                .collect(Collectors.toList());
    }

    public static List<Lotto> combineLotto(List<Lotto> dynamicLotto, List<Lotto> passiveLotto) {

        return Collections.unmodifiableList(Stream.concat(dynamicLotto.stream(), passiveLotto.stream())
                .collect(Collectors.toList()));

    }

}




