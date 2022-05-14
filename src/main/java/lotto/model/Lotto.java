package lotto.model;

import lotto.dto.ExtractLottoNumbers;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Lotto {
    private static final int ZERO = 0;
    private static final int LOTTO_COUNT = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(String lottoNumbers) {
        this(ExtractLottoNumbers.split(lottoNumbers));
    }

    public Lotto(Set<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = new HashSet<>(lotto);
    }

    private void validate(Set<LottoNumber> lotto) {
        Objects.requireNonNull(lotto, "lotto는 null일 수 없습니다.");
        if (lotto.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("lotto 의 사이즈는 6이어야 합니다. 입력 사이즈: " + lotto.size());
        }
    }

    public Set<LottoNumber> get() {
        return Collections.unmodifiableSet(lotto);
    }

    public int countMatchNumber(Lotto result) {
        Objects.requireNonNull(result, "matchCount를 계산하기 위한 Lotto는 null일 수 없습니다.");

        Set<LottoNumber> resultLotto = result.get();
        Set<LottoNumber> originLotto = new HashSet<>(lotto);

        originLotto.retainAll(resultLotto);
        return originLotto.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public static List<Lotto> listOfCountAndGenerator(long count, LottoGenerator lottoGenerator) {
        validate(count, lottoGenerator);
        return Stream.generate(() -> new Lotto(lottoGenerator.get()))
                .limit(count)
                .collect(Collectors.toList());
    }

    private static void validate(long count, LottoGenerator lottoGenerator) {
        Objects.requireNonNull(lottoGenerator, "로또 생성을 위한 generator는 null일 수 없습니다.");
        if (isNegative(count)) {
            throw new IllegalArgumentException("Generator 로 생성할 로또의 개수는 음수일 수 없습니다. count:" + count);
        }
    }

    private static boolean isNegative(long number) {
        return number < ZERO;
    }
}
