package step2.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeGenerator implements LottoNumberGenerator{

    private List<LottoNumberGenerator> generators;

    public MergeGenerator(LottoNumberGenerator... generators) {
        this.generators = Arrays.asList(generators);
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> lottoList = new ArrayList<>();
        for (LottoNumberGenerator generator : generators) {
            lottoList.addAll(generator.generate());
        }
        return lottoList;
    }
}
