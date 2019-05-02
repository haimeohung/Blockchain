package block.pk;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class Pair{
	public String hash;
	public long nonce;
	public Pair (String _hash, long _nonce)
	{
		this.hash = _hash;
		this.nonce = _nonce;
		
	}
}


public class miner {
	
	
	
	
	public static Pair FindNonce(block bl, int Difficult)
	{
		
		System.out.println("Antman is mining ...");
		int nonce = 0;
		String zero = "";
		for (int i = 0; i < Difficult; i++)
		{
			zero += "0";
		}
		while (true)
		{
			
			sha256 cryp = new sha256();
			int index = bl.index;
			String data = bl.data;
			String previous_hash = bl.previous_hash;
			
			String hash = cryp.getHash(Integer.toString(index) + previous_hash + data + nonce);
			if (hash.substring(0, Difficult).compareTo(zero) == 0)
			{
				Pair ans =  new Pair (hash, nonce);
				return ans;
			}
			else
			{
				nonce++;
			}		
		}
	}
	
	
	
	
	
}
