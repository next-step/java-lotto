package step2.Domain;

import java.util.ArrayList;
import java.util.List;

public class MergeGenerator {

    private List<LottoNumberGenerator> generators;

    public MergeGenerator(List<LottoNumberGenerator> generators) {
        this.generators = generators;
    }

    public List<Lotto> generate() {
        List<Lotto> lottoList = new ArrayList<>();
        for (LottoNumberGenerator generator : generators) {
            lottoList.addAll(generator.generate());
        }
        return lottoList;
    }
}
