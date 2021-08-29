package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class CustomLottoGenerator implements LottoGenerator {

    private final Lotto customLotto;

    public CustomLottoGenerator(String customLottoString) {

        String[] customLottosplit = customLottoString.split(",");
        Set<LottoNumber> lottoNumbers = new TreeSet<>();

        for (String customLotto : customLottosplit) {
            lottoNumbers.add(LottoNumber.of(Integer.parseInt(customLotto.trim())));
        }

        this.customLotto = new Lotto(lottoNumbers);
    }

    @Override
    public Lotto generateLotto() {
        return customLotto;
    }
}
