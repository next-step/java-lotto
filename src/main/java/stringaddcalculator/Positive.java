package stringaddcalculator;

/*
    Value Object
    "모든 원시값과 문자열을 포장한다."를 만족시키려면...어디에 써야할까...
*/
public class Positive {
    private int no;

    public Positive(int no) {
        if (no < 0)
            throw new IllegalArgumentException();
        this.no = no;
    }

    public Positive add(int no) {
        return new Positive(this.no + no);
    }
}
