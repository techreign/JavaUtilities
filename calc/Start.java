package materials;


import javafx.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;


@SuppressWarnings("restriction")
public class Start extends Application {
	
	private static int value = 0;
	static TextField number = new TextField("0");
	Calculator calculator = new Calculator();
	public boolean numChange = true;
	public int num;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		number.setPrefSize(200.0, 10.0);
		
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		// creating the button
		Button zero = new Button("0");
		Button one = new Button("1");
		Button two = new Button("2");
		Button three = new Button("3");
		Button four = new Button("4");
		Button five = new Button("5");
		Button six = new Button("6");
		Button seven = new Button("7");
		Button eight = new Button("8");
		Button nine = new Button("9");
		Button decimal = new Button(".");
		Button equal = new Button("=");
		Button plus = new Button("+");
		Button minus = new Button("-");
		Button multiply = new Button("*");
		Button divide = new Button("/");
		Button clear = new Button("CE");

		
		// adding the event handlers to the buttons
		zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 0;
    			update(num);
            }
        });
		
		one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 1;
    			update(num);
            }
        });
		
		two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 2;
    			update(num);
            }
        });
		
		three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 3;
    			update(num);
            }
        });
		
		four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 4;
    			update(num);
            }
        });
		
		five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 5;
    			update(num);
            }
        });
		
		six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 6;
    			update(num);
            }
        });
		
		seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 7;
    			update(num);
            }
        });
		
		eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 8;
    			update(num);
            }
        });
		
		nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			num = 9;
    			update(num);
            }
        });
		
		clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			reset();
            }
        });
		
		equal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			change(calculator.equal());
            }
        });
		
		plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			calculator.plus();
            }
        });
		
		minus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			calculator.minus();
            }
        });
		
		multiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			calculator.multiply();
            }
        });
		
		divide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    			calculator.divide();
            }
        });
		
		// adding the buttons to the grid
		grid.add(number, 1, 1,5,1);		
		grid.add(zero, 2, 13);
		grid.add(one, 2, 11);
		grid.add(two, 3, 11);
		grid.add(three, 4, 11);
		grid.add(four, 2, 9);
		grid.add(five, 3, 9);
		grid.add(six, 4, 9);
		grid.add(seven, 2, 7); 
		grid.add(eight, 3, 7);
		grid.add(nine, 4, 7);
		grid.add(decimal, 3, 13);
		grid.add(equal, 4, 13);
		grid.add(plus, 5, 7);
		grid.add(minus, 5, 9);
		grid.add(multiply, 5, 11);
		grid.add(divide, 5, 13);
		grid.add(clear, 2, 5);

		Scene scene = new Scene(grid, 300, 350);
		
		// finalizing the stage
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static int getNumber(){
		return value;
	}
	
	public static void setNumber(int num){
		value = num;
	}
	
	public static void reset(){
		value = 0;
		update(0);
	}
	
	public static void update(int numb){
		String numberValue;
		if (value == 0){
			value = numb;  
			numberValue = Integer.toString(value);
		}
		else {
			numberValue = Integer.toString(value) + numb;
			value = Integer.valueOf(numberValue);
		}
		number.setText(numberValue);

	}
	
	public void change(int numb){
		number.setText(Integer.toString(numb));
		value = numb;
		
	}
	
	public static void main( String args[]){
		launch(args);		
	}

}
