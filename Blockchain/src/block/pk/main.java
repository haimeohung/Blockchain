package block.pk;

import java.util.Scanner;

public class main {
	public static void main(final String args[])
	{
		block blockchain[] = new block[100];
		int i = 0;
		while (true)
		{
			System.out.println("1. Create new block by enter data, 2. Exit");
			Scanner NewScanner = new Scanner(System.in);
			int temp = NewScanner.nextInt();
			if (temp == 1) {
				blockchain[i] = new block();
				if (i == 0) {
					blockchain[i] = block.getGenesisBlock();	
					blockchain[i].PrintBlock();
				}
				else {
					System.out.print("Enter data: ");
					String data = NewScanner.next();
					blockchain[i] = block.getBlock(blockchain[i-1], data);
					blockchain[i].PrintBlock();
				}
				
				i++;
			}
			else block.PrintBlockchain(blockchain);
			
		}
		
		
	}
}
