package block.pk;

public class block {
	
	public	int index;
	public	String previous_hash;
	public	String hash;
	public	String data;
	public 	long Nonce;

	public	block() {
			this.index = 0;
			this.previous_hash = "0";
			this.data = "Welcome to block 0";
			this.hash = "0";
			this.Nonce = 0;
	}
	public block(int _index, String _previous_hash, String _hash, String _data, long _Nonce)
		{
			this.index = _index;
			this.previous_hash = _previous_hash;
			this.data = _data;
			this.hash = _hash;
			this.Nonce = _Nonce;
	}

	public String getHash() {
		String hash_input = Integer.toString(this.index) + this.previous_hash + this.data + this.Nonce;
		return hash_input.substring(0, 8);
	}
	
	
	public static block getGenesisBlock() {
		sha256 cryp = new sha256();
		String data = "Block genesis index 0";
		String previous_hash = "0";
		long nonce = 0;
		String hash = cryp.getHash(Integer.toString(0) + previous_hash + data + nonce);	
		block bl = new block(0, previous_hash, hash, data, nonce);
		return bl;
	}


	public boolean isValidNewBlock (block new_block, block previous_block) {
	    if (previous_block.index + 1 != new_block.index) {
	        System.out.println("invalid index");
	        return false;
	    } else if (previous_block.hash.compareTo(new_block.previous_hash) != 0) {
	    	System.out.println("invalid previous hash");
	        return false;
	    } else if (new_block.getHash().compareTo(new_block.hash) != 0) {
	    	System.out.println("invalid hash: " + new_block.getHash() + " " + new_block.hash);
	        return false;
	    }
	    return true;
	};

	public void PrintBlock() {
		System.out.print("[Block: " + this.index + "]");
		System.out.print(", P-hash: " + this.previous_hash);
		System.out.print(", Data: " + this.data);
		System.out.println(", Hash: " + this.hash);
		
		
	}
	
	public static void PrintBlockchain(block [] blockchain, int length)
	{
		for (int i = 0; i < length - 1; i++) {
			System.out.println("Block: " + blockchain[i].index + " (" + blockchain[i].hash + ")");
			System.out.println("|");
			System.out.println("v");
			
		}
		System.out.println("Block: " + blockchain[length -1].index + " (" + blockchain[length -1].hash + ")");
		
		
	}
};



