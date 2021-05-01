package test.function;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Can check 3 things so far:
 * <ol>
 *     <li>{@code x.clone != x}</li>
 *     <li>{@code x.clone().getClass() == x.getClass()}</li>
 *     <li>{@code x.clone().equals(x)}</li>
 * </ol>
 */

public enum clone {
    ;

    private static String not_public(IllegalAccessException e) { return e.getLocalizedMessage() + " is not public"; }

    private static String not_implemented(NoSuchMethodException e) { return e.getLocalizedMessage() + " is not implemented"; }

    /**
     * @throws IllegalAccessException Should not normally happen since we made the method accessible.
     * @throws NoSuchMethodException  This will happen with primitives. All Objects inherit clone, I don't know if any object can exists without having the method clone. If that is the case, then this exception should only occur with primitives.
     */
    private static <X> X clone(final X x) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method cloneMethod = x.getClass().getDeclaredMethod("clone");
        cloneMethod.setAccessible(true);
        return (X) cloneMethod.invoke(x);
    }


    /**
     * Verifies that {@code x.clone != x}
     */
    public static <X> void is_not_object_being_cloned(final X x) {
        try { assertTrue(clone(x) != x); }
        catch (NoSuchMethodException e) { fail(not_implemented(e), e); }
        catch (IllegalAccessException e) { fail(e); }
        catch (InvocationTargetException e) { fail(e); }
    }

    /**
     * Verifies that {@code x.clone().getClass() == x.getClass()}
     */
    public static <X> void class_is_class_of_object_being_cloned(final X x) {
        try { assertTrue(clone(x).getClass() == x); }
        catch (NoSuchMethodException e) { fail(not_implemented(e), e); }
        catch (IllegalAccessException | InvocationTargetException e) { fail(e); }
    }

    /**
     * @return {@code x.clone().equals(x)}
     */
    public static <X> void equals_object_being_cloned(final X x) {
        try { assertTrue(clone(x).equals(x));}
        catch (NoSuchMethodException e) { fail(not_implemented(e), e);}
        catch (IllegalAccessException | InvocationTargetException e) { fail(e); }
    }
}