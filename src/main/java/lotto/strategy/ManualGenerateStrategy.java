package lotto.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.strategy.LottoNumberGenerateStrategy;
import lotto.util.InputUtil;

import java.util.Scanner;
import java.util.Set;

public class ManualGenerateStrategy implements LottoNumberGenerateStrategy {

    private static final Scanner SCANNER = new Scanner(System.in);
    @Override
    public Set<LottoNumber> generateLottoNumbers() {
        return InputUtil.readLottoNumbers(SCANNER.nextLine());
    }
}
