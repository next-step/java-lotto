package lotto.dto;

import lotto.model.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final List<Rank> rankResult;

    public LottoResult(List<Rank> rankResult) {
        validate(rankResult);
        this.rankResult = new ArrayList<>(rankResult);
    }

    private void validate(List<Rank> rankResult) {
        Objects.requireNonNull(rankResult, "로또 결과 생성 입력값이 올바르지 않습니다. rankResult is null");
    }

    public List<Rank> getRankResult() {
        return Collections.unmodifiableList(rankResult);
    }
}
