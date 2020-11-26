package domain;

import common.CommonConstants;
import exception.ExceptionFunction;
import exception.InvalidBonusNumberException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;
    private static final List<Integer> oneToFortyFive = IntStream.rangeClosed(LottoNumbers.LOTTO_NUMBERS_MIN, LottoNumbers.LOTTO_NUMBERS_MAX)
            .boxed()
            .collect(Collectors.toList());

    private Lottos(List<Lotto> lottos){
        Objects.requireNonNull(lottos);
        this.lottos = lottos;
    }

    public static Lottos of(int numberOfLottos) throws Exception {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            Collections.shuffle(oneToFortyFive);
            lottos.add(Lotto.of(oneToFortyFive.stream()
                    .limit(LottoNumbers.LOTTO_NUMBERS_SIZE)
                    .sorted()
                    .collect(Collectors.toList())));
        }

        return new Lottos(lottos);
    }

    public static Lottos of(List<String> stringLottos) {
        List<Lotto> lottos = stringLottos.stream()
                .map(s -> Arrays.stream(s.split(CommonConstants.SPLIT_DELIMITER_COMMA))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList()))
                .map(checkException(Lotto::of))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    private static <T, R> Function<T, R> checkException(ExceptionFunction<T, R> f) {
        return (T r) -> {
            try {
                return f.apply(r);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public LottoResult calculate(Lotto winningLotto, int bonusNumber) throws InvalidBonusNumberException {
        if(winningLotto.hasBonus(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }

        LottoResult lottoResult = new LottoResult();

        lottos.forEach(lotto -> lottoResult.addPrizeResult(lotto.checkWhetherToWin(winningLotto, bonusNumber)));

        return lottoResult;
    }

    public Stream stream(){
        return lottos.stream();
    }

    public int size() {
        return lottos.size();
    }

    public Lottos addAll(Lottos l) {
        List<Lotto> addedLottos = new ArrayList<>();

        addedLottos.addAll(this.lottos);
        addedLottos.addAll(l.lottos);

        return new Lottos(addedLottos);
    }
}
