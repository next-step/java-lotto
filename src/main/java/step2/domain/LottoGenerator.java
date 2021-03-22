package step2.domain;

import step2.dto.LottoDTO;
import step2.dto.LottoListDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;

    public LottoListDTO generateLottoList(int amount) {
        List<LottoDTO> lottoList = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            lottoList.add(generateLotto());
        }
        return new LottoListDTO(lottoList);
    }

    public LottoDTO generateLotto() {
        return issueLotto(LottoNumberGenerator.issueNumbers(UPPER_BOUND, COUNT));
    }

    public LottoDTO generateLotto(String values) {
        List<Integer> numbers = Arrays.stream(values.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        return issueLotto(numbers);
    }

    private LottoDTO issueLotto(List<Integer> numbers) {
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
