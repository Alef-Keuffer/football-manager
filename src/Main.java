import test.function.equals;
import org.junit.jupiter.api.Test;

class Joc {
    int a;

    public Joc(int a) {
        this.a = a;
    }

    public boolean equals(Object x){
        return true;
    }

}

public class Main {
    @Test
  public static void main(String[] args) {
      Joc joc = new Joc(10);
        System.out.println(joc.equals(null));
      equals.is_always_false_when_compared_to_null(joc);
  }
}
