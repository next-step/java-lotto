package domain;

import spark.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoGenerator implements LottoGenerator {
    private LottoMoney lottoMoney;
    private List<Integer[]> numberSets = new ArrayList<>();

    public DefaultLottoGenerator(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
    }

    public DefaultLottoGenerator(LottoMoney lottoMoney, List<Integer[]> numberSets) {
        this(lottoMoney);
        this.numberSets = numberSets;
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> result = new ArrayList<>();
        result.addAll(manualGenerate());
        result.addAll(autoGenerate());

        return result;
    }

    private List<Lotto> autoGenerate() {
        return IntStream.range(numberSets.size(), lottoMoney.getLottoCount())
            .mapToObj(i -> Lotto.create())
            .collect(Collectors.toList());
    }

    private List<Lotto> manualGenerate() {
        if(!CollectionUtils.isEmpty(numberSets)) {
            return numberSets.stream()
                .map(Lotto::create)
                .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
