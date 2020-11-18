package lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public interface LottoNumberGenerator {

    /**
     * LottoNumber 를 생성합니다
     * @return
     */
    LottoNumber generate();

    static LottoNumberGenerator simple(){

        return new LottoNumberGenerator() {

            private ArrayList<Integer> lottoNumberBalls;
            {
                lottoNumberBalls = new ArrayList<>();
                IntStream.rangeClosed(1, 45).forEach( lottoNumberBalls::add );
            }
            private Random random = new Random();

            @Override
            public LottoNumber generate() {
                Collections.shuffle(lottoNumberBalls, random);
                return new LottoNumber(Arrays.asList(
                        lottoNumberBalls.get(0),
                        lottoNumberBalls.get(1),
                        lottoNumberBalls.get(2),
                        lottoNumberBalls.get(3),
                        lottoNumberBalls.get(4),
                        lottoNumberBalls.get(5)
                ));
            }
        };
    }
}
