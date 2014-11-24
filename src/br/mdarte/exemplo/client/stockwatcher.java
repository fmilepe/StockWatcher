package br.mdarte.exemplo.client;

import com.google.gwt.core.client.EntryPoint; 

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;

import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.ui.Button; 
import com.google.gwt.user.client.ui.FlexTable; 
import com.google.gwt.user.client.ui.HorizontalPanel; 
import com.google.gwt.user.client.ui.Label; 
import com.google.gwt.user.client.ui.TextBox; 
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.RootPanel;


public class stockwatcher implements EntryPoint {

	private VerticalPanel mainPanel = new VerticalPanel();  

	private FlexTable stocksFlexTable = new FlexTable();  

	private HorizontalPanel addPanel = new HorizontalPanel();  

	private TextBox newSymbolTextBox = new TextBox();  

	private Button addStockButton = new Button("Add");  

	private Label lastUpdatedLabel = new Label();

	/**  * Entry point method.  */  

	public void onModuleLoad() { 

		// Create table for stock data.  

		stocksFlexTable.setTitle("StockList");

		stocksFlexTable.setText(0, 0, "Symbol");  
		stocksFlexTable.setText(0, 1, "Price");  
		stocksFlexTable.setText(0, 2, "Change");  
		stocksFlexTable.setText(0, 3, "Remove");

		// Assemble Add Stock panel.
		addPanel.add(newSymbolTextBox);
		addPanel.add(addStockButton);

		// Assemble Main panel.
		mainPanel.add(stocksFlexTable);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);

		// Associate the Main panel with the HTML host page.
		RootPanel.get("stockList").add(mainPanel);

		// Move cursor focus to the input box.
		newSymbolTextBox.setFocus(true);

		// Listen for mouse events on the Add button.
		addStockButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addStock();
			}
		});

		// Listen for keyboard events in the input box.
		newSymbolTextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					addStock();
				}
			}
		});

	}

	private void addStock() {
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		newSymbolTextBox.setFocus(true);

		// Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
		if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			Window.alert("'" + symbol + "' is not a valid symbol.");
			newSymbolTextBox.selectAll();
			return;
		}

		newSymbolTextBox.setText("");

		// TODO Don't add the stock if it's already in the table.

		// TODO Add the stock to the table.

		// TODO Add a button to remove this stock from the table.

		// TODO Get the stock price.

	}

}