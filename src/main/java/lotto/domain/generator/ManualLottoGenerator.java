package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private final String lotto;

    public ManualLottoGenerator(String lotto) {
        this.lotto = lotto;
    }

    @Override
    public Lotto generate() {
        return toLotto(lotto);
    }

    public static LottoBundle generateLottoBundle(List<String> lottos) {
        List<Lotto> manualLottos = lottos.stream()
                .map(ManualLottoGenerator::new)
                .map(ManualLottoGenerator::generate)
                .collect(Collectors.toList());

        return new LottoBundle(manualLottos);
    }

    private Lotto toLotto(String lottoNumbers) {
        return new Lotto(parseLottoNumbers(lottoNumbers));
    }

    private List<LottoNumber> parseLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(this::toLottoNumber)
                .collect(Collectors.toList());
    }

    private LottoNumber toLottoNumber(String number) {
        return LottoNumber.getInstance(parseInt(number));
    }

    private int parseInt(String source) {
        return Integer.parseInt(source.trim());
    }
}
