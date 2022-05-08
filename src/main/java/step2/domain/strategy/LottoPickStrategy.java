package step2.domain.strategy;

import step2.domain.LottoNumber;

import java.util.List;

public interface LottoPickStrategy {
    List<LottoNumber> numberPick();
}
