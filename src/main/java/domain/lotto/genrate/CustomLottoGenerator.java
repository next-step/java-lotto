package domain.lotto.genrate;

import domain.lotto.Lotto;
import domain.lotto.LottoFactory;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static domain.lotto.properties.LottoProperties.MAX_LOTTO_NUMBER_RANGE;

public class CustomLottoGenerator implements LottoGenerator {
    int size;
    int count = 0;

    List<List<Integer>> customLottoNumbers;

    public static CustomLottoGenerator from(List<List<Integer>> customLotto) {
        verifyLottoSize(customLotto);
        return new CustomLottoGenerator(customLotto);
    }

    public int size() {
        return size;
    }

    private static void verifyLottoSize(List<List<Integer>> customLotto) {
        customLotto.stream()
                .filter(lotto -> lotto.size() != MAX_LOTTO_NUMBER_RANGE)
                .findAny()
                .ifPresent(item -> {
                    throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
                });
    }

    public CustomLottoGenerator(List<List<Integer>> customList) {
        this.customLottoNumbers = customList.stream()
                .collect(Collectors.toUnmodifiableList());

        this.size = this.customLottoNumbers.size();
    }

    @Override
    public List<Integer> create() {
        if (count >= size) {
            throw new IllegalArgumentException("로또 번호가 존재하지 않습니다.");
        }
        List<Integer> customLotto = customLottoNumbers.get(count);
        count++;
        return customLotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomLottoGenerator that = (CustomLottoGenerator) o;
        return Objects.equals(customLottoNumbers, that.customLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customLottoNumbers);
    }
}
