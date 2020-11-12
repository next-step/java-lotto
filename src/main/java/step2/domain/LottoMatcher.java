package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final List<Integer> lottoNumbers;

    public LottoMatcher(String input) {

        if(input == null){
            throw new IllegalArgumentException("널값을 넣을수는 없습니다.");
        }
        if(input.trim().isEmpty()){
            throw new IllegalArgumentException("빈값을 넣을수는 없습니다.");
        }
        String[] split = input.split(",");
        lottoNumbers = Arrays.stream(split)
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
