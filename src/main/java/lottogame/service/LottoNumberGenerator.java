package lottogame.service;

import lottogame.domain.LottoGame;

import java.util.List;

public interface LottoNumberGenerator {
    LottoGame generate();
    List<LottoGame> generate(long count);
}