package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final int DEFAULT_SIZE = 6;

    private List<Integer> winningLottoNumbers;

    private WinningLotto(int[] winningLottoNumbers) {
        List<Integer> convertedList = convertToList(winningLottoNumbers);

        validateSize(winningLottoNumbers);
        validateElements(convertedList);
        validateOverlap(convertedList);

        this.winningLottoNumbers = convertedList;
    }

    public static WinningLotto of(int[] winningLottoNumbers) {
        return new WinningLotto(winningLottoNumbers);
    }


    public boolean contains(Integer number) {
        return winningLottoNumbers.contains(number);
    }

    private List<Integer> convertToList(int[] winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers).boxed()
                .collect(Collectors.toList());
    }

    private void validateSize(int[] winningLottoNumbers) {
        if (winningLottoNumbers.length < DEFAULT_SIZE) {
            throw new IllegalArgumentException("당첨 번호의 개수가 알맞지 않습니다.");
        }
    }

    private void validateElements(List<Integer> winningLottoNumbers) {
        for (int i = 0; i < winningLottoNumbers.size(); i++) {
            int number = winningLottoNumbers.get(i);
            if (number < LottoNumber.LOTTO_NUMBER_MIN || number > LottoNumber.LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException("당첨 번호의 범위가 알맞지 않습니다.");
            }
        }
    }

    private void validateOverlap(List<Integer> convertedList) {
        convertedList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().forEach(count -> {
                    if(count > 1) throw new IllegalArgumentException("중복 되는 값이 존재합니다.");
                });
    }
}
