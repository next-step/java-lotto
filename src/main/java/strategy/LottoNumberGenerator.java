package strategy;

import domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {
    List<LottoNumber> generator();
}
