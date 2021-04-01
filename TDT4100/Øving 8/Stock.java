package patterns.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {

		private String code;
		private double price;
		List<StockListener> listeners;
		
		public Stock(String code, double price) {
			this.price = price;
			this.code = code;
			listeners = new ArrayList<>();
		}
		
		public void setPrice(double price) {
			if(price <= 0) {
				throw new IllegalArgumentException();
			}
			
			if(this.price != price) {
				for(StockListener listener : listeners) {
					listener.stockPriceChanged(this, this.price, price);
				}
				this.price=price;
			}
			
		}
		
		public String getTicker() {
			return code;
		}
		
		public double getPrice() {
			
			return price;
		}
		
		public void addStockListener(StockListener listener) {
			listeners.add(listener);
		}
		
		public void removeStockListener(StockListener listener) {
			listeners.remove(listener);
		}
	}
