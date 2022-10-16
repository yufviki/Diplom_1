package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void getNameShowNameBunTest(){
        Bun bun = new Bun("white bun", 50);

        String actualName = bun.getName();
        String expectedName = "white bun";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceShowPriceBunTest(){
        Bun bun = new Bun("black bun", 100);

        float actualPrice = bun.getPrice();
        float expectedPrice = 100;
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
