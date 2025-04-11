package domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNo> numbers;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public LottoTicket() {
        this.numbers = generateRandomNumbers();
    }

    public LottoTicket(List<LottoNo> lottoNumbers) {
        this(lottoNumbers, true);
    }

    public LottoTicket(List<LottoNo> lottoNumbers, boolean validate) {
        if (validate) {
            validateLottoNos(lottoNumbers);
        }
        this.numbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }

        boolean allInRange = numbers.stream().allMatch(n -> n >= LOTTO_START_NUMBER && n <= LOTTO_END_NUMBER);
        if (!allInRange) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateLottoNos(List<LottoNo> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        long uniqueCount = lottoNumbers.stream().distinct().count();
        if (uniqueCount != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private List<LottoNo> generateRandomNumbers() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
        Collections.shuffle(allNumbers);
        return allNumbers.subList(0, 6).stream()
                .map(LottoNo::new)
                .sorted()
                .collect(Collectors.toList());
    }

    public int countMatchingNumbersWith(LottoTicket winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket::contains)
                .count();
    }

    public boolean contains(LottoNo number) {
        return numbers.contains(number);
    }

    public List<LottoNo> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

