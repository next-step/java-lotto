package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinnersNo {
    private List<Integer> winnersResultNos;

    public WinnersNo(String input) {
        this.winnersResultNos = getWinnersResultNo(input);
    }

    public static WinnersNo ofWinnersNo(String input) {
        return new WinnersNo(input);
    }

    static List<Integer> getWinnersResultNo(String input) {
        String removingSpacesWinnersNo = input.replaceAll(" ", "");
        return Arrays.stream(removingSpacesWinnersNo.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinnersResultNos() {
        return winnersResultNos;
    }
}
