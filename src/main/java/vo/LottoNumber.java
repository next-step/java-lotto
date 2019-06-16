package vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();

    static {
        for (int i = 1; i < 46; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private final int no;

    private LottoNumber(int no) {
        if (no < 1 || no > 45) {
            throw new IllegalArgumentException();
        }
        this.no = no;
    }

    public static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }
        return of(Integer.parseInt(value.trim()));
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNos.get(number))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return String.valueOf(no);
    }
}
