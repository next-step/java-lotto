package lottogame.service;

import lottogame.domain.LottoNumber;
import lottogame.domain.LottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {

    private static final List<Integer> numberPool = IntStream.rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
                                                        .boxed()
                                                        .collect(Collectors.toList());

    @Override
    public LottoGame generate() {
        return new LottoGame(getLottoNumbers());
    }

    @Override
    public List<LottoGame> generate(long count) {
        List<LottoGame> lottoNumbers = new ArrayList<>();

        for(long i = 0; i < count; ++i) {
            lottoNumbers.add(generate());
        }

        return lottoNumbers;
    }

    List<Integer> getLottoNumbers() {
        Collections.shuffle(numberPool);

        return numberPool.stream()
                        .limit(LottoGame.LOTTO_GAME_SIZE)
                        .sorted()
                        .collect(Collectors.toList());
    }
}