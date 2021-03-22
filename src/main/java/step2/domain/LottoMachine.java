package step2.domain;

import step2.dto.LottoDTO.NormalLottoDTO;
import step2.dto.LottoDTO.WinningLottoDTO;
import step2.dto.LottoListDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int UPPER_BOUND = 45;
    private static final int COUNT = 6;
    private static final int COUNT_INCLUDING_BONUS_NUMBER = 7;

    public LottoListDTO lottoList(int amount) {
        List<NormalLottoDTO> lottoList = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            lottoList.add(lotto());
        }
        return new LottoListDTO(lottoList);
    }

    public NormalLottoDTO lotto() {
        return lottoBuilder(NumberMachine.number(UPPER_BOUND, COUNT));
    }

    public WinningLottoDTO lotto(String values, int rawBonusNumber) {
        List<Integer> numbers = Arrays.stream(values.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        return lottoBuilder(numbers, rawBonusNumber);
    }

    private NormalLottoDTO lottoBuilder(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
        if (!valid(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!unique(numbers)) {
            throw new IllegalArgumentException();
        }
        return new NormalLottoDTO(numbers);
    }

    private WinningLottoDTO lottoBuilder(List<Integer> numbers, int rawBonusNumber) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException();
        }
        if (!valid(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!valid(numbers, rawBonusNumber)) {
            throw new IllegalArgumentException();
        }
        return new WinningLottoDTO(numbers, rawBonusNumber);
    }

    private boolean valid(List<Integer> numbers, int rawBonusNumber) {
        return inBoundary(numbers, rawBonusNumber) && unique(numbers, rawBonusNumber);
    }

    private boolean valid(List<Integer> numbers) {
        return inBoundary(numbers) && unique(numbers);
    }

    private boolean inBoundary(List<Integer> numbers) {
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        return validFlag;
    }

    private boolean inBoundary(List<Integer> numbers, int rawBonusNumber) {
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        if (rawBonusNumber < 1 || rawBonusNumber > UPPER_BOUND) {
            validFlag = false;
        }
        return validFlag;
    }

    private boolean unique(List<Integer> numbers) {
        return new HashSet<Integer>(numbers).size() == COUNT;
    }

    private boolean unique(List<Integer> numbers, int rawBonusNumber) {
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        hashSet.add(rawBonusNumber);
        return hashSet.size() == COUNT_INCLUDING_BONUS_NUMBER;
    }

}
