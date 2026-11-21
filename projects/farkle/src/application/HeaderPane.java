package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class HeaderPane extends StackPane {
	
	// Constructor for HeaderPane
	public HeaderPane(){		
		setMinWidth(LayoutConstants.APP_WIDTH); // Set minimum width
		setMinHeight(LayoutConstants.HEADER_PANE_HEIGHT); // Set minimum height
		setTranslateX(LayoutConstants.APP_WIDTH / 2); // Set translation X
		setTranslateY(LayoutConstants.HEADER_PANE_HEIGHT / 2); // Set translation Y
		
		// Create a rectangle for background
		Rectangle box = new Rectangle(LayoutConstants.APP_WIDTH, LayoutConstants.HEADER_PANE_HEIGHT);
		box.setFill(Color.DARKGREY); // Set fill color
		
		// Create a label for header text
		Label label = new Label("Welcome to Farkle!"); // Set label text
		label.setMinWidth(LayoutConstants.APP_WIDTH); // Set minimum width
		label.setMinHeight(LayoutConstants.HEADER_PANE_HEIGHT); // Set minimum height
		label.setAlignment(Pos.CENTER); // Set alignment to center
		label.setFont(Font.font(24)); // Set font size
		
		// Add the rectangle and label to the stack pane
		getChildren().addAll(box, label);
	}
}
