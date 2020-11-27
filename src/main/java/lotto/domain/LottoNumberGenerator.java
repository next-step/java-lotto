package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

public interface LottoNumberGenerator {

    /**
     * LottoNumber 를 생성합니다
     *
     * @return
     */
    LottoNumbers generate();

    static LottoNumberGenerator simple() {

        return new LottoNumberGenerator() {

            private ArrayList<Integer> lottoNumberBalls;

            {
                lottoNumberBalls = new ArrayList<>();
                IntStream.rangeClosed(1, 45).forEach(lottoNumberBalls::add);
            }

            private Random random = new Random();

            @Override
            public LottoNumbers generate() {
                Collections.shuffle(lottoNumberBalls, random);
                return new LottoNumbers(Arrays.asList(
                        new LottoNumber(lottoNumberBalls.get(0)),
                        new LottoNumber(lottoNumberBalls.get(1)),
                        new LottoNumber(lottoNumberBalls.get(2)),
                        new LottoNumber(lottoNumberBalls.get(3)),
                        new LottoNumber(lottoNumberBalls.get(4)),
                        new LottoNumber(lottoNumberBalls.get(5))
                ));
            }
        };
    }
}
