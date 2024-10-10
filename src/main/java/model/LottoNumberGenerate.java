package model;

import java.util.List;

public interface LottoNumberGenerate {
    List<List<Integer>> multiGenerate(int start, int end);

    List<Integer> generate();
}
