import org.junit.Test;
import static org.junit.Assert.*;
import burgerTasty.IngredientType;
public class TestIngredientType {

    @Test
    public void sauceIngredientTest() {
        assertEquals(0, IngredientType.SAUCE.ordinal());
    }
    @Test
    public void fillingIngredientTest() {
        assertEquals(1, IngredientType.FILLING.ordinal());
    }
}