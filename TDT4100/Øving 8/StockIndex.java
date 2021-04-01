package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements StockListener{
	private String name;
	private double index;
	private List<Stock> stocks;
	
	public StockIndex(String name, Stock... stocks) {
		this.name = name;
		index = 0;
		this.stocks = new ArrayList<>();
			
		for(Stock stock : stocks) {
			if(!this.stocks.contains(stock)) {
				index += stock.getPrice();
				this.stocks.add(stock);
				stock.addStockListener(this);
			}
		}
	}
	
	public double getIndex() {
		return index;
	}
	
	public String getName() {
		return name;
	}
	
	public void addStock(Stock stock) {
		if(!this.stocks.contains(stock)) {	
			index += stock.getPrice();
			stocks.add(stock);
			stock.addStockListener(this);
		}
	}
	
	public void removeStock(Stock stock) {
		if(this.stocks.contains(stock)) {	
			index -= stock.getPrice();
			stocks.remove(stock);
			stock.removeStockListener(this);
		}
	}

	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		index += newPrice - oldPrice;
	}
}
