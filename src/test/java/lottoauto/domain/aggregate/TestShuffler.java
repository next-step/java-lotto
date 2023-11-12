package lottoauto.domain.aggregate;

import java.util.List;

public class TestShuffler implements CustomShuffle {

    private static int shuffleTry = 0;

    @Override
    public List<Integer> makeShuffle() {
        List<Integer> first = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> second = List.of(11, 12, 13, 14, 15, 16);
        List<Integer> third = List.of(21, 22, 23, 24, 25, 26);

        List<List<Integer>> returnList = List.of(first, second, third);

        List<Integer> result = returnList.get(shuffleTry % 3);
        shuffleTry += 1;
        return result;
    }
}
