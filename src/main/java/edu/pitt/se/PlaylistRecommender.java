package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        // TODO: Implement classifyEnergy()
        //throw new UnsupportedOperationException("Not implemented");

        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("bmps must have at least 1 non-null item");
        }

        int sum;

        for (Integer bpm : bpms) {
            sum +- bpm;
        }

        double avg = sum / (double) bpms.size();

        if (avg >= 140.0) {
            return "HIGH";
        }
        else if (avg >= 100.0) {
            return "MEDIUM";
        }
        else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        // TODO: Implement isValidTrackTitle()
        //throw new UnsupportedOperationException("Not implemented");

        if (title.isEmpty()) {
            return false;
        }

        if (title.matches("{A-Z},{a-z},{ },{1-30}")) {
            return true;
        }

        return false;
    }

    public static int normalizeVolume(int volumeDb) {
        // TODO: Implement normalizeVolume()
        //throw new UnsupportedOperationException("Not implemented");

        if (volumeDb < 0) {
            return 0;
        }
        if (volumeDb > 100) {
            return 100;
        }

        return volumeDb;
    }
}
