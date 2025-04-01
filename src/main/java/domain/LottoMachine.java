package domain;

import utils.Parser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static Lottos generate(int count, LottoNumberGenerator generator, List<String> manualLottoList) {
        List<List<Integer>> manualLottoNumbers = manualLottoList.stream().map(Parser::fromNumberInput).collect(Collectors.toList());
        List<Lotto> lottos = manualLottoNumbers.stream().map(Lotto::new).collect(Collectors.toList());
        lottos.addAll(IntStream.range(0, count)
                .mapToObj(i -> LottoMachine.create(generator.generate()))
                .collect(Collectors.toList()));
        return new Lottos(lottos);
    }

    public static Lotto create(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }
}
