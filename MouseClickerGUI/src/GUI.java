import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

public class GUI extends VBox{
    ButtonBar btns;
    TextField txtCount;
    Button left, right;

    public GUI(){

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(200, 100);

        txtCount = new TextField();
        txtCount.setMaxSize(30,50);

        btns = new ButtonBar();

        left = new Button();
        right = new Button();

        left.setText("<-");
        right.setText("->");
        left.setPrefSize(20,20);
        right.setPrefSize(20,20);

        btns.getButtons().add(left);
        btns.getButtons().add(right);

        this.getChildren().add(txtCount);
        this.getChildren().add(btns);
    }

    public int getCountTxtNum(){
        int countNum = 0;
        try {
            countNum = Integer.parseInt(txtCount.getText());
        }catch(NumberFormatException e){
            txtCount.setText(0+"");
        }
        return countNum;
    }

    public void addLeftHandler(EventHandler<ActionEvent> handler){
        left.setOnAction(handler);

    }

    public void addRightHandler(EventHandler<ActionEvent> handler){
        right.setOnAction(handler);
    }
}
