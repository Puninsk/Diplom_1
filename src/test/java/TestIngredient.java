import burgerTasty.Ingredient;
import burgerTasty.IngredientType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredient {
    private final IngredientType type;
    private final String name;
    private final float price;

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
        public static Object[][] getIngridientData() {
            return new Object[][]{
                    {IngredientType.SAUCE, "Кетчуп", 50.00f},
                    {IngredientType.SAUCE, "Соус космический", 100.00f},
                    {IngredientType.FILLING, "Биокотлета", 1500.00f},
                    {IngredientType.FILLING, "Филе", 1000.00f},
            };
        }
    @Test
    public void getPriceNegative() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "сальса", -10000.1f);
        assertEquals(-10000.1f, ingredient.getPrice(), 0.001);
    }
    @Test
    public void getNameEmptyNegative() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "", 1000.00f);
        assertEquals("", ingredient.getName());
    }
        @Test
        public void getPriceIngredient() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals(price, ingredient.getPrice(), 0.1);
        }
        @Test
        public void getNameIngredient() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals(name, ingredient.getName());
        }
        @Test
        public void getTypeIngredient() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals(type, ingredient.getType());
        }
    }
