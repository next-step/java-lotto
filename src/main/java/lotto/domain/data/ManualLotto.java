package lotto.domain.data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLotto {

    private final List<LottoNumber> lottoNumbers;

    private ManualLotto(List<Integer> numbers) {
        lottoNumbers = Collections.unmodifiableList(numbers == null ? List.of() : LottoNumberPool.get(numbers));
    }

    public static ManualLotto of(List<Integer> numbers) {
        return new ManualLotto(numbers);
    }

    public static List<ManualLotto> list(List<List<Integer>> numbers) {
        return numbers.stream().map(ManualLotto::new).collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public boolean isEmpty() {
        return lottoNumbers.isEmpty();
    }
}
