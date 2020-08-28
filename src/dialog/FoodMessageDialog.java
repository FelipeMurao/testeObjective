package dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Food;

public class FoodMessageDialog {
private static JFrame jFrame;
	
	public void startGameFoodDialog() {
		jFrame = new JFrame();
		JOptionPane.showMessageDialog(jFrame, "Pense em um prato que gosta.");
	}
	
	public boolean tryAgainFoodDialog() {
		jFrame = new JFrame();
		int result = JOptionPane.showConfirmDialog(jFrame, 
				"Gostaria de tentar novamente?", 
				"Confirm",
				JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	public void gotItFoodDialog() {
		jFrame = new JFrame();
		JOptionPane.showMessageDialog(jFrame, "Acertei denovo!");
	}
	
	public Food createFoodDialog(String currentName) {
		jFrame = new JFrame();
		String foodName = JOptionPane.showInputDialog(jFrame, 
				"Qual prato você pensou?", 
				"Desisto", 
				JOptionPane.QUESTION_MESSAGE);
		
		String foodCharacteristic = JOptionPane.showInputDialog(jFrame, 
				foodName + " é ________ mas " + currentName + " não.", 
				"Complete",
				JOptionPane.QUESTION_MESSAGE);
		
		Food newFood = new Food(foodName, foodCharacteristic);
		return newFood;
	}
	
	
	
	public boolean questionCharacteristicFoodDialog(String currentCharacteristicFood) {
		jFrame = new JFrame();
		int result = JOptionPane.showConfirmDialog(jFrame, 
				"O prato que você pensou é " + currentCharacteristicFood +"?", 
				"Confirm",
				JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			return true;
		} 
		else 
			return false;
	}
	
	public void questionNameFoodDialog(String currentFoodName, Food currentFood, boolean userChoice) {
		jFrame = new JFrame();
		int result = JOptionPane.showConfirmDialog(jFrame, 
				"O prato que você pensou é " + currentFoodName +"?", 
				"Confirm",
				JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			gotItFoodDialog();
			return;
		} else {
			Food newFood = createFoodDialog(currentFoodName);
			if(userChoice) {
				currentFood.setNextFoodYes(newFood);
				return;
			} else {
				currentFood.setNextFoodNo(newFood);
				return;
			}
		}
	}
}
