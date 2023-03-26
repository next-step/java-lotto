package lotto;


//3개 일치 (5000원)- 1개 - 5등
//4개 일치 (50000원)- 0개 - 4등
//5개 일치 (1500000원)- 0개 - 3등
//5개 일치, 보너스 볼 일치(30000000원) - 0개 - 2등?
//6개 일치 (2000000000원)- 0개 - 1등?
public enum LottoResult {
    FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE;
}
