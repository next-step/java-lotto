package domain;

import view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    protected List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String numbers) {
        this(split(numbers)
                .map(v -> (new LottoNumber(toInt(v))))
                .collect(Collectors.toList()));
    }

    private static int toInt(String v) {
        return Integer.parseInt(v);
    }

    private static Stream<String> split(String number) {
        return Arrays.stream(number.split(", "));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoView toView() {
        return new LottoView(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
