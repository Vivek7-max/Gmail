package module1;

import java.util.Random;

import org.testng.annotations.Test;

public class GenerateRandomNumber {
	@Test
	public void GenerateRandomNumber() {
		 // Create an instance of the Random class
        Random random = new Random();
        
        // Generate a random number between 1 and 500 (inclusive)
        int randomNumber1 = random.nextInt(500) + 1;
        int randomNumber2 = random.nextInt(500) + 1;
        int randomNumber3 = random.nextInt(500) + 1;
        // Print the generated random number
        System.out.println("Random Number: " + randomNumber1);
        System.out.println("Random Number: " + randomNumber2);
        System.out.println("Random Number: " + randomNumber3);
	}
}
