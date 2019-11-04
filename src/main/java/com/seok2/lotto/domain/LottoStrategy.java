package com.seok2.lotto.domain;

import java.util.List;

public interface LottoStrategy {

    List<LottoNumber> generate();
}
