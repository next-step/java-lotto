package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUM_SIZE = 6;
    private final List<LottoNum> lottoNums;

    public Lotto(List<LottoNum> lottoNums) {
        validate(lottoNums);
        this.lottoNums = lottoNums;
        Collections.sort(this.lottoNums);
    }

    public static Lotto of(List<Integer> nums) {
        return new Lotto(nums.stream().map(LottoNum::new).collect(Collectors.toList()));
    }

    public List<LottoNum> getLottoNums() {
        return Collections.unmodifiableList(lottoNums);
    }

    public int getMatchCount(Lotto winningLotto) {
        return (int) lottoNums.stream().filter(winningLotto::match).count();
    }

    public boolean match(LottoNum lottoNum) {
        return lottoNums.contains(lottoNum);
    }

    private void validate(List<LottoNum> lottoNums) {
        if (lottoNums.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("Lotto 숫자의 사이즈는 6개 입니다.");
        }

        if (new HashSet<>(lottoNums).size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("Lotto 숫자에 중복되는 사이즈가 있습니다.");
        }
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNums=" + lottoNums +
                '}';
    }
}
