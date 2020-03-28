package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(String lottoString) {
        this(toList(generateManulalLottoSets(lottoString)));
    }

    private Lotto(List<LottoNumber> lottos) {
        validateSize(lottos);
        this.lottoNumbers = Collections.unmodifiableList(lottos);
    }

    private static Set<LottoNumber> generateManulalLottoSets(String lottoString) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        String[] lottoStrings = lottoString.split(",");

        for (String lottoNumber : lottoStrings) {
            lottoNumberSet.add(LottoNumber.valueOf(Integer.parseInt(lottoNumber.trim())));
        }
        return lottoNumberSet;
    }

    private static List<LottoNumber> toList(Set<LottoNumber> lottoNumbers) {
        return new ArrayList<>(lottoNumbers).stream()
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .collect(Collectors.toList());
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> deduplicationLottoNumbers = new HashSet<>(lottoNumbers);
        if (deduplicationLottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개를 선택 해야합니다.", LOTTO_SIZE));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
