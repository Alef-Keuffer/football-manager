package test.function;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class equals {
    /**
     * Checks if {@code x.equals(x) == true}
     *
     * @param x non-null value
     */

    public static <T> void is_reflexive(final T x) {
        assertNotNull(x);
        assertTrue(x.equals(x));
    }

    /**
     * Checks if {@code x.equals(y) == y.equals(x)}
     *
     * @param x non-null value
     * @param y non-null value
     */

    public static <X, Y> void is_symmetric(final X x, final Y y) {
        assertNotNull(x);
        assertNotNull(y);
        assertTrue((x.equals(y) == y.equals(x)));
    }

    /**
     * Checks that {@code x.equals(z)} whenever {@code x.equals(y) && y.equals(z)}
     * Mathematically, x == y ∧ y == z ⟹ x == z
     *
     * @param x non-null value
     * @param y non-null value
     * @param z non-null value
     */

    public static <X, Y, Z> void is_transitive(final X x, final Y y, final Z z) {
        assertNotNull(x);
        assertNotNull(y);
        assertNotNull(z);
        assertTrue(x.equals(y) && y.equals(z) ? x.equals(z) : true);
    }

    //provided no information used in equals comparisons on the objects is modified.
    public static <X, Y> void is_consistent(final X x, final Y y) {
        assertNotNull(x);
        assertNotNull(y);
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
        assertTrue(x.equals(y));
    }

    /**
     * Mathematically, x != null
     *
     * @param x non-null value
     */
    @Test
    public static <X> void is_always_false_when_compared_to_null(final X x) {
        assertNotNull(x);
        assertFalse(x.equals(null));
    }
}
