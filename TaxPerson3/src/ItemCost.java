
public class ItemCost {
	private String itemName;
	private int itemUnitPrice;
	private int quantity;
	
	public enum ItemType {
		necessaryItem(1), luxuryItem(9);
		private int value;
		
		private ItemType(int value) {
			this.value = value;
		}
	}
	
	public ItemCost ( String itemName, int uPrice, int quantity ) {
		this.itemName = itemName;
		this.itemUnitPrice = uPrice;
		this.quantity =  quantity;
	}
	
	public int caculateItemCost (ItemCost icost,  ItemType itemType ) {
		if ( icost == null || itemType == null ) {
			throw new IllegalArgumentException("inputs is null");
		}
		int cost = icost.itemUnitPrice * icost.quantity;
		int taxBase = cost * itemType.value;
		int taxRemainder = taxBase % 100;
		if ( taxRemainder >= 50 ) { 
			cost += taxBase / 100 + 1;
		} else {
			cost += taxBase / 100;
		}
		
		System.out.println ( "taxRemainder = " + taxRemainder + " cost = " + cost );
		return cost;
	}
	
	public static void main ( String argv[] ) {
		for (ItemType anItem : ItemType.values()) {
			System.out.println ( "Item name ==> " + anItem.name() + " Item value = " + anItem.value);
		}
		
		//ItemCost iCost = new ItemCost("book", 499, 1);
		System.out.println( );
		System.out.println( " == test case1  == ");
		ItemCost iCost = new ItemCost("TV", 499, 9);
		System.out.println( " for iCost, its Name == " + iCost.itemName );
		System.out.println( " for iCost, its caculated Item Cost == " + iCost.caculateItemCost(iCost, ItemType.necessaryItem) );

		System.out.println( " == test case2  == ");
		iCost = new ItemCost("book", 429, 1); 
		System.out.println( " for iCost, its Name == " + iCost.itemName );
		System.out.println( " for iCost, its caculated Item Cost == " + iCost.caculateItemCost(iCost, ItemType.luxuryItem) );
	}

}
