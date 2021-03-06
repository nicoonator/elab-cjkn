/**
 * 
 */
package GUI.Bauteileverwaltung;

import java.sql.SQLException;
import Exceptions.DatabaseException;
import GUI.AlertBox;
import GUI.Validation.Validation;
import Logic.Bauteileverwaltung;
import Logic.Kategorie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * @author Nico Rychlik
 *
 */
public class GUIKategorie {
	Tab tab;
	TableView<Kategorie> table;
	
	public GUIKategorie(Tab tab) {
		this.tab=tab;
	}
	
	@SuppressWarnings("unchecked")
	public void open() {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10,10,10,10));
		// Start of TOP
		
		HBox top = new HBox();
		top.setSpacing(10);
		top.setPadding(new Insets(10,10,10,10));
		
		Button create = new Button("Neu");
		Button modify = new Button("Umbenennen");
		Button delete = new Button("Loeschen");
		
		modify.setDisable(true);
		delete.setDisable(true);
		
		top.getChildren().addAll(create, modify, delete);
		
		bp.setTop(top);
		
		// End of TOP
		
		// Start of LEFT
		
		TableColumn<Kategorie, String> katNameColumn = new TableColumn<>("Kategorie");
		//vornameColumn.setMinWidth(100);
		katNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Kategorie, Integer> katIDColumn = new TableColumn<>("ID");
		//nachnameColumn.setMinWidth(100);
		katIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));

		table = new TableView<>();
		try {
			table.setItems(getKategorien());
		} catch (SQLException e2) {
			AlertBox.display("Fehler", e2.getMessage());
		}
		table.getColumns().addAll(katNameColumn, katIDColumn);

		table.setPrefWidth(150);
		bp.setLeft(table);
		
		// End of LEFT
		
		// Start of Center
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setAlignment(Pos.BASELINE_CENTER);
		grid.setVgap(8);
		grid.setHgap(10);
		
		TextField tfKatName = new TextField();
		tfKatName.setDisable(true);
		GridPane.setConstraints(tfKatName, 1, 0);
		
		Label katName = new Label("Name: ");
		GridPane.setConstraints(katName, 0, 0);
		
		grid.getChildren().addAll(tfKatName,katName);
		bp.setCenter(grid);
		
		// End of Center
		
		//Events:
		
		
		//CreateKategorie Fenster erstellen
		create.setOnMouseClicked(e -> {
			GUICreateKategorie.display();
			try {
				table.setItems(getKategorien());
			} catch (SQLException e1) {
				AlertBox.display("Fehler", e1.getMessage());
			}
			finally {
				modify.setDisable(true);
				delete.setDisable(true);
			}
		});
		
		//Kategorie bearbeiten
		modify.setOnMouseClicked(e -> {
			Kategorie tempKategorie = table.getSelectionModel().getSelectedItem();
			try {
				if(Validation.StringInputValidation(tfKatName)) {
					Bauteileverwaltung.getInstance().renameKategorie(tempKategorie.getID(), tfKatName.getText());
					AlertBox.display("Erfolg!", "Kategorie umbenannt!");
					table.setItems(getKategorien());
				}
			} catch (SQLException | DatabaseException e1) {
			AlertBox.display("Fehler", e1.getMessage());
			} finally {
				table.getSelectionModel().select(tempKategorie);
			}
			
		});
		
	
		//Kategorie loeschen
		delete.setOnMouseClicked(e-> {
			Kategorie tempKategorie = table.getSelectionModel().getSelectedItem();
			try {
				Bauteileverwaltung.getInstance().deleteKategorie(tempKategorie.getID());
				table.setItems(getKategorien());
				tfKatName.clear();
				modify.setDisable(true);
				delete.setDisable(true);
				AlertBox.display("Erfolg!", "Kategorie geloescht!");
			} catch (SQLException | DatabaseException e1) {
				AlertBox.display("Fehler", e1.getMessage());
			}
		});
		
		
		//Handling fuer Klick auf Tabelleneintrag
		table.setOnMouseClicked(e -> {
			if(!(table.getSelectionModel().isEmpty())) {
				tfKatName.setDisable(false);
				delete.setDisable(false);
				modify.setDisable(false);
				Kategorie tempKategorie = table.getSelectionModel().getSelectedItem();
				bp.setCenter(grid);
				tfKatName.setText(tempKategorie.getName());
				tfKatName.setStyle(null);
			}
		});

		tab.setContent(bp);
	}

	/**
	 * Holt alle Kategorien aus der Datenbank
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static ObservableList<Kategorie> getKategorien() throws SQLException {
		ObservableList<Kategorie> result = FXCollections.observableArrayList();
		for (Kategorie k :  Bauteileverwaltung.getInstance().getAllKategorie()) {
			result.add(k);
		}
		return result;
	}
	
}