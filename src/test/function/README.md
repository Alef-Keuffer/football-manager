## Unsimplified Expressions

The occurrence of unsimplified expressions is purposeful and is due to these main reasons:

1. It more naturally translates the logic of implications, equivalences or how it's usually written mathematically
2. Sometimes there is no "expected" value, both sides of an equation must be equal and there's no expectation on the "
   actual" value on the right side of the equation (e.g. right side of equals). The expectation is simply, that both
   sides be equal.
3. Some simplifications are "wrong"

   For example, the IDE offers to simplify:
    ```java
    assertFalse(x.equals(null));
    ```
   to

    ```java
    assertFalse(false);
    ```
   But when trying to find the cause, it's because
   `According to hard-coded contract, method 'equals' returns 'false' value when parameter == nul`

   Which is exactly what we are trying to test. If we override the method, we should follow its contract.



