package lottogame.service;

import lottogame.domain.LottoNumber;
import lottogame.domain.LottoNumberPackage;

import java.util.List;

public interface LottoNumberGenerator {
    LottoNumberPackage generate();
    List<LottoNumberPackage> generate(long count);
}