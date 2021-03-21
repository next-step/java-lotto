package step2.domain;

import step2.dto.LottoDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;

    public List<LottoDTO> issueLottoList(int amount) {
        List<LottoDTO> lottoList = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }

    public LottoDTO generateLotto() {
        return new LottoDTO(LottoNumberGenerator.issueNumbers(UPPER_BOUND, COUNT));
    }

    public LottoDTO gerarateLotto(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
        if (!areNumbersValid(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!areNumbersUnique(numbers)) {
            throw new IllegalArgumentException();
        }
        return new LottoDTO(numbers);
    }

    public LottoDTO generateLotto(String values) {
        return new LottoDTO(Arrays.stream(values.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()));
    }

    private boolean areNumbersUnique(List<Integer> numbers) {
        return new HashSet<Integer>(numbers).size() == COUNT;
    }

    private boolean areNumbersValid(List<Integer> numbers) {
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        return validFlag;
    }

}
