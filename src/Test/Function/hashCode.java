package Test.Function;

import static org.junit.jupiter.api.Assertions.*;

public enum hashCode {;
    public static <X> void is_consistent(X x){
        assertSame(x.hashCode(),x.hashCode());
        assertSame(x.hashCode(),x.hashCode());
        assertSame(x.hashCode(),x.hashCode());
    }
    public static <X,Y> void is_the_same_for_two_equal_objects(X x, Y y){
        assertTrue(x.equals(y) || y.equals(x) ? x.hashCode() == y.hashCode() : true);
    }
}
