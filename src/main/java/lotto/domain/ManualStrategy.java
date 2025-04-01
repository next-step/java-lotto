package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class ManualStrategy implements GeneratorStrategy {
    private static final int LOTTO_NUMBER_LENGTH = 6;
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

        checkValid(lottoNos, split);
        return new Lotto(new HashSet<>(lottoNos));
    }

    private void checkValid(Set<LottoNo> lottoNos, String[] split) {
        if (lottoNos.size() != split.length) {
            throw new IllegalArgumentException("duplicate number is not allowed");
        }

        if (lottoNos.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("lotto size is not 6");
        }
    }
}
