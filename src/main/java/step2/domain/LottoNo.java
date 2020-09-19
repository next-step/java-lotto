package step2.domain;

import java.util.List;

public class LottoNo {

    int no1;
    int no2;
    int no3;
    int no4;
    int no5;
    int no6;

    public LottoNo(int no1, int no2, int no3, int no4, int no5, int no6) {
        this.no1 = no1;
        this.no2 = no2;
        this.no3 = no3;
        this.no4 = no4;
        this.no5 = no5;
        this.no6 = no6;
    }


    public boolean contains(int number) {
        if(no1 == number || no2 == number || no3 == number
                || no4 == number || no5 == number || no6 == number) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return no1 + ", "
                + no2 + ", "
                + no3 + ", "
                + no4 + ", "
                + no5 + ", "
                + no6;
    }
}
