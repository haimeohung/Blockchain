package block.pk;

import java.util.Scanner;

public class main {
	public static void main(String args[]) 
	{
		double reward = 50;
		block blockchain[] = new block[100];
		for (int j = 0; j < 100; j++)
		{
			blockchain[j] = new block();
		}
		int i = 0;
		while (true)
		{
			System.out.println("[1. Create new block, 2. Print blockchain, 3. Exit]");
			@SuppressWarnings("resource")
			Scanner NewScanner = new Scanner(System.in);
			int temp = Integer.parseInt(NewScanner.nextLine());
			if (temp == 1) {
				
				if (i == 0) {
					System.out.println("Create block Genesis ... ");
					blockchain[i] = block.getGenesisBlock();	
					blockchain[i].PrintBlock();
				}
				else {
					System.out.print("-> Enter data: ");
					String data;
					data = NewScanner.nextLine();
					
					blockchain[i].index = blockchain[i-1].index + 1;
					blockchain[i].previous_hash = blockchain[i-1].hash;
					blockchain[i].data = data;
					
					long current_time = System.currentTimeMillis();
					Pair ans = miner.FindNonce(blockchain[i], i+2);
					System.out.println("-------------------");
					System.out.println("Nonce: " + ans.nonce);
					long time = (System.currentTimeMillis() - current_time);
					System.out.println("Time: " + time + " ms");	
					System.out.println("Miner' s reward: " + reward + " BTC");	reward/=2;
					System.out.println("-------------------");
					
					blockchain[i].hash = ans.hash;
					
					
					blockchain[i].PrintBlock();

					
				}				
				i++;
			}
			if (temp == 2) {
				block.PrintBlockchain(blockchain, i);
			}
			if (temp == 3) {
				System.exit(0);
			}
			
		}
		
		
	}
}
