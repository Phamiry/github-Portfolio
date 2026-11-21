package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MessagePane extends StackPane {
	
	private static Label message;
	
	public MessagePane(){	
		setMinWidth(LayoutConstants.APP_WIDTH);
		setMinHeight(LayoutConstants.HEADER_PANE_HEIGHT);
		setTranslateX(LayoutConstants.APP_WIDTH / 2);
		//@formatter:off
		setTranslateY(LayoutConstants.HEADER_PANE_HEIGHT + 
				LayoutConstants.SCORE_PANE_HEIGHT +
				(LayoutConstants.MESSAGE_PANE_HEIGHT / 2));
		//@formatter:on		
		message = new Label("Click Play to begin");
		message.setMinWidth(LayoutConstants.APP_WIDTH);
		message.setMinHeight(LayoutConstants.HEADER_PANE_HEIGHT);
		message.setAlignment(Pos.CENTER);
		message.setFont(Font.font(16));
		
		getChildren().addAll(message);
		}
	public static void updateMessage(String msg) {
		message.setText(msg);
	}
}