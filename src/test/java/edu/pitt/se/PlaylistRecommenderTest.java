package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class PlaylistRecommenderTest {

    @Test
    public void placeholder() {
        assertTrue(true);
    }

    @Test
    void test_ValidList() {
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(50, 90, 85))));

        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(115, 130, 120)))); 

        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(150, 145, 160, 175))));
    }
    @Test
    void test_EdgeCaseLists() {
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(99))));

        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(100))));

        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(101))));

        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(139))));

        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(140))));

        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(
                new ArrayList<>(java.util.List.of(141))));
    }
    @Test
    void test_EmptyList() {
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(new ArrayList<>()));
    }
    @Test
    void test_NullList() {
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
    }


    @Test
    void test_ValidCases() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Downtown"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("Down town"));
    }

    @Test
    void test_EdgeCases() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(""));
        assertTrue(PlaylistRecommender.isValidTrackTitle("A"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    void test_invalidCases() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));           
        assertFalse(PlaylistRecommender.isValidTrackTitle("   "));          
        assertFalse(PlaylistRecommender.isValidTrackTitle("5 More Minutes"));      
        assertFalse(PlaylistRecommender.isValidTrackTitle("Scream!"));  
    }

    @Test
    void test_ValidRange() {
        assertEquals(43, PlaylistRecommender.normalizeVolume(43));
    }

    @Test
    void test_clamped101() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(101));
    }
    @Test
    void test_clampedNegative() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-1));
    }
    @Test
    void test_clampedExtremes() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(999999));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-999999));
    }

}
