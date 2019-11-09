package lotto.domain;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 23:36
 */
public interface LottoNumberStrategy {
    public List<Integer> generate();
}
