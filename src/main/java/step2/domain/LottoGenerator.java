package step2.domain;

import step2.dto.LottoDTO;
import step2.dto.LottoDTO.NormalLottoDTO;
import step2.dto.LottoDTO.WinningLottoDTO;
import step2.dto.LottoListDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;
    private static final int COUNT_INCLUDING_BONUS_NUMBER = 7;

    public LottoListDTO generateLottoList(int amount) {
        List<NormalLottoDTO> lottoList = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            lottoList.add(generateLotto());
        }
        return new LottoListDTO(lottoList);
    }

    public NormalLottoDTO generateLotto() {
        return issueLotto(LottoNumberGenerator.issueNumbers(UPPER_BOUND, COUNT));
    }

    public WinningLottoDTO generateLotto(String values, int rawBonusNumber) {
        List<Integer> numbers = Arrays.stream(values.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        return issueLotto(numbers, rawBonusNumber);
    }

    private NormalLottoDTO issueLotto(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
        if (!areNumbersValid(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!areNumbersUnique(numbers)) {
            throw new IllegalArgumentException();
        }
        return new NormalLottoDTO(numbers);
    }

    private WinningLottoDTO issueLotto(List<Integer> numbers, int rawBonusNumber) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
        if (!areNumbersValid(numbers)) {
            throw new IllegalArgumentException();
        }
        if(!isRawNumberValid(numbers, rawBonusNumber)){
            throw new IllegalArgumentException();
        }
        return new WinningLottoDTO(numbers, rawBonusNumber);
    }

    private boolean isRawNumberValid(List<Integer> numbers, int rawBonusNumber) {
        return areNumbersInBoundary(numbers, rawBonusNumber) && areNumbersUnique(numbers, rawBonusNumber);
    }

    private boolean areNumbersValid(List<Integer> numbers) {
        return areNumbersInBoundary(numbers) && areNumbersUnique(numbers);
    }

    private boolean areNumbersInBoundary(List<Integer> numbers){
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        return validFlag;
    }

    private boolean areNumbersInBoundary(List<Integer> numbers, int rawBonusNumber){
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        if(rawBonusNumber<1 || rawBonusNumber>UPPER_BOUND){
            validFlag = false;
        }
        return validFlag;
    }

    private boolean areNumbersUnique(List<Integer> numbers) {
        return new HashSet<Integer>(numbers).size()==COUNT;
    }

    private boolean areNumbersUnique(List<Integer> numbers, int rawBonusNumber) {
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        hashSet.add(rawBonusNumber);
        return hashSet.size() == COUNT_INCLUDING_BONUS_NUMBER;
    }

}
