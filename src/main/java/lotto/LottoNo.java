package lotto;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class LottoNo {
    private static final int STARTED_NUMBER = 1;
    private static final int LIMITTED_NUMBER = 45;
    private static final HashMap<Integer, LottoNo> lottoNumbers = new HashMap<>();
    static {
        for(int i = 1; i <= LIMITTED_NUMBER; i++ ) {
            lottoNumbers.put(i, new LottoNo(i));
        }
    }
    private final int no;

    private LottoNo(int no) {
        if(no < STARTED_NUMBER || no > LIMITTED_NUMBER) throw new IllegalArgumentException();
        this.no = no;
    }

    public static LottoNo of(int no) {
        return Optional.ofNullable(lottoNumbers.get(no)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        LottoNo lottoNo = (LottoNo) obj;
        return Objects.equals(no, lottoNo.no);
    }

    @Override
    public String toString() {
        return "LottoNo[" + "no=" + no + "]";
    }
}
