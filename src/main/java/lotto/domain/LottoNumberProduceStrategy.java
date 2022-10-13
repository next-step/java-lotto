package lotto.domain;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public interface LottoNumberProduceStrategy {

    int MAX_LOTTO_NUMBER = 45;

    Integer produce();
}
