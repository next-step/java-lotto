package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class ManualStrategy implements GeneratorStrategy {
    private static final String REGEX = ",";

    private final String input;

    public ManualStrategy(String input) {
        this.input = input;
    }

    @Override
    public Lotto generate() {
        Set<LottoNo> lottoNos = new HashSet<>();
        String[] split = input.split(REGEX);

        for (String number : split) {
            lottoNos.add(new LottoNo(Integer.parseInt(number.trim())));
        }

        return new Lotto(new HashSet<>(lottoNos));
    }

}
