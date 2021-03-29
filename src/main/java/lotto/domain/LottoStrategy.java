/*
 * 로또 생성 전략을 나타내는 함수형 인터페이스
 * */
package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoStrategy {
    int LOTTO_SIZE = 6;

    List<LottoNumber> makeLotto(List<LottoNumber> lottoNumbers);
}
