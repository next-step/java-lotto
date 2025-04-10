package model;

import java.util.ArrayList;
import java.util.List;

public class Placements {
    private final List<Placement> placements;
    private final int[] placementCounts;

    public Placements(List<Placement> placements, List<Integer> placementCounts) {
        this.placements = placements;
        this.placementCounts = new int[placements.size()];
    }

    public void insertPlacement(int placement) {
        placementCounts[placement]++;
    }
}
