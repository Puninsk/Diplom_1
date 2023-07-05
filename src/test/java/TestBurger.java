import burgerTasty.Bun;
import burgerTasty.Burger;
import burgerTasty.Ingredient;
import burgerTasty.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bunFake;
    @Mock
    Ingredient ingredientFirstFake;
    @Mock
    Ingredient ingredientSecondFake;
    @Mock
    Ingredient ingredientThirdFake;
    @Test
    public void setBunsBurger() {
        Burger burger = new Burger();
        burger.setBuns(bunFake);
        assertEquals(bunFake, burger.bun);
    }

    @Test
    public void setBunsNullBurger() {
        Burger burger = new Burger();
        burger.setBuns(null);
        assertNull(burger.bun);
    }
    @Test
    public void addIngredientBurger() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirstFake);
        assertEquals(ingredientFirstFake, burger.ingredients.get(0));
    }
    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirstFake);
        burger.addIngredient(ingredientSecondFake);
        burger.addIngredient(ingredientThirdFake);
        burger.removeIngredient(0);
        assertEquals(Arrays.asList(ingredientSecondFake, ingredientThirdFake), burger.ingredients);
    }

    @Test
    public void changeIngredientBurger() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirstFake);
        burger.addIngredient(ingredientSecondFake);
        burger.addIngredient(ingredientThirdFake);
        burger.moveIngredient(0,1);
        burger.removeIngredient(0);
        assertEquals(Arrays.asList(ingredientFirstFake, ingredientThirdFake), burger.ingredients);
    }

    @Test
    public void getPriceBurger() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirstFake);
        burger.addIngredient(ingredientSecondFake);
        burger.setBuns(bunFake);
        float expectedPrice = 650.00f;
        Mockito.when(bunFake.getPrice()).thenReturn(200.00f);
        Mockito.when(ingredientFirstFake.getPrice()).thenReturn(100.00f);
        Mockito.when(ingredientSecondFake.getPrice()).thenReturn(150.00f);
        assertEquals(expectedPrice, burger.getPrice(), 0.1);
    }
    @Test
    public void getReceiptTextCorrect() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirstFake);
        burger.addIngredient(ingredientSecondFake);
        burger.setBuns(bunFake);
        String expectedReceipt = "(==== Краторная булка ====)\n= sauce Spicy =\n= filling Филе Люминесцентное =\n(==== Краторная булка ====)\n\nPrice: 1500.000000\n";
        Mockito.when(bunFake.getName()).thenReturn("Краторная булка");
        Mockito.when(bunFake.getPrice()).thenReturn(200.00f);
        Mockito.when(ingredientFirstFake.getName()).thenReturn("Spicy");
        Mockito.when(ingredientFirstFake.getPrice()).thenReturn(100.00f);
        Mockito.when(ingredientFirstFake.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSecondFake.getName()).thenReturn("Филе Люминесцентное");
        Mockito.when(ingredientSecondFake.getPrice()).thenReturn(1000.00f);
        Mockito.when(ingredientSecondFake.getType()).thenReturn(IngredientType.FILLING);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
