package step4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoStore {
    private static final long lottoPrice = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoStore(){

    }

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottoGenerate(Price price) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < price.lottoCount(); i++ ) {
            lottos.add(generate());
        }

        return lottos;
    }

    public List<Lotto> lottoGenerate(Price price, int passiveCount, List<String> passiveLotto) {
        for (int i = 0; i < price.lottoCount() - passiveCount; i++) {
            lottos.add(generate());
        }

        for (String text : passiveLotto) {
            lottos.add(comma(text));
        }

        return lottos;
    }

    public Lotto comma(String value) {

        String[] values = value.split(",");
        return new Lotto(
                Arrays.stream(values)
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
    }

    public Lotto generate() {
        List<Integer> numberList = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numberList);
        return Lotto.of(numberList.subList(0,6));
    }


}