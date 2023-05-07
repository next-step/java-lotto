package step3.param;


import java.util.Objects;

public class ManualLottoNumberParam {
    int lottoNumber;

    public ManualLottoNumberParam(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static ManualLottoNumberParam from (int lottoNumber) {
        return new ManualLottoNumberParam(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualLottoNumberParam that = (ManualLottoNumberParam) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
