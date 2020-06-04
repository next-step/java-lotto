package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class LottoTicket {

    public static final int LOTTO_NUMBER_SIZE = 6;

    protected List<LottoNumber> numbers;

    protected LottoTicket(List<LottoNumber> numbers) {
        validate(numbers);

        this.numbers = new ArrayList<>(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        validateNullOrEmpty(numbers);
        validateSize(numbers);
    }

    private void validateNullOrEmpty(List<LottoNumber> numbers) {
        if (Objects.isNull(numbers) || numbers.isEmpty()) {
            throw new IllegalArgumentException("빈 공백 값은 로또 번호가 될 수 없습니다.");
        }
    }

    private void validateSize(List<LottoNumber> numbers) {
        int count = getDistinctLottoCount(numbers);

        if (count < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수는 중복 없이 6개 입니다. 6개 보다 적은 로또 번호가 입력되었습니다. - " + count);
        }

        if (count > LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수는 중복 없이 6개 입니다. 6개 보다 많은 로또 번호가 입력되었습니다. - " + count);
        }
    }

    private int getDistinctLottoCount(List<LottoNumber> numbers) {
        return (int) numbers.stream()
            .distinct()
            .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
