/**
 * 
 */
package GUI.Finanzverwaltung;

import GUI.Bauteileverwaltung.GUIBauteile;
import GUI.Bauteileverwaltung.GUIKategorie;
import GUI.Bauteileverwaltung.GUINutzerverwaltung;
import GUI.Bauteileverwaltung.GUIWarenkorb;
import Logic.Person;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.VBox;

/**
 * @author Nico Rychlik
 *
 */

public class GUIFinanzverwaltung {
	
	Tab tab;
	boolean admin;
	Person nutzer;
	
	public GUIFinanzverwaltung(Tab tab, boolean admin, Person nutzer) {
		this.tab=tab;
		this.admin=admin;
		this.nutzer=nutzer;
	}
	
	public void open() {	
		TabPane tp =new TabPane();
		SingleSelectionModel<Tab> selectionModel = tp.getSelectionModel();
		
		Tab tb1 = new Tab("Rechnungen");			
		Tab tb2 = new Tab("Toepfe");			
		Tab tb3 = new Tab("Kassen");			
		
		tp.getTabs().addAll(tb1, tb2, tb3);
		
		new GUIWarenkorb(tb1, nutzer).open();
		new GUIKategorie(tb2).open();
		new GUIBauteile(tb3).open();
		
		tp.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			if(newTab.equals(tb1)) new GUIWarenkorb(tb1, nutzer).open();
			if(newTab.equals(tb2)) new GUIKategorie(tb2).open();
			if(newTab.equals(tb3)) new GUIBauteile(tb3).open();
	    });
		
		if(!admin) {
			tb1.disableProperty().set(true);
			tb2.disableProperty().set(true);
			tb3.disableProperty().set(true);
			selectionModel.select(0);
		}
		
		VBox v1 =new VBox();
		v1.getChildren().addAll(tp);
		
		
	    tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tab.setContent(tp);
	}
}