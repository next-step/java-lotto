package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto implements Iterable<LottoNumber> {
    private static final int LOTTO_NUM_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 총" + LOTTO_NUM_COUNT + "개 이어야 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(List<LottoNumber> nums) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>(nums);

        return new Lotto(lottoNumbers);
    }

    public static Lotto create(String nums) {
        if (Objects.isNull(nums) || nums.trim().equals("")) {
            throw new IllegalArgumentException("로또 번호가 null이거나 빈 문자열일 경우 로또를 생성할 수 없습니다.");
        }

        Set<LottoNumber> lottoNumbers = Arrays.asList(nums.split(",")).stream()
                .map(value -> Integer.parseInt(value.trim()))
                .map(value -> LottoNumber.valueOf(value))
                .collect(Collectors.toCollection(TreeSet::new));

        return new Lotto(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map((lottoNumber) -> String.valueOf(lottoNumber.getLottoNumber()))
                .collect(Collectors.joining(","));
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
