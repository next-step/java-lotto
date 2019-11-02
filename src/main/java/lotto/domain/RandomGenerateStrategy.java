package lotto.domain;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 21:53
 */
public interface RandomGenerateStrategy {
    public List<Integer> randomNumbers();
}
