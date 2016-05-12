import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class ItemCostTest {
	@Test
	public void testForLuxuryItem() {
		ItemCost iCost = new ItemCost("book", 429, 1);
		int cost = iCost.caculateItemCost(iCost, ItemCost.ItemType.luxuryItem );
		Assert.assertEquals(468, cost);
		//fail("Not yet implemented");
	}

	@Test
	public void testForNecessaryItem() {
		ItemCost iCost = new ItemCost("book", 429, 1);
		int cost = iCost.caculateItemCost(iCost, ItemCost.ItemType.necessaryItem );
		Assert.assertEquals(433, cost);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testForTaxRounding() {
		ItemCost iCost = new ItemCost("book", 70, 8);
		int cost = iCost.caculateItemCost(iCost, ItemCost.ItemType.necessaryItem );
		Assert.assertEquals(566, cost);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testFor0Price() {
		ItemCost iCost = new ItemCost("book1", 0, 1);
		int cost = iCost.caculateItemCost(iCost, ItemCost.ItemType.luxuryItem );
		Assert.assertEquals(0, cost);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testFor0Quantity() {
		ItemCost iCost = new ItemCost("book1", 12, 0);
		int cost = iCost.caculateItemCost(iCost, ItemCost.ItemType.necessaryItem );
		Assert.assertEquals(0, cost);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testForfailureOnItemCost() {
		try {
		ItemCost iCost = null;
		int cost = iCost.caculateItemCost(iCost, ItemCost.ItemType.necessaryItem );
		fail("Should not be here.");
		} catch ( Exception e ) {
			Assert.assertNotNull(e);
		}
	}
	
	@Test
	public void testForfailureOnItemType() {
		try {
			ItemCost iCost = new ItemCost("TV", 499, 9);
			int cost = iCost.caculateItemCost(iCost, null );
			fail("Should not be here.");
		} catch ( Exception e ) {
			Assert.assertNotNull(e);
		}
	}
}
