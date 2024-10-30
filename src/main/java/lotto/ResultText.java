package lotto;

import java.util.List;

public enum ResultText {
    NON(List.of(1,3,4,5),"%d개 일치 (%d원)- %d개\n"),
    BONUS(List.of(2),"%d개 일치, 보너스 볼 일치(%d원)- %d개\n");

    private List<Integer> rank;
    private String printText;


    ResultText(List<Integer> rank, String printText) {
        this.rank = rank;
        this.printText = printText;
     }

    public static String convertRankToText(int rank) {
        for (ResultText resultText : values()) {
            if (resultText.rank.contains(rank)) {
                return resultText.printText;
            }
        }
        return NON.printText;
    }


}
