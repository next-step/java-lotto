package lotto.model.generate;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class ManualLottoNumberGenerate implements LottoNumberGenerate {
    private String numbers;

    public ManualLottoNumberGenerate(String numbers) {
        if(numbers.isEmpty()) {
            throw new IllegalArgumentException("번호를 입력하세요.");
        }

        this.numbers = numbers;
    }

    @Override
    public Set<Integer> generate() {
        return new HashSet<>(getManualNumbers());
    }

    private List<Integer> getManualNumbers() {
        String[] number = numbers.replace(" ", "").split(",");

        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < number.length; i++) {
            numbers.add(Integer.parseInt(number[i]));
        }
        return numbers;
    }
}
