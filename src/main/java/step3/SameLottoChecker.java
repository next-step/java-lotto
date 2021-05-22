package step3;

public class SameLottoChecker {


    public static boolean isSameLotto(Lotto l1, Lotto l2) {
        l1.sort();
        l2.sort();
        return l1.equals(l2);
    }
}
