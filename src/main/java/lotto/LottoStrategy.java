/*
 * 로또 생성 전략을 나타내는 함수형 인터페이스
 * */
package lotto;

import java.util.List;

@FunctionalInterface
public interface LottoStrategy {
    int LOTTO_SIZE = 6;
    int LOTTO_BOUND = 45;
    int LOTTO_START_NUM = 1;

    List<Integer> makeLotto();
}
