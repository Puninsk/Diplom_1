import burgerTasty.Bun;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class BunTest {
    private Bun bun;

    @Test
    public void getBunName() {
        bun = new Bun("Краторная булка", 135.00f);
        String expectBunName = "Краторная булка";
        String actualBunName = bun.getName();
        Assert.assertEquals(expectBunName, actualBunName);
    }
    @Test
    public void getBunPrice() {
        bun = new Bun("Краторная булка", 135.00f);
        float expectBunPrice = 135.00f;
        float actualBunPrice = bun.getPrice();
        Assert.assertEquals(expectBunPrice, actualBunPrice, 0.1);
    }
    @Test
    public void getNameNull() {
        bun = new Bun(null, 100);
        assertNull(bun.getName());
    }
    @Test
    public void getNameEmpty() {
        bun = new Bun("", 25);
        String expectBunName = "";
        String actualBunName = bun.getName();
        Assert.assertEquals(expectBunName, actualBunName);
    }
    @Test
    public void getPriceNegativeTest() {
        Bun bun = new Bun("ржаная булочка", -25.1f);
        float expectBunPrice = -25.1f;
        float actualBunPrice = bun.getPrice();
        Assert.assertEquals(expectBunPrice, actualBunPrice, 0.1);
    }

}