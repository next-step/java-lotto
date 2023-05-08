package step2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommaParser implements Parser{
    private static final String DELIMITER = ",";

    @Override
    public List<Integer> parseLottoNumbers(String sringOfLottoNumbers) {
        Set<Integer> lottoNumbers = new HashSet<>();
        for (String token : sringOfLottoNumbers.split(DELIMITER)) {
            lottoNumbers.add(Integer.parseInt(token.trim()));
        }
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
